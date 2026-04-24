package com.Student.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDao {
//crud operation on student entity or table

	public void registedStudentBatch() {
	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem","postgres", "root");

	        String query = "INSERT INTO student VALUES (?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(query);

	        Scanner sc = new Scanner(System.in);

	        System.out.print("How many students you want to insert: ");
	        int n = sc.nextInt();
	        sc.nextLine();

	        for (int i = 1; i <= n; i++) {
	            System.out.println("Enter details for student " + i);

	            System.out.print("Enter Student ID: ");
	            ps.setInt(1, sc.nextInt());
	            sc.nextLine();

	            System.out.print("Enter Student Name: ");
	            ps.setString(2, sc.nextLine());

	            System.out.print("Enter Email: ");
	            ps.setString(3, sc.nextLine());

	            System.out.print("Enter DOB: ");
	            ps.setString(4, sc.nextLine());

	            ps.addBatch();
	        }

	        int[] result = ps.executeBatch(); 

	        System.out.println("Batch Insert Completed. Records inserted: " + result.length);

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateStudent() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem",
					"postgres", "root");

			String Quary = "UPDATE student SET student_name=?, student_email=?, dob=? WHERE student_id=?";
			PreparedStatement ps = con.prepareStatement(Quary);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Student Name: ");
			ps.setString(1, sc.nextLine());

			System.out.print("Enter Student Email : ");
			ps.setString(2, sc.nextLine());

			System.out.print("Enter Date of Birth: ");
			ps.setString(3, sc.nextLine());

			System.out.print("Enter Student ID: ");
			ps.setInt(4, sc.nextInt());
			int result = ps.executeUpdate();

			if (result > 0)
				System.out.println("Course Updated Successfully");
			else
				System.out.println("Updateing Failed");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectAllStudent() {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem", "postgres", "root");

		String query = "SELECT * FROM student";
		PreparedStatement ps = con.prepareStatement(query);

		ResultSet rs = ps.executeQuery();
		System.out.println("----------Data from student table------------");
		while (rs.next()) {
			System.out.print(rs.getInt(1) + " ");
			System.out.print(rs.getString(2) + " ");
			System.out.print(rs.getString(3) + " ");
			System.out.println(rs.getString(4));
		}

		con.close();
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	public void assignGrade() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem", "postgres", "root");

			 Scanner sc = new Scanner(System.in);

		        System.out.print("Enter Enrollment ID: ");
		        int id = sc.nextInt();

		        System.out.print("Enter Grade (A/B/C): ");
		        String grade = sc.next();
		        String sql = "{ call assign_grade_fn(?, ?) }";

		        CallableStatement cs = con.prepareCall(sql);
		        cs.setInt(1, id);
		        cs.setString(2, grade);

		        cs.execute();

		        System.out.println(" Grade Assigned Successfully!");

		        con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void getStudentGrade() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem", "postgres", "root");
			Scanner sc = new Scanner(System.in);
	        System.out.print("Enter Student ID: ");
	        int studentId = sc.nextInt();

	        String sql = "SELECT * FROM get_student_grade(?)";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, studentId);

	        ResultSet rs = ps.executeQuery();

	        if (!rs.isBeforeFirst()) {
	            System.out.println(" No record found!");
	        }

	        while (rs.next()) {
	            
	            System.out.println("Student ID: " + rs.getInt("student_id"));
	            System.out.println("Name: " + rs.getString("student_name"));
	            System.out.println("Grade: " + rs.getString("grade"));
	        }

	        con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
