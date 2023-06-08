package com.example.opensearch.controllers;

import com.example.opensearch.applications.GetCompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CompanyController {
    private final GetCompanyService getCompanyService;

    public CompanyController(GetCompanyService getCompanyService) {
        this.getCompanyService = getCompanyService;
    }

    @GetMapping("/companies")
    private String list() throws IOException {
        getCompanyService.getCompany();
        return "";
    }
}
