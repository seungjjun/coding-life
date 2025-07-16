package com.data.opensearch.application;

import com.data.opensearch.model.Company;
import com.data.opensearch.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void getCompany() {
        List<Company> companies = companyRepository.findByCompanyCode("A005930");
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
