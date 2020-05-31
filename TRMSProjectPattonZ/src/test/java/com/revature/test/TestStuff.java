package com.revature.test;

import java.sql.SQLException;

import com.revature.daoimpl.LoginDAOImpl;

public class TestStuff {
	public static void main(String[] args) {
//		TRMSFormDAOImpl tfdi = new TRMSFormDAOImpl();
//		try {
//			tfdi.makeRequest(1, "Zach", "Patton", "zacharypatton1991@gmail.com", "RevPro", "DevOp", "07-09-2020", "Online", 200, "Pass/Fail", "Pass");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String b = "12";
//		int a = Integer.parseInt(b);
//		System.out.println(a);
		
		LoginDAOImpl ldi = new LoginDAOImpl();
		try {
			System.out.println(ldi.getSupervisorList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
