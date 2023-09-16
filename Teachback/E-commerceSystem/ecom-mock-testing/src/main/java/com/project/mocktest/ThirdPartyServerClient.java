package com.project.mocktest;

public interface ThirdPartyServerClient {
    ProductResponse getProductInfo(String productId);
    OrderResponse placeOrder(OrderDetails orderDetails);
    CustomerResponse getCustomerInfo(String customerId);
}
