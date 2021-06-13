package com.example.resttemplate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Products {
	@Id
	@Column
	private int productId;
	@Column
	private String productName;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Products(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
}
