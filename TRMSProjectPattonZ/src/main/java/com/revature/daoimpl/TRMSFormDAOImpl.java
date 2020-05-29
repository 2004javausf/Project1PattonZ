package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.TRMSForm;
import com.revature.dao.TRMSFormDAO;
import com.revature.util.ConnFactory;

public class TRMSFormDAOImpl implements TRMSFormDAO {
	ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void insertForm(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO TRMSFORM VALUES(IDSEQ.NEXVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, trmsform.getEmp_id());
		ps.setString(2, trmsform.getName_first());
		ps.setString(3, trmsform.getName_last());
		ps.setString(4, trmsform.getEmail());
		ps.setString(5, trmsform.getCourse_title());
		ps.setString(6, trmsform.getCourse_type());
		ps.setString(7, trmsform.getCourse_start_date());
		ps.setString(8, trmsform.getCourse_location());
		ps.setInt(9, trmsform.getCourse_cost());
		ps.setString(10, trmsform.getGrade_format());
		ps.setString(11, trmsform.getMin_grade());
		ps.setString(12, trmsform.getAdd_doc());
		ps.setString(13, trmsform.getFinal_grade());
		ps.setString(14, trmsform.getSup_appden());
		ps.setString(15, trmsform.getDh_appden());
		ps.setString(16, trmsform.getBenco_appden());
		ps.setDouble(17, trmsform.getReim_amount());
		ps.executeUpdate();
	}
	@Override
	public void makeRequest(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call MAKEREQUEST (?,?,?,?,?,?,?,?,?,?,?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, trmsform.getEmp_id());
		call.setString(2, trmsform.getName_first());
		call.setString(3, trmsform.getName_last());
		call.setString(4, trmsform.getEmail());
		call.setString(5, trmsform.getCourse_title());
		call.setString(6, trmsform.getCourse_type());
		call.setString(7, trmsform.getCourse_start_date());
		call.setString(8, trmsform.getCourse_location());
		call.setInt(9, trmsform.getCourse_cost());
		call.setString(10, trmsform.getGrade_format());
		call.setString(11, trmsform.getMin_grade());
		call.executeUpdate();
	}

}

