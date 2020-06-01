package com.revature.beans;

public class Dephead {
	
	private String dh_user_name;
	private String dh_pass_word;
	
	public Dephead() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dephead(String dh_user_name, String dh_pass_word) {
		super();
		this.dh_user_name = dh_user_name;
		this.dh_pass_word = dh_pass_word;
	}
	public String getDh_user_name() {
		return dh_user_name;
	}
	public void setDh_user_name(String dh_user_name) {
		this.dh_user_name = dh_user_name;
	}
	public String getDh_pass_word() {
		return dh_pass_word;
	}
	public void setDh_pass_word(String dh_pass_word) {
		this.dh_pass_word = dh_pass_word;
	}
	@Override
	public String toString() {
		return "Dephead [dh_user_name=" + dh_user_name + ", dh_pass_word=" + dh_pass_word + "]";
	}
	
	
	
}
