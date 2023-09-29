package com.example.pharmacy.customer;



public class Customer {
	
    private String ssn;
    private String username;
    private String password;
    private String first_name;
    private String last_name ;
    private String phone;
    private String gender ;
    private String address;
    private String dateOfBirth;
    
    
    
    public Customer() {}



	@Override
	public String toString() {
		return "Customer [ssn=" + ssn + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", phone=" + phone + ", gender=" + gender + ", address="
				+ address + ", dateOfBirth=" + dateOfBirth + "]";
	}



	public Customer(String ssn, String username, String password, String first_name, String last_name, String phone,
			String gender, String address, String dateOfBirth) {
		super();
		this.ssn = ssn;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}



	public String getSsn() {
		return ssn;
	}



	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
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



	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDate_of_birth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
    





    
}
