package com.portfolioJerome.CustomerCRUD;

import com.portfolioJerome.CustomerCRUD.DAO.CustomerDAO;
import com.portfolioJerome.CustomerCRUD.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CustomerDAO customerDAO){
		return runner -> {
			//createCustomer(customerDAO);
			createMultipleCustomer(customerDAO);
			//readCustomer(customerDAO);
			//queryCustomer(customerDAO);
			//queryCustomerByLastName(customerDAO);
			//customerUpdate(customerDAO);
			//deleteCustomer(customerDAO);
			//deleteALlCustomer(customerDAO);
		};
	}

	private void deleteALlCustomer(CustomerDAO customerDAO) {
		int totalDeletedCustomer = customerDAO.deleteAll();

		System.out.println("total deleted is: "+totalDeletedCustomer);
	}

	private void deleteCustomer(CustomerDAO customerDAO) {
		int id = 4;
		customerDAO.delete(id);
	}

	private void customerUpdate(CustomerDAO customerDAO) {
		int id = 3;
		System.out.println("Updating the values of id = 3");

		Customer tempCustomer = customerDAO.findById(id);

		tempCustomer.setFirstName("LeBron");

		customerDAO.update(tempCustomer);

		System.out.println(tempCustomer);
	}

	private void queryCustomerByLastName(CustomerDAO customerDAO) {
		List<Customer> myCustomer = customerDAO.findByLastName("Felicilda");
		for (Customer tempCustomer : myCustomer){
			System.out.println(tempCustomer);
		}
	}

	private void queryCustomer(CustomerDAO customerDAO) {
		List<Customer> myCustomer = customerDAO.findAll();

		for (Customer tempCustomer : myCustomer){
			System.out.println(tempCustomer);
		}
	}

	private void readCustomer(CustomerDAO customerDAO) {
		System.out.println("Creating new customer");
		Customer tempCustomer = new Customer("Jam", "Sora", "jam@gmail.com", 25);

		System.out.println("Saving the customer");
		customerDAO.save(tempCustomer);

		System.out.println("Parsing the id of the customer "+tempCustomer.getId());

		int theId = tempCustomer.getId();


		Customer myCustomer = customerDAO.findById(theId);
		System.out.print(myCustomer);

	}

	private void createMultipleCustomer(CustomerDAO customerDAO) {
		System.out.println("Creating three customers...");
		Customer myCustomer = new Customer("Rasty","Aguinaldo","rasty@gmail.com",24);
		Customer myCustomer2 = new Customer ("James","Alonzo","james@gmail.com", 23);
		Customer myCustomer3 = new Customer ("Charles", "Luna", "charles@gmail.com", 24);

		customerDAO.save(myCustomer);
		customerDAO.save(myCustomer2);
		customerDAO.save(myCustomer3);
	}

	private void createCustomer(CustomerDAO customerDAO) {
		System.out.println("Creating Customer object...");
		Customer myCustomer = new Customer("Geordan","Mabini","geordan@gmail.com", 23);

		System.out.println("Parsing the generated id for the object: "+myCustomer.getId());

		System.out.println("Customer is saved...");
		customerDAO.save(myCustomer);
	}

}
