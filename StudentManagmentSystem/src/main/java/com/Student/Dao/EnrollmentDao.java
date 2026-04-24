package com.Student.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EnrollmentDao {
	public void insertEnrollmentBatch() {
	    try {
	    	Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem","postgres", "root");


	        String query = "INSERT INTO enrolment VALUES (?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(query);

	        Scanner sc = new Scanner(System.in);

	        System.out.print("How many enrollments: ");
	        int n = sc.nextInt();

	        for (int i = 1; i <= n; i++) {
	            System.out.println("Enter enrollment " + i);

	            ps.setInt(1, sc.nextInt());
	            ps.setInt(2, sc.nextInt());
	            ps.setInt(3, sc.nextInt());
	            ps.setString(4, sc.next());

	            ps.addBatch();
	        }

	        ps.executeBatch();
	        System.out.println("Enrollments inserted successfully");

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void selectEnrollments() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem",
					"postgres", "root");

			String query = "SELECT * FROM enrolment";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			System.out.println("--------Data from Enrollment table---------");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + " ");
				System.out.print(rs.getInt(2) + " ");
				System.out.print(rs.getInt(3) + " ");
				System.out.print(rs.getString(4) + " ");
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
