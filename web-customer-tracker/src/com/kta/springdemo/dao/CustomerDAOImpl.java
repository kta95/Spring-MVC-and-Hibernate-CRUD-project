package com.kta.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kta.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// auto wire to get session factory
	@Autowired
	private SessionFactory factory;	
	
	@Override
	public List<Customer> getCustomers() {
		// get the current session from session factory
		Session session = factory.getCurrentSession();
		
		// get the query
		Query<Customer> theQuery = session.createQuery("from Customer"
				+ " order by lastName", Customer.class);
		
		// execute the query and get the result list
		List<Customer> customers = theQuery.getResultList();
		
		//return customer list
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current session from session factory
		Session session = factory.getCurrentSession();
		
		// save the customer to database
		session.save(theCustomer);
		
	}

}
