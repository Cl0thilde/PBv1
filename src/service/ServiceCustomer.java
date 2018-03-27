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
	 * Permet de transferer de l'argent d'un compte courant à un autre
	 * 
	 * @param customerDebitedId
	 *            identifiant du compte débité
	 * @param customerCreditedId
	 *            identifiant du compte crédité
	 * @param money
	 *            somme à transferer
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
	 * Permet de simuler un crédit basique avec une somme, une durée et un taux
	 * d'intérêt. Il renverra le montant des mensualités et le coût global du crédit
	 * 
	 * @param amountToBorrow
	 *            Montant du crédit souhaité
	 * @param durationCredit
	 *            Durée (en mois) du crédit souhaité
	 * @param interestRate
	 *            Taux d'interêt du prêt compris entre 0 et 100
	 */
	@Override
	public String simulateCredit(double amountToBorrow, int durationCredit, double interestRate) {
		double monthly = (amountToBorrow / durationCredit) * (100 + interestRate);
		return "Mensualité : " + monthly + " € / mois \nCoût total du crédit : " + monthly * durationCredit + " €";
	}

	// Audit a client
	/**
	 * Permet de réaliser l'audit de tous les comptes client de l'agence
	 * 
	 * @return Si au moins un compte à découvert de plus de 5000 €, l'audit a échoué
	 *         sinon il est validé
	 */
	@Override
	public void realizeAudit(List<Customer> c) {
		for (Customer customer : c) {
			if (customer.getCustomerAccount().getAccountBalance() < -5000
					^ customer.getCustomerSaving().getAccountBalance() < -5000) {
				System.out.println("L'audit a échoué");

			} else {
				System.out.println("L'audit est validé");
			}
		}
	}
}
