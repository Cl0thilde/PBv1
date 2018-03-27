package model;

public abstract class Person {

	// Attributes
	private String lastName;
	private String firstName;

	// Constructor
	public Person(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	// Getters & setters
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", firstName=" + firstName + "]";
	}

}
