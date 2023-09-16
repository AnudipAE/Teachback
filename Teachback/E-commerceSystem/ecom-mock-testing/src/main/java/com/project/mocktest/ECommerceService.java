package com.project.mocktest;

public class ECommerceService {
    private final ThirdPartyServerClient thirdPartyServerClient;

    public ECommerceService(ThirdPartyServerClient thirdPartyServerClient) {
        this.thirdPartyServerClient = thirdPartyServerClient;
    }

    public String fetchProductInfo(String productId) {
        // Make an API call to the third-party server using the injected mock client.
        ProductResponse response = thirdPartyServerClient.getProductInfo(productId);
        return response.getInfo();
    }

	public String fetchCustomerInfo(String customerId) {
		// TODO Auto-generated method stub
		return "Customer Info is fetched successfully from a Third Party Server!!";
	}

    // Implement other methods using the mock client as needed.
}
