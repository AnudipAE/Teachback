package com.project.mocktest;

public class ProductResponse {
    private String productInfo;

    public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    public ProductResponse(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getInfo() {
        return productInfo;
    }

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	

}
