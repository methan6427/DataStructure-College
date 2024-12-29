package cummulative;
import java.util.Date;

public class Employee extends staffMember {
	private String empno;
	private Department department;

	public Employee() {
		empno="10";
		department=new Department();
		
	}
	

	public Employee(String firstName, String lastName, Date dob, String mobileNumber, String pEmail, String wEmail,
			String empno, Department department) {
		super(firstName, lastName, dob, mobileNumber, pEmail, wEmail);
		this.empno = empno;
		this.department = department;

	}

	public Employee(String string, String string2, int i, String string3, String string4, String string5, int j) {
		
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", department=" + department + "]"+ "PAY"+pay();
	}

}
