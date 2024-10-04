package com.klef.jfsd.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdp.model.Customer;
import com.klef.jfsd.sdp.model.Product;
import com.klef.jfsd.sdp.repository.CustomerRepository;
import com.klef.jfsd.sdp.service.CustomerService;
import com.klef.jfsd.sdp.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@GetMapping("/count")
	@ResponseBody
	public String getCustomerCount() {
	    Long customerCount = CustomerRepository.countParticipants();
	    return "Total Customers: " + customerCount;
	}
	
	 public Long count() {
	        // Use the countBy method to get the count of customers
	        return CustomerRepository.countBy();
	    }
	@PostMapping("checklogin")
	public ModelAndView checklogin(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		
		String email = request.getParameter("email");
	     String pwd = request.getParameter("pwd");
	     
	     Customer c = customerService.checklogin(email, pwd);
	     
	     if(c!=null) {
	    	 /*HttpSession session = request.getSession();
	    	 
	    	 session.setAttribute("eid", c.getId());
	    	 session.setAttribute(pwd, session);*/
	    	 
	    	 mv.setViewName("home");
	     }
	     else {
	    	 mv.setViewName("login");
	    	 mv.addObject("message", "Login Failed");
	     }
	     return mv;
	}
	
	@GetMapping("reg")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}
	
	@PostMapping("insertc")
	public ModelAndView insert(HttpServletRequest request) {
		String msg=null;

		
		ModelAndView mv=new ModelAndView();
		try {
			String name = request.getParameter("name");

		    String email = request.getParameter("email");
		    String pwd = request.getParameter("pwd");
		     
		    Customer c = new Customer();
		    c.setName(name);
		    c.setEmail(email);
		    c.setPassword(pwd);
		    
		    msg = customerService.addcustomer(c);
		    
		    mv.setViewName("register");
		    

		}catch(Exception e) {
			msg = e.getMessage();
			
		}
		
		return mv;
	}
	
	@PostMapping("insertp")
	public ModelAndView insertp(HttpServletRequest request) {
		String msg=null;

		
		ModelAndView mv=new ModelAndView();
		try {
			String product_name = request.getParameter("product_name");

		    String description = request.getParameter("description");
		    double price = Double.parseDouble(request.getParameter("price"));
		      
		    Product p=new Product();
		    p.setProduct_name(product_name);
		    p.setDescription(description);
		    p.setPrice(price);
		    
		    msg = ProductService.addproduct(p);
		    
		    mv.setViewName("register");
		    

		}catch(Exception e) {
			msg = e.getMessage();
			
		}
		
		return mv;
	}

	
	@GetMapping("chome")
	public ModelAndView chome() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("chome");
		return mv;
	}
	
	@GetMapping("gallery")
	public ModelAndView gallery() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gallery");
		return mv;
	}
	
	@GetMapping("artist")
	public ModelAndView artists() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("artists");
		return mv;
	}
	
	@GetMapping("about")
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	
	@GetMapping("footer")
	public ModelAndView footer() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("footer");
		return mv;
	}
	
	@GetMapping("collab")
	public ModelAndView business() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("business");
		return mv;
	}
	
	@GetMapping("clogout")
	public ModelAndView customerlogout() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login");
		
		return mv;
	}
	

}
