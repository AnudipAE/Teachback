package com.project.mocktest;

//This class implements the ThirdPartyServerClient interface and provides mock implementations of the methods. 

//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;

public class MockThirdPartyServerClient implements ThirdPartyServerClient {

    @Override
    public ProductResponse getProductInfo(String productId) {
        // Simulate a response for getProductInfo API call.
        // You can customize the behavior as needed for testing.
        return new ProductResponse("Mock Product Info for " + productId);
    }

    @Override
    public OrderResponse placeOrder(OrderDetails orderDetails) {
        // Simulate a response for placeOrder API call.
        // You can customize the behavior as needed for testing.
        return new OrderResponse("Order placed successfully");
    }

    @Override
    public CustomerResponse getCustomerInfo(String customerId) {
        // Simulate a response for getCustomerInfo API call.
        // You can customize the behavior as needed for testing.
        return new CustomerResponse("Mock Customer Info for " + customerId);
    }

}

