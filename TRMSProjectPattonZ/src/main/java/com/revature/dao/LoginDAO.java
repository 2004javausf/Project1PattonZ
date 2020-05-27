package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface LoginDAO {
	public List<Employee> getEmployeeList() throws SQLException;
}
