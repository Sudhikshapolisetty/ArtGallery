package com.klef.jfsd.sdp.service;

import com.klef.jfsd.sdp.model.Customer;
import com.klef.jfsd.sdp.model.Product;

public interface CustomerService {
	public String addcustomer(Customer c);
	public Customer checklogin(String email, String pwd);
	public String count(Customer s);
	public static Product viewartbyid(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
