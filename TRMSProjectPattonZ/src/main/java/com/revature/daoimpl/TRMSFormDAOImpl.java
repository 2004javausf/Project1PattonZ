package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	@Override
	public void uploadGrade(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE TRMSFORM SET FINAL_GRADE=(?) WHERE FORM_ID=(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, trmsform.getFinal_grade());
		ps.setInt(2, trmsform.getForm_id());
		ps.executeUpdate();
	}
	@Override
	public List<TRMSForm> selectFormByEmp(int emp_id) throws SQLException {
		List<TRMSForm> trmsformlist = new ArrayList<TRMSForm>();
		TRMSForm trmsform = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery("SELECT * FROM TRMSFORM WHERE EMP_ID=" + emp_id);
		while(rs.next()){
			trmsform = new TRMSForm(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getDouble(18));
			trmsformlist.add(trmsform);
		}
		return trmsformlist;
	}
	@Override
	public void uploadAddDoc(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE TRMSFORM SET ADD_DOC=(?) WHERE FORM_ID=(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, trmsform.getAdd_doc());
		ps.setInt(2, trmsform.getForm_id());
		ps.executeUpdate();
		
	}
	@Override
	public void cancelRequest(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM TRMSFORM WHERE FORM_ID = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, trmsform.getForm_id());
		ps.executeUpdate();
		
	}
	@Override
	public void supappden(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE TRMSFORM SET SUP_APPDEN=(?) WHERE FORM_ID=(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, trmsform.getSup_appden());
		ps.setInt(2, trmsform.getForm_id());
		ps.executeUpdate();
		
	}
	@Override
	public void dhappden(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE TRMSFORM SET DH_APPDEN=(?) WHERE FORM_ID=(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, trmsform.getDh_appden());
		ps.setInt(2, trmsform.getForm_id());
		ps.executeUpdate();
	}
	@Override
	public void dhreqinfo(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE TRMSFORM SET ADD_DOC = (?) WHERE FORM_ID=(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, trmsform.getAdd_doc());
		ps.setInt(2, trmsform.getForm_id());
		ps.executeUpdate();
		
	}
	@Override
	public void bcappden(TRMSForm trmsform) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE TRMSFORM SET BENCO_APPDEN = (?) WHERE FORM_ID=(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, trmsform.getBenco_appden());
		ps.setInt(2, trmsform.getForm_id());
		ps.executeUpdate();
	}
	@Override
	public List<TRMSForm> selectFormById(int form_id) throws SQLException {
		List<TRMSForm> trmsformlist = new ArrayList<TRMSForm>();
		TRMSForm trmsform = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs =stmt.executeQuery("SELECT * FROM TRMSFORM WHERE FORM_ID=" + form_id);
		while(rs.next()){
			trmsform = new TRMSForm(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getDouble(18));
			trmsformlist.add(trmsform);
		}
		return trmsformlist;
	}
	@Override
	public void addreim(int form_id, double reim_amount) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE TRMSFORM SET REIM_AMOUNT = (?) WHERE FORM_ID=(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, reim_amount);
		ps.setInt(2, form_id);
		ps.executeUpdate();
	}

}
