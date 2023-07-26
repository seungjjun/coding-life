package com.data.opensearch.controller;

import com.data.opensearch.application.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/company-search-history/search")
    public String getCompany() {
        companyService.getCompany();
        return "";
    }
}
