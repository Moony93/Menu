package it.exercise.menuTopBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exercise.menuTopBoot.entities.Customer;
import it.exercise.menuTopBoot.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo repo;
	
	
	public List<Customer> listCustomers()
	{
		List<Customer> customers = repo.findAll();
		return customers;	
	}
	
	public void registerCustomer(Customer regCustomer)
	{
		repo.save(regCustomer);
	}
	
	public Customer findByUsername(String username)
	{
		return repo.findCustomerByUsername(username);
	}
	
	public boolean checkPassword(String password, Customer customer)
	{
		if(password.equals(customer.getPassword()))
		{
			return true;
		}
		else
			return false;
	}
}
