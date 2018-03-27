package persistence;

import java.util.List;

public interface IDao<Customer> {

	public void createCustomer(Customer c);

	public Customer readCustomer(Customer c);

	public Customer readId(int id);

	public void deleteCustomer(Customer c);

	public List<Customer> readAll();

}
