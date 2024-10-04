package com.klef.jfsd.sdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.model.Customer;
import com.klef.jfsd.sdp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addcustomer(Customer c) {
		customerRepository.save(c);
		return "Registered Successfully";
	}

	@Override
	public Customer checklogin(String email, String pwd) {
		return customerRepository.checklogin(email, pwd);
	}
	
	public String count(Customer C)
	{
		return "No.of users "+CustomerRepository.countParticipants();
	}

}
