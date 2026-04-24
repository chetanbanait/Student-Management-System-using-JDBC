package com.Student.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AllInsertDao {

    public void insertAllData() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/StudentManagmentSystem",
                    "postgres", "root");

            Scanner sc = new Scanner(System.in);

            // Student
            System.out.print("Enter Student ID: ");
            int sid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String sname = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter DOB: ");
            String dob = sc.nextLine();

            // Course
            System.out.print("Enter Course ID: ");
            int cid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course Name: ");
            String cname = sc.nextLine();

            System.out.print("Enter Credit: ");
            double credit = sc.nextDouble();

            // Enrollment
            System.out.print("Enter Enrollment ID: ");
            int eid = sc.nextInt();

            System.out.print("Enter Grade: ");
            String grade = sc.next();

            // Call Stored Procedure
            PreparedStatement ps = con.prepareStatement(
            	    "CALL insert_all_data(?,?,?,?,?,?,?,?,?)"
            	);
            ps.setInt(1, sid);
            ps.setString(2, sname);
            ps.setString(3, email);
            ps.setString(4, dob);

            ps.setInt(5, cid);
            ps.setString(6, cname);
            ps.setDouble(7, credit);

            ps.setInt(8, eid);
            ps.setString(9, grade);

            ps.execute();

            System.out.println(" Data inserted successfully (All tables)");

            con.close();

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
