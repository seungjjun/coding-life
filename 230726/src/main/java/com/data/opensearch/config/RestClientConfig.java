package com.data.opensearch.config;

import com.data.opensearch.repositories.CompanyRepository;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.data.client.orhlc.AbstractOpenSearchConfiguration;
import org.opensearch.data.client.orhlc.ClientConfiguration;
import org.opensearch.data.client.orhlc.RestClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackageClasses = CompanyRepository.class)
public class RestClientConfig extends AbstractOpenSearchConfiguration {
    @Value("${opensearch.uri}")
    private String openSearchUri;

    @Value("${opensearch.username}")
    private String name;

    @Value("${opensearch.password}")
    private String password;
    
    @Override
    @Bean
    public RestHighLevelClient opensearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(openSearchUri)
                .usingSsl()
                .withBasicAuth(name, password)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
