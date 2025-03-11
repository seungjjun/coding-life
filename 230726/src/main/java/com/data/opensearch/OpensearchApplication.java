package com.data.opensearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;

@SpringBootApplication(exclude = {
		ElasticsearchDataAutoConfiguration.class // spring data opensearch starter requires this. Otherwise, ElasticSearch related initialization kicks in
})
public class OpensearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpensearchApplication.class, args);
	}

}
