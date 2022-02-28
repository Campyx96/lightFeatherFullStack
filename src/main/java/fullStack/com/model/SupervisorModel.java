package fullStack.com.model;

public class SupervisorModel {
	private String id;
	private String phone;
	private char jurisdiction;
	private String identificationNumber;
	private String firstName;
	private String lastName;
	public char getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(char jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
