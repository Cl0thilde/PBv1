package model;

public class Transaction {

	// Attributes
	private BankAccount debitAccount;
	private BankAccount creditAccount;
	private double amount;
	private String message;

	// Constructor
	public Transaction(BankAccount debitAccount, BankAccount creditAccount, double amount, String message) {
		super();
		this.debitAccount = debitAccount;
		this.creditAccount = creditAccount;
		this.amount = amount;
		this.message = message;
	}

	public BankAccount getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(BankAccount debitAccount) {
		this.debitAccount = debitAccount;
	}

	public BankAccount getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(BankAccount creditAccount) {
		this.creditAccount = creditAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// Method
	// Realize a money transfer between two accounts (whatever their type)

	public void makeTransaction() {
		if (debitAccount.getAccountBalance() < amount + 1000) {
			System.out.println("Opération impossible, le débiteur dépassera le découvert autorisé.");
		} else {
			debitAccount.setAccountBalance(debitAccount.getAccountBalance() - amount);
			creditAccount.setAccountBalance(creditAccount.getAccountBalance() + amount);
			System.out.println(message);
			System.out.println("Le virement de " + amount + " a été effectué.");
		}
	}
}
