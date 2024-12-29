package application;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double tawjihiGrade;
    private double placementTestGrade;
    private double admissionMark;
    private String chosenMajor;

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", tawjihiGrade=" + tawjihiGrade +
				", placementTestGrade=" + placementTestGrade +
				", admissionMark=" + admissionMark +
				", chosenMajor='" + chosenMajor + '\'' +
				'}';
	}

	public Student(int id, String name, double tawjihiGrade, double placementTestGrade, String chosenMajor) {
		super();
		this.id = id;
		this.name = name;
		this.tawjihiGrade = tawjihiGrade;
		this.placementTestGrade = placementTestGrade;
		this.chosenMajor = chosenMajor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTawjihiGrade() {
		return tawjihiGrade;
	}
	public void setTawjihiGrade(double tawjihiGrade) {
		this.tawjihiGrade = tawjihiGrade;
	}
	public double getPlacementTestGrade() {
		return placementTestGrade;
	}
	public void setPlacementTestGrade(double placementTestGrade) {
		this.placementTestGrade = placementTestGrade;
	}
	public double getAdmissionMark() {
		return admissionMark;
	}
	public void setAdmissionMark(double admissionMark) {
		this.admissionMark = admissionMark;
	}
	public String getChosenMajor() {
		return chosenMajor;
	}
	public void setChosenMajor(String chosenMajor) {
		this.chosenMajor = chosenMajor;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}
   
}
