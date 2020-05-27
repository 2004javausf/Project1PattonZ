package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.LoginDAO;
import com.revature.util.ConnFactory;

public class LoginDAOImpl implements LoginDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public List<Employee> getEmployeeList() throws SQLException {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		Employee e = null;
		while (rs.next()) {
			e = new Employee (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7));
			employeeList.add(e);
		}
		return employeeList;
	}
}
