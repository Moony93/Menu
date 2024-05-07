package it.exercise.menuTopBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.exercise.menuTopBoot.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	Customer findCustomerByUsername(String username);

}
