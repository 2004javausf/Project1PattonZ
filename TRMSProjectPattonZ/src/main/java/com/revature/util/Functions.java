package com.revature.util;

import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.beans.TRMSForm;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.TRMSFormDAOImpl;

public class Functions {
	public void addfunding(int x) {
		TRMSFormDAOImpl tfdi = new TRMSFormDAOImpl();
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		try {
			TRMSForm tf = tfdi.selectFormById(x).get(0);
			String sad = tf.getSup_appden();
			String dhad = tf.getDh_appden();
			String bcad = tf.getBenco_appden();
			String ct = tf.getCourse_type();
			int eid = tf.getEmp_id();
			
			if (sad.equalsIgnoreCase("approve") && dhad.equalsIgnoreCase("approve") && bcad.equalsIgnoreCase("approve")) {
				if(ct.equalsIgnoreCase("University Course")) {
					int cc = tf.getCourse_cost();
					double ra = cc*.80;
					System.out.println(ra);
					tfdi.addreim(x, ra);
					Employee e = edi.getEmp(eid).get(0);
					Double ar = e.getAvail_reim();
					double new_ar = ar - ra;
					edi.addfunding(eid, new_ar);
					System.out.println(new_ar);
				}else if(ct.equalsIgnoreCase("Seminar")) {
					int cc = tf.getCourse_cost();
					double ra = cc*.60;
					System.out.println(ra);
					tfdi.addreim(x, ra);
					Employee e = edi.getEmp(eid).get(0);
					Double ar = e.getAvail_reim();
					double new_ar = ar - ra;
					edi.addfunding(eid, new_ar);
					System.out.println(new_ar);
				}else if(ct.equalsIgnoreCase("Certification Prep Course")) {
					int cc = tf.getCourse_cost();
					double ra = cc*.75;
					System.out.println(ra);
					tfdi.addreim(x, ra);
					Employee e = edi.getEmp(eid).get(0);
					Double ar = e.getAvail_reim();
					double new_ar = ar - ra;
					edi.addfunding(eid, new_ar);
					System.out.println(new_ar);
				}else if(ct.equalsIgnoreCase("Certification")) {
					int cc = tf.getCourse_cost();
					double ra = cc*1.00;
					System.out.println(ra);
					tfdi.addreim(x, ra);
					Employee e = edi.getEmp(eid).get(0);
					Double ar = e.getAvail_reim();
					double new_ar = ar - ra;
					edi.addfunding(eid, new_ar);
					System.out.println(new_ar);
				}else if(ct.equals("Technical Training")) {
					int cc = tf.getCourse_cost();
					double ra = cc*.90;
					System.out.println(ra);
					tfdi.addreim(x, ra);
					Employee e = edi.getEmp(eid).get(0);
					Double ar = e.getAvail_reim();
					double new_ar = ar - ra;
					edi.addfunding(eid, new_ar);
					System.out.println(new_ar);
				}else {
					int cc = tf.getCourse_cost();
					double ra = cc*.30;
					System.out.println(ra);
					tfdi.addreim(x, ra);
					Employee e = edi.getEmp(eid).get(0);
					Double ar = e.getAvail_reim();
					double new_ar = ar - ra;
					edi.addfunding(eid, new_ar);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
