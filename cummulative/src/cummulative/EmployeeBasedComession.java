package cummulative;
import java.util.Date;

public class EmployeeBasedComession extends CommessionEmployee {
	private double basedOnSalary;

	public EmployeeBasedComession() {

		basedOnSalary = 5.5;
	}

	public EmployeeBasedComession(String firstName, String lastName, Date dob, String mobileNumber, String pEmail,
			String wEmail, String empno, Department department, double soldItemPMonth, double basedOnSalary) {
		super(firstName, lastName, dob, mobileNumber, pEmail, wEmail, empno, department, soldItemPMonth);
		this.basedOnSalary = basedOnSalary;

	}

	public double getBasedOnSalary() {
		return basedOnSalary;
	}

	public void setBasedOnSalary(double basedOnSalary) {
		this.basedOnSalary = basedOnSalary;
	}

	public double pay() {
		if (getSoldItemPMonth() < 20000 && getSoldItemPMonth() > 15000) {
			return (0.03 * getSoldItemPMonth()) + basedOnSalary;
		} else if (getSoldItemPMonth() > 20000) {
			return (0.05 * getSoldItemPMonth()) + basedOnSalary;
		} else {
			return (0.015 * getSoldItemPMonth()) + basedOnSalary;
		}

	}

	@Override
	public String toString() {
		return "EmployeeBasedComession [basedOnSalary=" + basedOnSalary + "]"+ "PAY"+pay();
	}

}
