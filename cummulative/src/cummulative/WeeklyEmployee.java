package cummulative;
import java.util.Date;

public class WeeklyEmployee extends Employee {
	private byte numOfWeeks;
	private float wagePWeek;

	public WeeklyEmployee() {
		numOfWeeks = 5;
		wagePWeek = 5;
	}

	public WeeklyEmployee(String firstName, String lastName, Date dob, String mobileNumber, String pEmail,
			String wEmail, String empno, Department department, byte numOfWeeks, float wagePWeek) {
		super(firstName, lastName, dob, mobileNumber, pEmail, wEmail, empno, department);
		this.numOfWeeks = numOfWeeks;
		this.wagePWeek = wagePWeek;
	}

	public byte getNumOfWeeks() {
		return numOfWeeks;
	}

	public void setNumOfWeeks(byte numOfWeeks) {
		this.numOfWeeks = numOfWeeks;
	}

	public float getWagePWeek() {
		return wagePWeek;
	}

	public void setWagePWeek(float wagePWeek) {
		this.wagePWeek = wagePWeek;
	}

	public boolean isValid() {
		if ((numOfWeeks < 4 && numOfWeeks > 1) && (wagePWeek < 700 && wagePWeek > 300))
			return true;
		return false;
	}

	public double pay(){
		return numOfWeeks*wagePWeek;
	}

	@Override
	public String toString() {
		return "WeeklyEmployee [numOfWeeks=" + numOfWeeks + ", wagePWeek=" + wagePWeek + "]"+ "PAY"+pay();
	}

}
