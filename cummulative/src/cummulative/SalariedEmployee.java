package cummulative;
import java.util.Date;

public class SalariedEmployee extends Employee {
	private double annualSalary;

	public SalariedEmployee() {
		annualSalary = 5;
	}

	public SalariedEmployee(String firstName, String lastName, Date dob, String mobileNumber, String pEmail,
			String wEmail, String empno, Department department,double annualSalary) {
		super(firstName, lastName, dob, mobileNumber, pEmail, wEmail, empno, department);
		this.annualSalary=annualSalary;

	}

	

	
	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public boolean isValid() {
		if (annualSalary < 120000 && annualSalary > 21600)
			return true;
		return false;
	}

	public double pay() {
		return (annualSalary / 12);
	}

	@Override
	public String toString() {
		return "SalariedEmployee [annualSalary=" + annualSalary + "]" + "PAY"+pay();
	}

}
