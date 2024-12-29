package application;

public class Martyr extends Person{
private String dateofmartyrdom;
private String causeofdeath;
private String placeofdeath;
public Martyr(String id, String name, int age, String gender, String address, String contactinfo,
		String dateofmartyrdom, String causeofdeath, String placeofdeath) {
	super(id, name, age, gender, address, contactinfo);
	this.dateofmartyrdom = dateofmartyrdom;
	this.causeofdeath = causeofdeath;
	this.placeofdeath = placeofdeath;
}
@Override
public Martyr copy() {
	return new Martyr(causeofdeath, causeofdeath, getAge(), causeofdeath, causeofdeath, causeofdeath, dateofmartyrdom, causeofdeath, placeofdeath);
}
public String getDateofmartyrdom() {
	return dateofmartyrdom;
}
public void setDateofmartyrdom(String dateofmartyrdom) {
	this.dateofmartyrdom = dateofmartyrdom;
}
public String getCauseofdeath() {
	return causeofdeath;
}
public void setCauseofdeath(String causeofdeath) {
	this.causeofdeath = causeofdeath;
}
public String getPlaceofdeath() {
	return placeofdeath;
}
public void setPlaceofdeath(String placeofdeath) {
	this.placeofdeath = placeofdeath;
}
@Override
public String toString() {
	return "Martyr,"+super.toString()+"," + dateofmartyrdom + "," + causeofdeath + ","
			+ placeofdeath ;
}
	

}
