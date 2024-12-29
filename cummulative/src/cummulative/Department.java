package cummulative;

public class Department {
	private String depname;
	private int deptno;
	private String dep_location;

	public Department(){
		depname="it";
		deptno=5;
		dep_location="birzeit";

	}
	public Department(String depname, int deptno,String dep_location) {

		this.depname = depname;
		this.deptno = deptno;
		this.dep_location=dep_location;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Department [depname=" + depname + ", deptno=" + deptno + "]";
	}


}
