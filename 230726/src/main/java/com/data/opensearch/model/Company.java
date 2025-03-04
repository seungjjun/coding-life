package com.data.opensearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;

@Document(indexName = "company-search-history")
public class Company {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "companyCode")
    private String companyCode;

    @Field(type = FieldType.Text, name = "eventSource")
    private String eventSource;

    @Field(type = FieldType.Boolean, name = "userAction")
    private boolean userAction;

    @Field(type = FieldType.Text, name = "keyword")
    private String keyword;

    @Field(type = FieldType.Date, name = "eventTime")
    private Instant eventTime;

    public Company() {
    }

    public Company(String id, String companyCode, String eventSource, boolean userAction, String keyword, Instant eventTime) {
        this.id = id;
        this.companyCode = companyCode;
        this.eventSource = eventSource;
        this.userAction = userAction;
        this.keyword = keyword;
        this.eventTime = eventTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public boolean isUserAction() {
        return userAction;
    }

    public void setUserAction(boolean userAction) {
        this.userAction = userAction;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Instant getEventTime() {
        return eventTime;
    }

    public void setEventTime(Instant eventTime) {
        this.eventTime = eventTime;
    }
}
