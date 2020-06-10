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
		
		// save/Update the customer to database
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
//		
//		session.createQuery("delete from Customer c where c.id='"+theId+"'").executeUpdate();
		// another method
		Query theQuery = session.createQuery("delete from Customer where id =:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		Session session = factory.getCurrentSession();
		Query theQuery = null;
		
		  // only search by name if theSearchName is not empty
		if(theSearchName != null && theSearchName.trim().length()>0) {
			
			  // search for firstName or lastName ... case insensitive
			theQuery = session.createQuery("from Customer where lower(firstName)like :theName or lower(lastName) like :theName", Customer.class);
			theQuery.setParameter("theName","%"+ theSearchName.toLowerCase()+"%");
		}
		else {
			//theSearchName is empty..... so just get all customers
			 theQuery =session.createQuery("from Customer", Customer.class);      
		}
		
		// execute query and get the result list
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

}
