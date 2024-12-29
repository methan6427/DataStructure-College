package application;

public abstract class Person {
private String id;
private String name;
private int age;
private String gender;
private String address;
private String contactinfo;
public Person(String id, String name, int age, String gender, String address, String contactinfo) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.address = address;
	this.contactinfo = contactinfo;
}
public abstract Person copy();
@Override
public String toString() {
	return  id + "," + name + "," + age + "," + gender + "," + address
			+ "," + contactinfo ;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContactinfo() {
	return contactinfo;
}
public void setContactinfo(String contactinfo) {
	this.contactinfo = contactinfo;
}


}
