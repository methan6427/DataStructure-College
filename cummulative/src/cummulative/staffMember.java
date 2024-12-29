package cummulative;
import java.util.Date;

public class staffMember {
	private String firstName;
	private String lastName;
	private Date Dob;
	private Address address;
	private String mobileNumber;
	private String pEmail;
	private String wEmail;

	public staffMember() {
		firstName = "adam";
		firstName = "khabisa";
		Dob = new Date(33, 11, 25);
		mobileNumber = "0593639342";
		pEmail = "adamkh0698@gmail.com";
		wEmail = "aaa@gmail.com";

	}

	public staffMember(String firstName, String lastName, Date dob, String mobileNumber, String pEmail, String wEmail) {
		this.firstName = firstName;
		this.lastName = lastName;
		Dob = dob;
		this.mobileNumber = mobileNumber;
		this.pEmail = pEmail;
		this.wEmail = wEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		/*
		 * for (int i = 0; i < firstName.length(); i++) { if
		 * (firstName.charAt(i) != '0' || firstName.charAt(i) != '1' ||
		 * firstName.charAt(i) != '2' || firstName.charAt(i) != '3' ||
		 * firstName.charAt(i) != '4' || firstName.charAt(i) != '5' ||
		 * firstName.charAt(i) != '6' || firstName.charAt(i) != '7' ||
		 * firstName.charAt(i) != '8' || firstName.charAt(i) != '9') return
		 * firstName; } return "the name shouldn't contain a number!";
		 */
		if (firstName.matches("[a-zA-Z]+")) {
			this.firstName = firstName;
		} else {
			System.out.println("Invalid Name!");
		}

	}

	public String getLastName() {
		/*
		 * for (int i = 0; i < lastName.length(); i++) { if (lastName.charAt(i)
		 * != '0' || lastName.charAt(i) != '1' || lastName.charAt(i) != '2' ||
		 * lastName.charAt(i) != '3' || lastName.charAt(i) != '4' ||
		 * lastName.charAt(i) != '5' || lastName.charAt(i) != '6' ||
		 * lastName.charAt(i) != '7' || lastName.charAt(i) != '8' ||
		 * lastName.charAt(i) != '9') return lastName; } return
		 * "the name shouldn't contain a number!";
		 */
		return lastName;
	}

	public void setLastName(String lastName) {
		this.firstName = lastName;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		if (mobileNumber.matches("[0-9]") && mobileNumber.startsWith("059") && mobileNumber.startsWith("056")) {
			this.mobileNumber = mobileNumber;
		} else {
			System.out.println("Invalid Mobile Number!");
		}
	}

	public String getpEmail() {
		return pEmail;
	}

	public void setpEmail(String pEmail) {
		if (pEmail.startsWith("[a-zA-z]") && pEmail.matches("[a-zA-Z]+[!@#$%^&*.]+[0-9]")) {
			this.pEmail = pEmail;
		} else {
			System.out.println("INVALID PERSONAL EMAIL!");
		}
	}

	private void workEmailAuto() {
		this.wEmail = this.firstName.toLowerCase().charAt(0) + this.lastName.toLowerCase().charAt(0) + "@facility.com";
	}

	public double pay() {
		return 0;
	}

	@Override
	public String toString() {
		return "staffMember []";
	}

}
