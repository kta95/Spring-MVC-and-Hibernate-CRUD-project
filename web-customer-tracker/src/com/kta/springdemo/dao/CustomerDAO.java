package com.kta.springdemo.dao;

import java.util.List;

import com.kta.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}

