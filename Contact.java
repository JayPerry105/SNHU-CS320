package test;

public class Contact {
		
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		if (id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		if (id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
}
