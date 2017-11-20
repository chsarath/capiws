package com.sarath.springboot.customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	List<Customer> customers = new ArrayList<Customer>(Arrays.asList(
			new Customer("1","Sarath","Hyderabad"),
			new Customer("2","Babu","London"),
			new Customer("3","Keerthi","Pune")));
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	public Customer getCustomer(String id) {
		return customerRepository.findOne(id);
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(String id) {
		customerRepository.delete(id);
	}
}