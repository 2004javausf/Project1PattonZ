package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	public List<Employee> getOneEmp(String user_name) throws SQLException;
}
