package com.data.opensearch.application;

import com.data.opensearch.model.Company;
import com.data.opensearch.repositories.CompanyRepository;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.index.IndexResponse;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void getCompany() {
        List<Company> companies = companyRepository.findByCompanyCode("A005930");
//        RestClient lowLevelClient = restHighLevelClient.getLowLevelClient();
//
//        IndexRequest request = new IndexRequest("company-search-history");
//
//        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
//
//        System.out.println(response.getIndex());

        for (Company company : companies) {
            System.out.println("company code : " + company.getCompanyCode());
        }
    }
}
