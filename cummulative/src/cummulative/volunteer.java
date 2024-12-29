package cummulative;
import java.util.Date;

public class volunteer extends staffMember {
	private String assoName;


	public volunteer() {
		assoName="manager";
	}

	public volunteer(String firstName, String lastName, Date dob, String mobileNumber, String pEmail, String wEmail,String assoName){
		super(firstName, lastName, dob, mobileNumber, pEmail, wEmail);
		this.assoName=assoName;

	}

	public String getAssoName() {
		return assoName;
	}

	public void setAssoName(String assoName) {
		this.assoName = assoName;
	}

	public double pay() {
		return 0;
	}

	@Override
	public String toString() {
		return "volunteer [assoName=" + assoName + "]"+ "PAY"+pay();
	}


}
