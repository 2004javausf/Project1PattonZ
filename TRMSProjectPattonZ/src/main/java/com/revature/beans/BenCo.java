package com.revature.beans;

public class BenCo {
	private String bc_user_name;
	private String bc_pass_word;
	
	
	public BenCo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BenCo(String bc_user_name, String bc_pass_word) {
		super();
		this.bc_user_name = bc_user_name;
		this.bc_pass_word = bc_pass_word;
	}
	public String getBc_user_name() {
		return bc_user_name;
	}
	public void setBc_user_name(String bc_user_name) {
		this.bc_user_name = bc_user_name;
	}
	public String getBc_pass_word() {
		return bc_pass_word;
	}
	public void setBc_pass_word(String bc_pass_word) {
		this.bc_pass_word = bc_pass_word;
	}
	@Override
	public String toString() {
		return "BenCo [bc_user_name=" + bc_user_name + ", bc_pass_word=" + bc_pass_word + "]";
	}
	
	
}
