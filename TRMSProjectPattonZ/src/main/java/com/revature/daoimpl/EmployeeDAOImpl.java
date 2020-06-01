package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public List<Employee> getOneEmp(String user_name) throws SQLException {
		List<Employee> getOneEmp = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE USER_NAME = '" + user_name + "'");
		Employee e = null;
		while (rs.next()) {
			e = new Employee (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7));
			getOneEmp.add(e);
		}
		return getOneEmp;
		
	}
	@Override
	public void addfunding(int emp_id, double avial_reim) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE EMPLOYEE SET AVAIL_REIM = (?) WHERE EMP_ID=(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, avial_reim);
		ps.setInt(2, emp_id);
		ps.executeUpdate();
	}
	@Override
	public List<Employee> getEmp(int emp_id) throws SQLException {
		List<Employee> getOneEmp = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = " + emp_id);
		Employee e = null;
		while (rs.next()) {
			e = new Employee (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7));
			getOneEmp.add(e);
		}
		return getOneEmp;
	}

}
