package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.BenCo;
import com.revature.beans.Dephead;
import com.revature.beans.Employee;
import com.revature.beans.Supervisor;
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
	@Override
	public List<Supervisor> getSupervisorList() throws SQLException {
		List<Supervisor> supervisorList = new ArrayList<Supervisor>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM SUPERVISOR");
		Supervisor s = null;
		while(rs.next()) {
			s = new Supervisor (rs.getString(1), rs.getString(2));
			supervisorList.add(s);
		}
		return supervisorList;
	}
	@Override
	public List<Dephead> getDepheadList() throws SQLException {
		List<Dephead> depheadList = new ArrayList<Dephead>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM DEPHEAD");
		Dephead d = null;
		while(rs.next()) {
			d = new Dephead(rs.getString(1), rs.getString(2));
			depheadList.add(d);
		}
		return depheadList;
	}
	@Override
	public List<BenCo> getBenCoList() throws SQLException {
		List<BenCo> bencoList = new ArrayList<BenCo>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM BENCO");
		BenCo bc = null;
		while(rs.next()) {
			bc = new BenCo(rs.getString(1), rs.getString(2));
			bencoList.add(bc);
		}
		return bencoList;
	}
	
	
}
