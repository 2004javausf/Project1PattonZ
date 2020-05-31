package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.TRMSForm;
import com.revature.daoimpl.TRMSFormDAOImpl;

/**
 * Servlet implementation class ULGradeServlet
 */
public class ULGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ULGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TRMSFormDAOImpl tdfi = new TRMSFormDAOImpl();
		int id = mapper.readValue(request.getParameter("emp_id"), Integer.class);
		PrintWriter pw = response.getWriter();
		String formJSON;
		try {
			formJSON = mapper.writeValueAsString(tdfi.selectFormByEmp(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(formJSON);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in grade doPost");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		TRMSForm trmsform = null;
		ObjectMapper mapper = new ObjectMapper();
		trmsform = mapper.readValue(request.getInputStream(), TRMSForm.class);
		TRMSFormDAOImpl tfdi = new TRMSFormDAOImpl();
		try {
			tfdi.uploadGrade(trmsform);
			pw.write("<h3>Grade Added</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
