package cummulative;

import java.util.Date;

public class ContractEmployee extends Employee {
	private double rateOfContract;
	private byte noOfMonth;

	public ContractEmployee() {
		rateOfContract = 5;
		noOfMonth = 5;
	}

	

	public ContractEmployee(String firstName, String lastName, Date dob, String mobileNumber, String pEmail,
			String wEmail, String empno, Department department, double rateOfContract, byte noOfMonth) {
		super(firstName, lastName, dob, mobileNumber, pEmail, wEmail, empno, department);

		this.rateOfContract = rateOfContract;
		this.noOfMonth = noOfMonth;
	}

	public double getRateOfContract() {
		return rateOfContract;
	}

	public void setRateOfContract(double rateOfContract) {
		this.rateOfContract = rateOfContract;
	}

	public byte getNoOfMonth() {
		return noOfMonth;
	}

	public void setNoOfMonth(byte noOfMonth) {
		this.noOfMonth = noOfMonth;
	}

	public boolean isValid() {
		if (rateOfContract < 10000 && rateOfContract > 0)
			return true;
		return false;
	}

	public double pay() {
		return (rateOfContract / noOfMonth);
	}



	@Override
	public String toString() {
		return "ContractEmployee [rateOfContract=" + rateOfContract + ", noOfMonth=" + noOfMonth + "]"+ "PAY"+pay();
	}

}
