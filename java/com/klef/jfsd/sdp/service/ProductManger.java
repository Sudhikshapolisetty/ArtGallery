package com.klef.jfsd.sdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.model.Product;
import com.klef.jfsd.sdp.repository.ProductRepository;


@Service
public class ProductManger {
	@Autowired
	ProductRepository rr;
	public String registration(Product ru1) {
		rr.save(ru1);
		return "data added Successfully!!";
	}
}
