package it.exercise.menuTopBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.exercise.menuTopBoot.entities.Customer;
import it.exercise.menuTopBoot.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService cService;
	
	@RequestMapping("/")
	public String viewLoginPage(Model model) 
	{
		Customer loginCustomer = new Customer();
		model.addAttribute("loginCustomer", loginCustomer);
	    return "login";
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("loginCustomer") Customer loginCustomer)
	{
		Customer foundCustomer = cService.findByUsername(loginCustomer.getUsername());
				
		if (foundCustomer!= null)
		{
			if(cService.checkPassword(loginCustomer.getPassword(), foundCustomer))
			{
				System.out.println("Correct password");
				return "redirect:/main";
			}
				
			else
			{
				System.out.println("Wrong password");
				return "redirect:/";
			}
		}
		else
			System.out.println("No username found");
			return "redirect:/";
	}
	
	@RequestMapping("/newCustomer")
	public String viewRegisterPage(Model model)
	{
		Customer regCustomer = new Customer();
		model.addAttribute("regCustomer", regCustomer);
		return "register";
	}
	
	@RequestMapping("/register")
	public String registerUser(@ModelAttribute("regCustomer") Customer regCustomer)
	{
		cService.registerCustomer(regCustomer);
		System.out.println("User correctly registered");
		return "redirect:/";
	}
}
