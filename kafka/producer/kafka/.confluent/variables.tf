variable "kafka_id" {
  type = string
  description = "Kafka Broker Id"
}

variable "kafka_rest_endpoint" {
  type = string
  description = "Kafka Broker Endpoint"
}

variable "kafka_api_key" {
  type = string
  description = "Kafka Api Key"
}

variable "kafka_api_secret" {
  type = string
  description = "Kafka Api secret"
}

variable "schema_registry_id" {
  type = string
  description = "schema registry id"
}
variable "schema_registry_rest_endpoint" {
  type = string
  description = "schema registry endpoint"
}

variable "schema_registry_api_key" {
  type = string
  description = "schema registry api key"
}

variable "schema_registry_api_secret" {
  type = string
  description = "schema registry api secret"
}

## user action
variable "user-action-data-partition-count" {
  type = number
  description = "partition count number"
}
