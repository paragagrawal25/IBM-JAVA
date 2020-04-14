package com.example.demo;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImpl;

public class App 
{
	private static CustomerService customerService = null;
	private static Scanner input = new Scanner(System.in);
	
	static
	{
		customerService = new CustomerServiceImpl();
	}
	
    public static void main( String[] args )
    {
    	String custName,custEmail;
        int iChoice = -1;
        do
        {
        	System.out.println("1. CREATE NEW STUDENT\n2. LIST ALL CUSTOMERS\n3. GET CUSTOMER BY ID");
        	System.out.print("ENTER YOUR CHOICE : ");
        	iChoice = input.nextInt();
        	switch(iChoice)
        	{
        		case 1:
        			System.out.println("ENTER CUSTOMER NAME");
        			custName = input.next();
        			System.out.println("ENTER CUSTOMER EMAIL ID");
        			custEmail = input.next();
        			Customer customer = new Customer();
        			customer.setCustomerID(UUID.randomUUID().toString());
        			customer.setCustomerName(custName);
        			customer.setCustomerEmail(custEmail);
        			customer.setActive(true);
        			customerService.createCustomer(customer);
        			System.out.println(customer);
        			break;
        		case 2:
        			List<Customer> listCustomers = customerService.getAllCustomers();
        			for(Customer cust : listCustomers)
        			{
        				System.out.println(cust);
        			}
        			break;
        		case 3:
        			System.out.print("ENTER CUSTOMER ID : ");
        			String custID = input.next();
        			Customer objCust = customerService.getCustomerByID(custID);
        			if(objCust == null)
        				System.err.println("NO CUSTOMER FOUND BY GIVEN CUSTOMER ID");
        			else
        				System.out.println(objCust);
        			break;
        		default:
        			break;
        	}
        }
        while(iChoice != 0);
    }
}
