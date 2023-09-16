package com.project.mocktest;

//import junit.framework.TestCase;

//public class ECommerceServiceTest extends TestCase {
//
//}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ECommerceServiceTest {

    @Test
    public void testFetchProductInfo() {
        // Create a mock instance of the ThirdPartyServerClient.
        ThirdPartyServerClient mockClient = new MockThirdPartyServerClient();

        // Create an instance of ECommerceService with the mock client.
        ECommerceService ecommerceService = new ECommerceService(mockClient);

        // Test the behavior of the ECommerceService using the mock client.
        String productId = "AF024123";
        String expectedResponse = "Mock Product Info for AF024123";

        String actualResponse = ecommerceService.fetchProductInfo(productId);

        // Verify that the service returned the expected response.
        assertEquals(expectedResponse, actualResponse);
    }

    // Implement other test cases as needed.
}