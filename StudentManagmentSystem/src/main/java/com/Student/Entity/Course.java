package com.Student.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Course {

	private int id;
	private String Course_name;
	private double Credit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_name() {
		return Course_name;
	}

	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}

	public double getCredit() {
		return Credit;
	}

	public void setCredit(double credit) {
		Credit = credit;
	}

}
