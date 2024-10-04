package com.klef.jfsd.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.sdp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select c from Customer c where email=?1 and password=?2")
	public Customer checklogin(String email,String pwd);
	
	@Query("select count(C) from Customer C")
	public static Long countParticipants() {
		// TODO Auto-generated method stub
		return null;
	}
	
	static Long countBy() {
		// TODO Auto-generated method stub
		return null;
	}

}
