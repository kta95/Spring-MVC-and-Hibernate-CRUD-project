package com.kta.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kta.springdemo.entity.Customer;
import com.kta.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		 
		// get the customer list form customerDAO
		List<Customer> theCustomers = service.getCustomers();		
		
		// add the customers to model
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model model) {
		
		// create the customer object
		Customer customer = new Customer();
		
		// add the customer object to model
		model.addAttribute("customer", customer);
		
		return "customer-form";
		
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer using our service
		service.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
}
