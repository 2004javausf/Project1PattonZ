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

import com.revature.beans.Dephead;
import com.revature.beans.Supervisor;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.LoginDAOImpl;

/**
 * Servlet implementation class DepheadLoginServlet
 */
public class DepheadLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepheadLoginServlet() {
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
		String userN = request.getParameter("un");
		System.out.println(userN);
		String passW = request.getParameter("pass");
		System.out.println(passW);
		Dephead d = DepheadLoginServlet.dlog(userN, passW);
		System.out.println(d);
		try {
			if(d.getDh_user_name().equals(userN)) {
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
				RequestDispatcher rd = request.getRequestDispatcher("/dephead.html");
				rd.include(request, response);
			}	
		}catch(NullPointerException npe) {
			pw.print("login Failed");
			RequestDispatcher rd = request.getRequestDispatcher("/depheadlogin.html");
			rd.include(request, response);
		}
	}
	public static Dephead dlog (String unInput, String passInput) {
		LoginDAOImpl ldi = new LoginDAOImpl();
		try {
			for (int i = 0; i < ldi.getDepheadList().size(); i++) {
				String user_name = ldi.getDepheadList().get(i).getDh_user_name();
				String pass_word = ldi.getDepheadList().get(i).getDh_pass_word();
				if(unInput.equals(user_name) && passInput.equals(pass_word)) {
					return ldi.getDepheadList().get(i);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
