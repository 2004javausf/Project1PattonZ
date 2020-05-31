package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Supervisor;

public interface LoginDAO {
	public List<Employee> getEmployeeList() throws SQLException;
	
	public List<Supervisor> getSupervisorList() throws SQLException;
}
