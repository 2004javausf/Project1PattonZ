package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.BenCo;
import com.revature.beans.Dephead;
import com.revature.beans.Employee;
import com.revature.beans.Supervisor;

public interface LoginDAO {
	public List<Employee> getEmployeeList() throws SQLException;
	
	public List<Supervisor> getSupervisorList() throws SQLException;
	
	public List<Dephead> getDepheadList() throws SQLException;
	
	public List<BenCo> getBenCoList() throws SQLException;
}
