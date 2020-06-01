package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.TRMSForm;
import com.revature.daoimpl.TRMSFormDAOImpl;

/**
 * Servlet implementation class BCAppDenServlet
 */
public class BCAppDenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BCAppDenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in bcappden doPost");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		TRMSForm trmsform = null;
		ObjectMapper mapper = new ObjectMapper();
		trmsform = mapper.readValue(request.getInputStream(), TRMSForm.class);
		TRMSFormDAOImpl tfdi = new TRMSFormDAOImpl();
		try {
			tfdi.bcappden(trmsform);
			pw.write("<h3>Request approved or denied</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
