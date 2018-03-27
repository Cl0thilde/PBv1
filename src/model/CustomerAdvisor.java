package model;

import java.util.List;

public class CustomerAdvisor extends Person {

	// Attributes
	private List<Customer> listCustomers;

	// Constructor
	public CustomerAdvisor(String lastName, String firstName) {
		super(lastName, firstName);
	}

	// Getters & setters
	public List<Customer> getListCustomers() {
		return listCustomers;
	}

	public void setListCustomers(List<Customer> listCustomers) {
		this.listCustomers = listCustomers;
	}

}
