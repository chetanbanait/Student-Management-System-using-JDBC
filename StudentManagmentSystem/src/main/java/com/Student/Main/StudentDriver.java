package com.Student.Main;

import java.util.Scanner;

import com.Student.Service.AdminServicec;
import com.Student.Service.StudentService;
import com.Student.Service.SystemService;

public class StudentDriver {
	public static void main(String[] args) {

		StudentService ss = new StudentService();
		AdminServicec as = new AdminServicec();
		SystemService sys=new SystemService();
		while (true) {
			System.out.println("------Wel-come to Student Managment System------");
			System.out.println();
			Scanner sc = new Scanner(System.in);

			System.out.println("Press 1  for : Student Menu");

			System.out.println("Press 2  for : Admin Menu");

			System.out.println("Press 3  for : System Feature");

			System.out.println("Press 4  for : Exit");

			System.out.println("Enter Your Choice");

			int Choice = sc.nextInt();
			switch (Choice) {
			case 1:
				ss.Studentmenu();
				break;
			case 2:
				as.adminMenu();
				break;
			case 3:
				sys.systemMenu();
				break;
			case 4:
				System.out.println("-----------Thank you for using------------");
				return;

			default:
				System.out.println("Enter Valid input");
				break;
			}
		}

	}
}
