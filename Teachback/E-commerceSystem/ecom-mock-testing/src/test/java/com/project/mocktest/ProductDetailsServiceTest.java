package com.project.mocktest;

//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//class ProductDetailsServiceTest {
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//
//}

//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProductDetailsServiceTest {

    @Mock
    private ProductDetailsService productDetailsService;

    //@SuppressWarnings("deprecation")
	@Before
    public void setUp() {
        //MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductDetails() {
        // Define a sample product response
        Product product = new Product("123", "Product ABC", 49.99);

        // Configure the behavior of the mocked ProductDetailsService
        when(productDetailsService.getProductDetails("123")).thenReturn(product);

        // Fetch product details using the ProductDetailsService
        Product result = productDetailsService.getProductDetails("123");

        // Verify that the getProductDetails method was called with the correct ID
        verify(productDetailsService).getProductDetails("123");

        // Verify that the result matches the expected product
        assertEquals(product, result);
    }
}

//This is a JUnit test class for testing the ProductDetailsService class. 
//It uses Mockito to create a mock instance of ProductDetailsService and configures its behavior for testing.

