package application;

public class Major implements Comparable<Major>{
    private String name;
    private double acceptanceGrade;
    private double tawjihiWeight;
    private double placementTestWeight;
    private StudentList slist;
     int accept,reject;
   

    public Major(String name, double acceptanceGrade, double tawjihiWeight, double placementTestWeight) {
		super();
		this.name = name;
		this.acceptanceGrade = acceptanceGrade;
		this.tawjihiWeight = tawjihiWeight;
		this.placementTestWeight = placementTestWeight;
		this.slist=new StudentList();
	}

	public int AcceptedOrRejected(Student student){
		double result= (student.getTawjihiGrade()*tawjihiWeight)+(student.getPlacementTestGrade()*placementTestWeight);
			if(result<acceptanceGrade) {
				reject++;
				return -1;
			}
			accept++;
			slist.insertStudent(student);
			return 1;
	}
	public int checkStudent(Student student){
		double result= (student.getTawjihiGrade()*tawjihiWeight)+(student.getPlacementTestGrade()*placementTestWeight);
		if(result<acceptanceGrade) {
			return -1;
		}
		return 1;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getAcceptanceGrade() {
		return acceptanceGrade;
	}


	public void setAcceptanceGrade(double acceptanceGrade) {
		this.acceptanceGrade = acceptanceGrade;
	}


	public double getTawjihiWeight() {
		return tawjihiWeight;
	}


	public void setTawjihiWeight(double tawjihiWeight) {
		this.tawjihiWeight = tawjihiWeight;
	}


	public double getPlacementTestWeight() {
		return placementTestWeight;
	}


	public void setPlacementTestWeight(double placementTestWeight) {
		this.placementTestWeight = placementTestWeight;
	}


	public StudentList getSlist() {
		return slist;
	}


	public void setSlist(StudentList slist) {
		this.slist = slist;
	}


	public int getAccept() {
		return accept;
	}


	public void setAccept(int accept) {
		this.accept = accept;
	}


	public int getReject() {
		return reject;
	}


	public void setReject(int reject) {
		this.reject = reject;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Major name1 = (Major) o;
        return  name1.name.equalsIgnoreCase(this.name);
    }


    @Override
    public int compareTo( Major o) {
        return this.name.compareToIgnoreCase(o.name);
    }
}