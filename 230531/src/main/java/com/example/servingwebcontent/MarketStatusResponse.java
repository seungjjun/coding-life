package com.example.servingwebcontent;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record MarketStatusResponse(boolean isMarketOpen) {
    public static MarketStatusResponse from(boolean marketStatus) {
        return new MarketStatusResponse(marketStatus);
    }
}
