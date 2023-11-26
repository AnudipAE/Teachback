package com.ecommerce.service;

public class ECommerceService {
    private ThirdPartyServerClient thirdPartyServerClient;

    public ECommerceService(ThirdPartyServerClient thirdPartyServerClient) {
        this.thirdPartyServerClient = thirdPartyServerClient;
    }

    public String performECommerceOperation() {
        // Some business logic here
       
        return thirdPartyServerClient.fetchData();
    }
}

