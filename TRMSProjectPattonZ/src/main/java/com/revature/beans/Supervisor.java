package com.revature.beans;

public class Supervisor {

		private String user_name;
		private String pass_word;
		
		
		
		public Supervisor() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Supervisor(String user_name, String pass_word) {
			super();
			this.user_name = user_name;
			this.pass_word = pass_word;
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
		@Override
		public String toString() {
			return "Supervisor [user_name=" + user_name + ", pass_word=" + pass_word + "]";
		}
		
		
}
