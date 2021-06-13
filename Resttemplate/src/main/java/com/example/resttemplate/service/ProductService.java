package com.example.resttemplate.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.resttemplate.model.Products;

@Service
public class ProductService {
	@Autowired
	RestTemplate restTemplate;

	public String getAllProducts() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:9006/products", HttpMethod.GET, entity, String.class).getBody();
	}

	public String createProducts(Products product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Products> entity = new HttpEntity<Products>(product, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:9006/products", HttpMethod.POST,
				entity, String.class);
		return response.getBody();
	}

	public String updateProduct(String id, Products product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Products> entity = new HttpEntity<Products>(product, headers);

		return restTemplate.exchange("http://localhost:8080/products/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	public String deleteProduct(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Products> entity = new HttpEntity<Products>(headers);

		return restTemplate.exchange("http://localhost:8080/products/" + id, HttpMethod.DELETE, entity, String.class)
				.getBody();
	}
}
