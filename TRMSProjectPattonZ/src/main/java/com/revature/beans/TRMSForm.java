package com.revature.beans;

import java.sql.Date;

public class TRMSForm {
	private int form_id;
	private int emp_id;
	private String name_first;
	private String name_last;
	private String email;
	private String course_title;
	private String course_type;
	private Date course_start_date;
	private String course_location;
	private int course_cost;
	private String grade_format;
	private String min_grade;
	private String add_doc;
	private String sup_appden;
	private String dh_appden;
	private String benco_appden;
	private double reim_amount;
	
	
	public TRMSForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TRMSForm(int form_id, int emp_id, String name_first, String name_last, String email, String course_title,
			String course_type, Date course_start_date, String course_location, int course_cost, String grade_format,
			String min_grade, String add_doc, String sup_appden, String dh_appden, String benco_appden,
			double reim_amount) {
		super();
		this.form_id = form_id;
		this.emp_id = emp_id;
		this.name_first = name_first;
		this.name_last = name_last;
		this.email = email;
		this.course_title = course_title;
		this.course_type = course_type;
		this.course_start_date = course_start_date;
		this.course_location = course_location;
		this.course_cost = course_cost;
		this.grade_format = grade_format;
		this.min_grade = min_grade;
		this.add_doc = add_doc;
		this.sup_appden = sup_appden;
		this.dh_appden = dh_appden;
		this.benco_appden = benco_appden;
		this.reim_amount = reim_amount;
	}


	public int getForm_id() {
		return form_id;
	}
	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName_first() {
		return name_first;
	}
	public void setName_first(String name_first) {
		this.name_first = name_first;
	}
	public String getName_last() {
		return name_last;
	}
	public void setName_last(String name_last) {
		this.name_last = name_last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse_title() {
		return course_title;
	}
	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public Date getCourse_start_date() {
		return course_start_date;
	}
	public void setCourse_start_date(Date course_start_date) {
		this.course_start_date = course_start_date;
	}
	public String getCourse_location() {
		return course_location;
	}
	public void setCourse_location(String course_location) {
		this.course_location = course_location;
	}
	public int getCourse_cost() {
		return course_cost;
	}
	public void setCourse_cost(int course_cost) {
		this.course_cost = course_cost;
	}
	public String getGrade_format() {
		return grade_format;
	}
	public void setGrade_format(String grade_format) {
		this.grade_format = grade_format;
	}
	public String getMin_grade() {
		return min_grade;
	}
	public void setMin_grade(String min_grade) {
		this.min_grade = min_grade;
	}
	public String getAdd_doc() {
		return add_doc;
	}
	public void setAdd_doc(String add_doc) {
		this.add_doc = add_doc;
	}
	public String getSup_appden() {
		return sup_appden;
	}
	public void setSup_appden(String sup_appden) {
		this.sup_appden = sup_appden;
	}
	public String getDh_appden() {
		return dh_appden;
	}
	public void setDh_appden(String dh_appden) {
		this.dh_appden = dh_appden;
	}
	public String getBenco_appden() {
		return benco_appden;
	}
	public void setBenco_appden(String benco_appden) {
		this.benco_appden = benco_appden;
	}
	public double getReim_amount() {
		return reim_amount;
	}
	public void setReim_amount(double reim_amount) {
		this.reim_amount = reim_amount;
	}
	@Override
	public String toString() {
		return "TRMSForm [form_id=" + form_id + ", emp_id=" + emp_id + ", name_first=" + name_first + ", name_last="
				+ name_last + ", email=" + email + ", course_title=" + course_title + ", course_type=" + course_type
				+ ", course_start_date=" + course_start_date + ", course_location=" + course_location + ", course_cost="
				+ course_cost + ", grade_format=" + grade_format + ", min_grade=" + min_grade + ", add_doc=" + add_doc
				+ ", sup_appden=" + sup_appden + ", dh_appden=" + dh_appden + ", benco_appden=" + benco_appden
				+ ", reim_amount=" + reim_amount + "]";
	}
	


}
