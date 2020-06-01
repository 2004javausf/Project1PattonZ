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
		
		public void supappden(TRMSForm trmsform) throws SQLException;
		
		public void dhappden(TRMSForm trmsform) throws SQLException;
		
		public void dhreqinfo(TRMSForm trmsform) throws SQLException;
		
		public void bcappden(TRMSForm trmsform) throws SQLException;
		
		public List<TRMSForm> selectFormById(int form_id) throws SQLException;
		
		public void addreim(int form_id, double reim_amount) throws SQLException;
}
