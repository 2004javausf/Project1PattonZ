package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.LoginDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String userN = request.getParameter("un");
		System.out.println(userN);
		String passW = request.getParameter("pass");
		System.out.println(passW);
		Employee c = LoginServlet.elog(userN, passW);
		System.out.println(c);
		try {
			if(c.getUser_name().equals(userN)) {
				EmployeeDAOImpl edi = new EmployeeDAOImpl();
				String emp = null;
				try {
					emp = edi.getOneEmp(userN).get(0).getName_first();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HttpSession session = request.getSession();
				session.setAttribute("username", userN);
				session.setAttribute("name", emp);
				pw.print("Welcome " + emp);
				RequestDispatcher rd = request.getRequestDispatcher("/employee.html");
				rd.include(request, response);
			}	
		}catch(NullPointerException npe) {
			pw.print("login Failed");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		
	}
	public static Employee elog (String unInput, String passInput) {
		LoginDAOImpl ldi = new LoginDAOImpl();
		try {
			for (int i = 0; i < ldi.getEmployeeList().size(); i++) {
				String user_name = ldi.getEmployeeList().get(i).getUser_name();
				String pass_word = ldi.getEmployeeList().get(i).getPass_word();
				if(unInput.equals(user_name) && passInput.equals(pass_word)) {
					return ldi.getEmployeeList().get(i);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
