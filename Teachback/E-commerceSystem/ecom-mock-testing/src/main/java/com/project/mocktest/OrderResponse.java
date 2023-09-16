package com.project.mocktest;

public class OrderResponse {
    private String orderStatus;

    public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

    public OrderResponse(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatus() {
        return orderStatus;
    }

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

   
}
