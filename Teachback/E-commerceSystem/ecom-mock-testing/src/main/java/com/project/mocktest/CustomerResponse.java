package com.project.mocktest;

public class CustomerResponse {
    private String customerInfo;

	public CustomerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerResponse(String customerInfo) {
        this.customerInfo = customerInfo;
    }
    
    public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}

    public String getInfo() {
        return customerInfo;
    }

}

//CustomerResponse, OrderResponse, ProductResponse: These are simple classes representing responses from the third-party server. 
