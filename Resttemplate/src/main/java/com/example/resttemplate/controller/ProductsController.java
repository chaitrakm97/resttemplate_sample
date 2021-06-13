package com.example.resttemplate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.resttemplate.model.Products;
import com.example.resttemplate.service.ProductService;

@RestController
public class ProductsController {

	@Autowired
	ProductService productsService;

	@RequestMapping(value = "/api/v1/products", method = RequestMethod.GET)
	public String getProductList() {
		return productsService.getAllProducts();

	}

	//if this is api from other service
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Products> getProducts() {
		Products p1 = new Products(1, "Honey");
		Products p2 = new Products(2, "Biscuit");
		List<Products> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		return list;

	}

	@RequestMapping(value = "/api/v1/products/save", method = RequestMethod.POST)
	public String createProducts(@RequestBody Products product) {
		return productsService.createProducts(product);

	}

	@RequestMapping(value = "/api/v1/products/{id}", method = RequestMethod.PUT)
	public String updateProduct(@PathVariable("id") String id, @RequestBody Products product) {
		return productsService.updateProduct(id, product);

	}

	@RequestMapping(value = "/api/v1/products/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") String id) {
		return productsService.deleteProduct(id);

	}
}
