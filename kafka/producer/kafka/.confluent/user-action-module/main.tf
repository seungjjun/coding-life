terraform {
  required_providers {
    confluent = {
      source  = "confluentinc/confluent"
      version = "1.50.0"
    }
  }
}

resource "confluent_kafka_topic" "user-action-data" {
  topic_name       = "user-action-data"
  partitions_count = var.user-action-data-partition-count
  config           = {
    "cleanup.policy"         = "delete" #default
    "delete.retention.ms"    = "604800000" #86400000 (1day) * 7
    "message.timestamp.type" = "CreateTime" #default
    "min.compaction.lag.ms"  = "0" #default value
    "min.insync.replicas"    = "2" #default value
    "retention.bytes"        = "-1" #default value
    "retention.ms"           = "604800000" #default value (7 day)
    "segment.bytes"          = "1073741824" #default value
    "segment.ms"             = "604800000" #default value (7 day)
  }
}

resource "confluent_subject_config" "user-action-key-schema-config" {
  subject_name        = "${confluent_kafka_topic.user-action-data.topic_name}-key"
  compatibility_level = "FORWARD"
}

resource "confluent_schema" "user-action-key-schema" {
  format       = "PROTOBUF"
  schema       = file("./proto/user-action-key.proto")
  subject_name = "${confluent_kafka_topic.user-action-data.topic_name}-key"
}

resource "confluent_subject_config" "user-action-value-schema-config" {
  subject_name        = "${confluent_kafka_topic.user-action-data.topic_name}-value"
  compatibility_level = "FORWARD"
}

resource "confluent_schema" "user-action-value-schema" {
  format       = "PROTOBUF"
  schema       = file("./proto/user-action-value.proto")
  subject_name = "${confluent_kafka_topic.user-action-data.topic_name}-value"
}