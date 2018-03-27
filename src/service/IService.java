package service;

import java.util.List;

public interface IService<Customer> {

	public void create(Customer c);

	public Customer read(int id);

	public void delete(Customer c);
	
	public List<Customer> readAll();

	void transferMoney(int customerDebitedId, int customerCreditedId, double money);

	public String simulateCredit(double amountToBorrow, int durationCredit, double interestRate);

	public void realizeAudit(List<Customer> c);
}
