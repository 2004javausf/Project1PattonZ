package com.revature.beans;

public class EmployeeBeans {

	private int emp_id;
	private String name_first;
	private String name_last;
	private String email;
	private String user_name;
	private String pass_word;
	private double avail_reim;
	
	
	public EmployeeBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeBeans(int emp_id, String name_first, String name_last, String email, String user_name,
			String pass_word, double avail_reim) {
		super();
		this.emp_id = emp_id;
		this.name_first = name_first;
		this.name_last = name_last;
		this.email = email;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.avail_reim = avail_reim;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName_first() {
		return name_first;
	}
	public void setName_first(String name_first) {
		this.name_first = name_first;
	}
	public String getName_last() {
		return name_last;
	}
	public void setName_last(String name_last) {
		this.name_last = name_last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public double getAvail_reim() {
		return avail_reim;
	}
	public void setAvail_reim(double avail_reim) {
		this.avail_reim = avail_reim;
	}
	@Override
	public String toString() {
		return "EmployeeBeans [emp_id=" + emp_id + ", name_first=" + name_first + ", name_last=" + name_last
				+ ", email=" + email + ", user_name=" + user_name + ", pass_word=" + pass_word + ", avail_reim="
				+ avail_reim + "]";
	}
	
}
