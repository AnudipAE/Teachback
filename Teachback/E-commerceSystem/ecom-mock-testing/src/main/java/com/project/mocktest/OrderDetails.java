package com.project.mocktest;

public class OrderDetails {
    private String productId;
    private String customerId;

    public OrderDetails(String productId, String customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }
    
    public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	  
		public OrderResponse placeOrder(ThirdPartyServerClient thirdPartyServerClient) {
	        // Simulate placing an order by making an API call to the third-party server.
	        // You can customize this method as needed for your specific use case.

	        // Assuming the thirdPartyServerClient has a placeOrder method.
	        return thirdPartyServerClient.placeOrder(this);
	    }
   
}
