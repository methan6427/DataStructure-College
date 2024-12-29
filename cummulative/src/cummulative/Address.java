package cummulative;

public class Address {
	private String state;
	private String city;
	private String street;

	public Address(){
		state="ramallah";
		city="kobar";
		street="alkarkafeh";

	}
	public Address(String state, String city, String street) {
		this.state = state;
		this.city = city;
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if (state!="" && state.matches("[a-zA-z]")){
			this.state=state;
		}
		else
		{
			System.out.println("INVALID ADDRESS!");
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (city!="" && city.matches("[a-zA-z]")){
			this.city=city;
		}
		else
		{
			System.out.println("INVALID ADDRESS!");
		}
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		if (street!="" && street.matches("[a-zA-z]")){
			this.street=street;
		}
		else
		{
			System.out.println("INVALID ADDRESS!");
		}
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", street=" + street + "]";
	}


}
