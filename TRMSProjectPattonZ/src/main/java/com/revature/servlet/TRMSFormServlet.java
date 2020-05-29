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
 * Servlet implementation class TRMSFormServlet
 */
public class TRMSFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TRMSFormServlet() {
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
		System.out.println("in doPost");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		TRMSForm trmsform = null;
		ObjectMapper mapper = new ObjectMapper();
		trmsform = mapper.readValue(request.getInputStream(), TRMSForm.class);
//		int a = Integer.parseInt(request.getParameter("emp_id"));
//		System.out.println(a);
//		String b = request.getParameter("name_first");
//		String c = request.getParameter("name_last");
//		String d = request.getParameter("email");
//		String e = request.getParameter("course_title");
//		String f = request.getParameter("course_type");
//		String g = request.getParameter("course_start_date");
//		String h = request.getParameter("course_location");
//		int i = Integer.parseInt(request.getParameter("course_cost"));
//		String j = request.getParameter("grade_format");
//		String k = request.getParameter("min_grade");
		TRMSFormDAOImpl tfdi = new TRMSFormDAOImpl();
		try {
			tfdi.makeRequest(trmsform);
			pw.write("<h3> Submitted TRMS request. Please allow time before approval</h3>");
			pw.close();
		} catch (SQLException z) {
			// TODO Auto-generated catch block
			z.printStackTrace();
		}
		
	}

}
