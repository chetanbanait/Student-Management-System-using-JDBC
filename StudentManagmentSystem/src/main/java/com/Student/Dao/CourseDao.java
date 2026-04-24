package com.Student.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CourseDao {
	public void insertCourseBatch() {
	    try {
	    	Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem","postgres", "root");


	        String query = "INSERT INTO course VALUES (?,?,?)";
	        PreparedStatement ps = con.prepareStatement(query);

	        Scanner sc = new Scanner(System.in);

	        System.out.print("How many courses: ");
	        int n = sc.nextInt();
	        sc.nextLine();

	        for (int i = 1; i <= n; i++) {
	            System.out.println("Enter course " + i);

	            System.out.print("Enter Course ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter Course Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Credit: ");
	            double credit = sc.nextDouble();

	            ps.setInt(1, id);
	            ps.setString(2, name);
	            ps.setDouble(3, credit);

	            ps.addBatch();
	        }

	        ps.executeBatch();
	        System.out.println("Courses inserted successfully");

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void selectCourse() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem",
					"postgres", "root");

			String query = "SELECT * FROM course";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			System.out.println("--------Data from course table---------");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.println(rs.getDouble(3));
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCourse() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem",
					"postgres", "root");

			Scanner sc = new Scanner(System.in);
			String query = "UPDATE course SET course_name=?, credits=? WHERE course_id=?";
			PreparedStatement ps = con.prepareStatement(query);

			System.out.print("Enter New course_name: ");
			ps.setString(1, sc.nextLine());

			System.out.print("Enter New credit: ");
			ps.setDouble(2, sc.nextDouble());

			System.out.print("Enter id to Update: ");
			ps.setInt(3, sc.nextInt());

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

	public void deleteCourse() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentManagmentSystem",
					"postgres", "root");

			String query = "DELETE FROM course WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.print("Enter Course ID to Delete: ");

			Scanner sc = new Scanner(System.in);
			ps.setInt(1, sc.nextInt());

			int count = ps.executeUpdate();

			if (count > 0)
				System.out.println("Course Deleted Successfully");
			else
				System.out.println("NOT DELETED");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void callmethod() {
		while (true) {

			System.out.println();
			Scanner sc = new Scanner(System.in);

			System.out.println("Press 1  for : Add course");

			System.out.println("Press 2  for : Update course");

			System.out.println("Press 3  for : delete course");

			System.out.println("Press 4  for : Exit");

			System.out.println("Enter Your Choice");

			int Choice = sc.nextInt();
			switch (Choice) {
			case 1:
				insertCourseBatch();
				break;
			case 2:
				updateCourse();
				break;
			case 3:
				deleteCourse();
				break;
			case 4:
				System.out.println("-----------Thank you------------");
				return;

			default:
				System.out.println("Enter Valid input");
				break;
			}
		}

	}
}
