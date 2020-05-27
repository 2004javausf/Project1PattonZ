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
import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

/**
 * Servlet implementation class EmployeePageServlet
 */
public class EmployeePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet");
		ObjectMapper mapper = new ObjectMapper();
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		String un = mapper.readValue(request.getParameter("userN"), String.class);
		PrintWriter pw = response.getWriter();
		String empJSON;
		try {
			empJSON = mapper.writeValueAsString(edi.getOneEmp(un));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(empJSON);
			System.out.println(empJSON);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		String a = request.getParameter("un");
		try {
			Employee user = edi.getOneEmp(a).get(0);
			pw.print("Welcome " + user.getName_first());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
