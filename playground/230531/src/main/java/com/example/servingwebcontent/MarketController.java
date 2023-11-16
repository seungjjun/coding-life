package com.example.servingwebcontent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketController {
    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/status")
    public MarketStatusResponse getMarketOpen() {
        boolean marketStatus = marketService.getMarketStatus();
        return MarketStatusResponse.from(marketStatus);
    }
}
