package com.klef.jfsd.sdp.service;

import org.springframework.beans.factory.annotation.Autowired;


import com.klef.jfsd.sdp.model.Product;
import com.klef.jfsd.sdp.repository.ProductRepository;

public class ProductServicemanager {
	@Autowired
	private ProductRepository PR;

	
	public String addproduct(Product c) {
		PR.save(c);
		return "Registered Successfully";
	}
}
