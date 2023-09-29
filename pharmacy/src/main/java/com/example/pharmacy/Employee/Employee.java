package com.example.pharmacy.Employee;


public class Employee {
	
	private int id;
	private String ssn;
    private String username;
    private String password;
    private String first_name;
    private String last_name ;
    private String role;
    private float salary ;
    private String phoneNumber;
    
    

	public Employee() {}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", ssn=" + ssn + ", username=" + username + ", password=" + password
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", role=" + role + ", salary=" + salary
				+ ", phoneNumber=" + phoneNumber + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public float getSalary() {
		return salary;
	}



	public void setSalary(float salary) {
		this.salary = salary;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Employee(int id, String ssn, String username, String password, String first_name, String last_name,
			String role, float salary, String phoneNumber) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
	}
	

	
    
    
    

}
