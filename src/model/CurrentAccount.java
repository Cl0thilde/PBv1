package model;

import java.util.ArrayList;

public class CurrentAccount extends BankAccount {

	// Attributes
	private double overdraftAuthorization;
	private ArrayList<BankCard> allCustomerCards;

	// Constructors
	public CurrentAccount(double accountBalance, String openingDate) {
		super(accountBalance, openingDate);
		overdraftAuthorization = 1000.0;
		allCustomerCards = new ArrayList<BankCard>();
	}

	public CurrentAccount(double accountBalance, String openingDate, double overdraftAuthorization,
			ArrayList<BankCard> cards) {
		super(accountBalance, openingDate);
		this.overdraftAuthorization = overdraftAuthorization;
		cards = new ArrayList<BankCard>();
	}

	// Getters & setters
	public double getOverdraftAuthorization() {
		return overdraftAuthorization;
	}

	public void setOverdraftAuthorization(int overdraftAuthorization) {
		this.overdraftAuthorization = overdraftAuthorization;
	}

	public ArrayList<BankCard> getCards() {
		return allCustomerCards;
	}

	public void setCards(ArrayList<BankCard> cards) {
		this.allCustomerCards = cards;
	}

	// Methods

	// Add a card to a customer account
	public boolean addCard(BankCard card) {
		if (card != null) {
			if (card == BankCard.ELECTRONVISACARD) {
				return allCustomerCards.add(new ElectronVisaCard(this));
			}

			else if (card == BankCard.PREMIERVISACARD) {
				return allCustomerCards.add(new PremierVisaCard(this));
			}
		}
		return false;
	}

	// Remove a card from a customer account
	public boolean deleteCard(int index) {
		BankCard card;
		card = allCustomerCards.remove(index);
		return (card == null) ? false : true;
	}

	public int findCard(Integer idCard) {
		if (idCard != null) {
			Integer index = 0;
			for (BankCard card : allCustomerCards) {
				if (card.getId() == idCard)
					return index;
				index++;
			}
		}
		return -1;
	}

}
