package cummulative;
import java.util.Date;

public class CommessionEmployee extends Employee {
	private double soldItemPMonth;

	public CommessionEmployee() {
		soldItemPMonth=5.5;
	}

	public CommessionEmployee(String firstName, String lastName, Date dob, String mobileNumber, String pEmail,
			String wEmail, String empno, Department department, double soldItemPMonth) {
		super(firstName, lastName, dob, mobileNumber, pEmail, wEmail, empno, department);
		this.setSoldItemPMonth(soldItemPMonth);
	}

	public CommessionEmployee(String string, String string2, int i, String string3, String string4, String string5,
			int j, int k) {
		
	}

	public double getSoldItemPMonth() {
		return soldItemPMonth;
	}

	public void setSoldItemPMonth(double soldItemPMonth) {
		this.soldItemPMonth = soldItemPMonth;
	}

	public double pay() {
		if (getSoldItemPMonth() < 20000 && getSoldItemPMonth() > 15000) {
			return 0.03 * getSoldItemPMonth();
		} else if (getSoldItemPMonth() > 20000) {
			return 0.0 * getSoldItemPMonth();
		} else {
			return 0.015 * getSoldItemPMonth();
		}

	}

	@Override
	public String toString() {
		return "CommessionEmployee [soldItemPMonth=" + getSoldItemPMonth() + "]"+ "PAY"+pay();
	}

}
