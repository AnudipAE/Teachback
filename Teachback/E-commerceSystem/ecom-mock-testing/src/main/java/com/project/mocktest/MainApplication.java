package com.project.mocktest;
//simulates the eCommerce system's functionality using the mock objects.
public class MainApplication {

    public static void main(String[] args) {
        // Create a mock instance of the ThirdPartyServerClient.
        ThirdPartyServerClient mockClient = new MockThirdPartyServerClient();  //This mock client will be used for simulating interactions with the third-party server.

        // Create an instance of ECommerceService with the mock client.
        ECommerceService ecommerceService = new ECommerceService(mockClient); //here the ecommerceService will use the mock client to interact with the third-party server.

        // Simulate fetching product information.
        String productId = "AF024123";
        String productInfo = ecommerceService.fetchProductInfo(productId); //This method internally makes an API call to the third-party server (using the mock client) to fetch product information based on the provided productId.
        System.out.println("Product Info: " + productInfo);

        // Simulate placing an order.
        String customerId = "456";
       // int quantity = 2;
        OrderDetails orderDetails = new OrderDetails(productId, customerId);
        OrderResponse orderResponse = orderDetails.placeOrder(mockClient);
        System.out.println("Order Status: " + orderResponse.getStatus());

        // Simulate fetching customer information.
        String customerInfo = ecommerceService.fetchCustomerInfo(customerId); //in this case, no actual API call is made. Instead, a static string is returned to simulate the successful fetching of customer information.
        System.out.println("Customer Info: " + customerInfo);
    }
}

/*    It simulates the following actions:
    - Fetching product information for a specific product ID and prints the result.
    - Placing an order for a product with order details and prints the order status.
    - Fetching customer information for a specific customer ID and prints the result.
    
    */
