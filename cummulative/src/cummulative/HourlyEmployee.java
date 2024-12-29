package cummulative;
import java.util.Date;

public class HourlyEmployee extends Employee {
	private short hours;
	private float rate;

	public HourlyEmployee() {
		hours = 5;
		rate = 5;
	}

	public HourlyEmployee(String firstName, String lastName, Date dob, String mobileNumber, String pEmail,
			String wEmail, String empno, Department department, short hours, float rate) {
		super(firstName, lastName, dob, mobileNumber, pEmail, wEmail, empno, department);
		this.hours = hours;
		this.rate = rate;
	}



	public short getHours() {
		return hours;
	}

	public void setHours(short hours) {
		this.hours = hours;
	}

	public float getRate() {

		return rate;

	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public boolean isValid() {
		if ((hours < 288 && hours > 1) && (rate < 30 && rate > 8))
			return true;
		return false;
	}

	public double pay() {
		if (hours > 120)
			return 1.5 * (rate * hours);
		return rate * hours;
	}

	@Override
	public String toString() {
		return "HourlyEmployee [hours=" + hours + ", rate=" + rate + "]" + "PAY"+pay();
	}

}
