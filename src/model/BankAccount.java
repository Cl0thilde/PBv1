package model;

public abstract class BankAccount {

	// Attributes
	private int[] accountNumber;
	private double accountBalance, initialBalance;
	private String openingDate;
	private static int[] accountNumberMaker = { 6, 3, 0, 0, 0, 0, 0, 0 };

	// Constructor
	public BankAccount(double accountBalance, String openingDate) {
		this.accountBalance = accountBalance;
		this.openingDate = openingDate;
		setInitialBalance(accountBalance);
		accountNumber = createAccountNumber();
	}

	// Getters & setters
	public String getAccountNumber() {
		String accountNum = "";
		for (int i : accountNumber) {
			accountNum += i;
		}
		return accountNum;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	@Override
	public String toString() {
		return "[N°: " + getAccountNumber() + ", solde actuel : " + accountBalance + " €, date d'ouverture : "
				+ openingDate+"]";
	}

	private int[] createAccountNumber() {
		int[] newNumber = new int[8];
		for (int i = 0; i < 8; i++) {
			newNumber[i] = accountNumberMaker[i];
		}
		for (int j = 7; j > 2; j--) {
			if (accountNumberMaker[j] < 9) {
				accountNumberMaker[j]++;
				break;
			}

			accountNumberMaker[j] = 0;
		}
		return newNumber;
	}

}
