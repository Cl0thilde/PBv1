package service;

import java.util.List;

import model.Customer;
import persistence.CustomerDao;
import persistence.IDao;

public class ServiceCustomer implements IService<Customer> {

	private IDao<Customer> dao = new CustomerDao();

	@Override
	public void create(Customer c) {
		dao.createCustomer(c);
	}

	@Override
	public void delete(Customer c) {
		dao.deleteCustomer(c);
	}

	@Override
	public Customer read(int id) {
		return dao.readId(id);
	}

	@Override
	public List<Customer> readAll() {
		return dao.readAll();
	}

	// Transfer money from a customer current account to another

	/**
	 * Permet de transferer de l'argent d'un compte courant � un autre
	 * 
	 * @param customerDebitedId
	 *            identifiant du compte d�bit�
	 * @param customerCreditedId
	 *            identifiant du compte cr�dit�
	 * @param money
	 *            somme � transferer
	 */
	@Override
	public void transferMoney(int customerDebitedId, int customerCreditedId, double money) {
		Customer customerDebited = dao.readId(customerDebitedId);
		Customer customerCredited = dao.readId(customerCreditedId);
		double AccountcustomerDebited = customerDebited.getCustomerAccount().getAccountBalance();
		double AccountcustomerCredited = customerCredited.getCustomerAccount().getAccountBalance();
		customerCredited.getCustomerAccount().setAccountBalance(AccountcustomerCredited + money);
		customerDebited.getCustomerAccount().setAccountBalance(AccountcustomerDebited - money);
	}

	// Simulate a credit
	/**
	 * Permet de simuler un cr�dit basique avec une somme, une dur�e et un taux
	 * d'int�r�t. Il renverra le montant des mensualit�s et le co�t global du cr�dit
	 * 
	 * @param amountToBorrow
	 *            Montant du cr�dit souhait�
	 * @param durationCredit
	 *            Dur�e (en mois) du cr�dit souhait�
	 * @param interestRate
	 *            Taux d'inter�t du pr�t compris entre 0 et 100
	 */
	@Override
	public String simulateCredit(double amountToBorrow, int durationCredit, double interestRate) {
		double monthly = (amountToBorrow / durationCredit) * (100 + interestRate);
		return "Mensualit� : " + monthly + " � / mois \nCo�t total du cr�dit : " + monthly * durationCredit + " �";
	}

	// Audit a client
	/**
	 * Permet de r�aliser l'audit de tous les comptes client de l'agence
	 * 
	 * @return Si au moins un compte � d�couvert de plus de 5000 �, l'audit a �chou�
	 *         sinon il est valid�
	 */
	@Override
	public void realizeAudit(List<Customer> c) {
		for (Customer customer : c) {
			if (customer.getCustomerAccount().getAccountBalance() < -5000
					^ customer.getCustomerSaving().getAccountBalance() < -5000) {
				System.out.println("L'audit a �chou�");

			} else {
				System.out.println("L'audit est valid�");
			}
		}
	}
}
