package model;

public class SavingAccount extends BankAccount {

	// Attributes
	private double interestRate;

	// Constructors
	public SavingAccount(double accountBalance, String openingDate) {
		super(accountBalance, openingDate);
		interestRate = 3.00;
	}

	// Getters & setters
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
