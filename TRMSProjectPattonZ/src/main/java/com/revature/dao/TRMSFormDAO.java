package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.TRMSForm;

public interface TRMSFormDAO {

		public void insertForm(TRMSForm trmsform) throws SQLException;
		
		public void makeRequest(TRMSForm trmsform) throws SQLException;
		
		public void uploadGrade(TRMSForm trmsform) throws SQLException;
		
		public List<TRMSForm> selectFormByEmp(int emp_id) throws SQLException;
		
		public void uploadAddDoc(TRMSForm trmsform) throws SQLException;
		
		public void cancelRequest(TRMSForm trmsform) throws SQLException;
		
	
}
