package com.Student.Dao;

import java.util.Scanner;

public class AddDetails {

	public void addingAll() {

		AllInsertDao aid = new AllInsertDao();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. Insert All Data (Student + Course + Enrollment)");
			System.out.println("2. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				aid.insertAllData();
				break;

			case 2:
				System.out.println("Thank You!");
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}