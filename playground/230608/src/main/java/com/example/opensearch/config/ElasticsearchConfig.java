package com.example.opensearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {
    @Value("${spring.data.elasticsearch.host}")
    private String host;

    @Value("${spring.data.elasticsearch.port}")
    private int port;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client() {
        return new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "https")));
    }
}
