package model;

public class Customer extends Person {

	// Attributes
	private String address, city, phoneNumber, postalCode;
	private int customerId;
	private CurrentAccount customerCurrentAccount;
	private SavingAccount customerSavingAccount;

	private int numberOfAccounts;

	// Constructors
	public Customer(String lastName, String firstName, String address, String postalCode, String city,
			String phoneNumber, CurrentAccount customerCurrentAccount, SavingAccount customerSavingAccount) {
		super(lastName, firstName);
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.customerCurrentAccount = customerCurrentAccount;
		this.customerSavingAccount = customerSavingAccount;
	}

	public Customer(String lastName, String firstName, String address, String postalCode, String city,
			String phoneNumber) {
		super(lastName, firstName);
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		customerCurrentAccount = null;
		customerSavingAccount = null;
		numberOfAccounts = 0;
	}

	// Getters & setters
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public CurrentAccount getCustomerAccount() {
		return customerCurrentAccount;
	}

	public void setCustomerAccount(CurrentAccount customerAccount) {
		this.customerCurrentAccount = customerAccount;
	}

	public SavingAccount getCustomerSaving() {
		return customerSavingAccount;
	}

	public void setCustomerSaving(SavingAccount customerSaving) {
		this.customerSavingAccount = customerSaving;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}

	@Override
	public String toString() {
		return customerId + " : " + getLastName() + " " + getFirstName() + " [adresse : " + address + ", " + postalCode
				+ " " + city + " / N° téléphone : " + phoneNumber + "]" + "\nCompte courant " + customerCurrentAccount
				+ "\nCompte épargne " + customerSavingAccount + "\n";
	}

	// Methods
	// Audit a bank account
	public boolean auditCustomer(Customer c) {
		CurrentAccount account = c.getCustomerAccount();
		if (account == null) {
			System.out.println("Le client " + c.getLastName() + " n'a pas de compte");
			return false;
		} else if (account.getAccountBalance() < -5000.0) {
			System.out.println("Le client " + c.getLastName() + " a dépassé le découvert maximal de 5000 Euros");
			return false;
		} else {
			System.out.println("Le client " + c.getLastName() + " a réussi l'audit");
		}

		return true;
	}

	// Simulate a basic credit
	public void simulateCredit(double amount, double duration, double interestRate) {
		System.out.println("Simulation de crédit");
		System.out.println("Montant souhaité: " + amount + " Euros");
		System.out.println("Durée du pret: " + duration + " mois");
		System.out.println("Taux d'interêts; " + interestRate + " %");
		double monthly = (amount * (interestRate / 1200) / (1 - Math.pow(1 + interestRate / 1200, -duration)));
		System.out.println("Mensualité de " + monthly + " Euros par mois");
		System.out.println("Cout total du crédit: " + monthly * duration + " Euros");
	}
}
