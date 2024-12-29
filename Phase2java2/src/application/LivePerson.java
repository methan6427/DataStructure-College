package application;

public class LivePerson extends Person{

	public LivePerson(String id, String name, int age, String gender, String address, String contactinfo) {
		super(id, name, age, gender, address, contactinfo);
		// TODO Auto-generated constructor stub
	}
	@Override
	public LivePerson copy() {
		return new LivePerson(getId(), getName(), getAge(), getGender(), getAddress(), getContactinfo());
	}
	@Override
	public String toString() {
		return "LivePerson,"+super.toString();
	}

}
