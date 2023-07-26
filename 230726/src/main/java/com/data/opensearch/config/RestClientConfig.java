package com.data.opensearch.config;

import com.data.opensearch.repositories.CompanyRepository;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.boot.autoconfigure.elasticsearch.RestClientBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Configuration
@EnableElasticsearchRepositories(basePackageClasses = CompanyRepository.class)
@ComponentScan(basePackageClasses = RestClientConfig.class)
public class RestClientConfig {
//    @Override
//    @Bean
//    public RestHighLevelClient opensearchClient() {
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .build();
//
//        return RestClients.create(clientConfiguration).rest();
//    }

    @Bean
    RestClientBuilderCustomizer customizer() {
        return new RestClientBuilderCustomizer() {
            @Override
            public void customize(HttpAsyncClientBuilder builder) {
                try {
                    builder.setSSLContext(new SSLContextBuilder()
                            .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                            .build());
                } catch (final KeyManagementException | NoSuchAlgorithmException | KeyStoreException ex) {
                    throw new RuntimeException("Failed to initialize SSL Context instance", ex);
                }
            }

            @Override
            public void customize(RestClientBuilder builder) {
                // No additional customizations needed
            }
        };
    }
}
