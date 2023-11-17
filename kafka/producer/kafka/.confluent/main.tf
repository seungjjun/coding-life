# Configure the Confluent Provider
terraform {
  required_providers {
    confluent = {
      source  = "confluentinc/confluent"
      version = "1.50.0"
    }
  }
}

provider confluent {
  kafka_id                      = var.kafka_id
  kafka_rest_endpoint           = var.kafka_rest_endpoint
  kafka_api_key                 = var.kafka_api_key
  kafka_api_secret              = var.kafka_api_secret
  schema_registry_id            = var.schema_registry_id
  schema_registry_rest_endpoint = var.schema_registry_rest_endpoint
  schema_registry_api_key       = var.schema_registry_api_key
  schema_registry_api_secret    = var.schema_registry_api_secret
}

module "user-action" {
  source = "./user-action-module"
  user-action-data-partition-count  = var.user-action-data-partition-count

  kafka_id                      = var.kafka_id
  kafka_rest_endpoint           = var.kafka_rest_endpoint
  kafka_api_key                 = var.kafka_api_key
  kafka_api_secret              = var.kafka_api_secret
  schema_registry_id            = var.schema_registry_id
  schema_registry_rest_endpoint = var.schema_registry_rest_endpoint
  schema_registry_api_key       = var.schema_registry_api_key
  schema_registry_api_secret    = var.schema_registry_api_secret
}
