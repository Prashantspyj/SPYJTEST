package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String first_name;
	private String last_Name;
	private String email;
	private String working_days;
	private long emp_leave;
	private long mobile_number;
	private String report_head;
	private String remark;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorking_days() {
		return working_days;
	}
	public void setWorking_days(String working_days) {
		this.working_days = working_days;
	}
	public long getEmp_leave() {
		return emp_leave;
	}
	public void setEmp_leave(long emp_leave) {
		this.emp_leave = emp_leave;
	}
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getReport_head() {
		return report_head;
	}
	public void setReport_head(String report_head) {
		this.report_head = report_head;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Employee(long id, String first_name, String last_Name, String email, String working_days, long emp_leave,
			long mobile_number, String report_head, String remark) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_Name = last_Name;
		this.email = email;
		this.working_days = working_days;
		this.emp_leave = emp_leave;
		this.mobile_number = mobile_number;
		this.report_head = report_head;
		this.remark = remark;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}