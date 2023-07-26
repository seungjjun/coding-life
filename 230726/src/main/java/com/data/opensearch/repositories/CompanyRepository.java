package com.data.opensearch.repositories;

import com.data.opensearch.model.Company;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends ElasticsearchRepository<Company, String> {
    List<Company> findByCompanyCode(String companyCode);
}
