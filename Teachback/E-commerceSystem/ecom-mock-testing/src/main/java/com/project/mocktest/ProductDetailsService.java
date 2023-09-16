package com.project.mocktest;

public class ProductDetailsService {
	private final ThirdPartyServerClient thirdPartyServerClient;

    public ProductDetailsService(ThirdPartyServerClient thirdPartyServerClient) {
        this.thirdPartyServerClient = thirdPartyServerClient;
    }
    
//    public Product getProductDetails(String productId) {
//        // Use the thirdPartyServerClient to fetch product details.
//        // You can implement this method based on your requirements.
//        // For example, you can make API calls to the third-party server.
//
//        // Here, we'll return a dummy product for demonstration purposes.
//        return new Product(productId, "Sample Product", 99.99);
//    }
    
    public Product getProductDetails(String productId) {
        // Simulate fetching product details from the server (in a real implementation, you would make an HTTP request)
        if ("123".equals(productId)) {
            // Simulate a successful response from the server
            return new Product("123", "Product ABC", 49.99);
        } else {
            // Handle other cases or return null for simplicity
            return null;
        }
    }
}
