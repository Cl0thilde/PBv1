package model;

public abstract class BankCard {

	// Attributes
	private CurrentAccount account;
	private int idCard;
	private static int cardCount = 0;
	private String activationState;
	public static final BankCard ELECTRONVISACARD = null;
	public static final BankCard PREMIERVISACARD = null;

	// Constructors
	public BankCard(CurrentAccount account) {
		this.account = account;
		idCard = cardCount;
		cardCount++;
		activationState = "Activated";
	}

	// Default constructor: card is active at bank account opening
	public BankCard() {
		activationState = "Activated";
	}

	// Getters & setters
	public String getActivationState() {
		return activationState;
	}

	public void setActivationState(String activationState) {
		this.activationState = activationState;
	}

	public CurrentAccount getAccount() {
		return account;
	}

	public void setAccount(CurrentAccount account) {
		this.account = account;
	}

	public int getId() {
		return idCard;
	}

	public void setId(int id) {
		this.idCard = id;
	}

	public static int getCardCount() {
		return cardCount;
	}

	public static void setCardCount(int cardCount) {
		BankCard.cardCount = cardCount;
	}

}
