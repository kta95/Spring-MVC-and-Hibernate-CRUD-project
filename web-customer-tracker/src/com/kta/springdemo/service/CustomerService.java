package com.kta.springdemo.service;

import java.util.List;

import com.kta.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
