package com.revature.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.revature.beans.TRMSForm;

public interface TRMSFormDAO {

		public void insertForm(TRMSForm trmsform) throws SQLException;
		
		public void makeRequest(TRMSForm trmsform) throws SQLException;
		
		
		
		
}
