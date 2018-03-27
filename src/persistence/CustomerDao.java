package persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Customer;

public class CustomerDao implements IDao<Customer> {

	// Création de la base de données Clients
	private static final Map<Integer, Customer> DBCUSTOMER = new HashMap<>();

	@Override
	public Customer readCustomer(Customer c) {
		int id = c.getCustomerId();
		return DBCUSTOMER.get(id);
	}

	@Override
	public Customer readId(int id) {
		return DBCUSTOMER.get(id);
	}

	@Override
	public void deleteCustomer(Customer c) {
		int id = c.getCustomerId();
		DBCUSTOMER.remove(id);
	}

	@Override
	public void createCustomer(Customer c) {
		int idCustomer = (int) (Math.random() * 1000);
		c.setCustomerId(idCustomer);
		DBCUSTOMER.put(c.getCustomerId(), c);
	}

	@Override
	public List<Customer> readAll() {
		Collection<Customer> collectionCustomer = DBCUSTOMER.values();
		List<Customer> listCustomer = new ArrayList<>(collectionCustomer);
		return listCustomer;
	}
}
