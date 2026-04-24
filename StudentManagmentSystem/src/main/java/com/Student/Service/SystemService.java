package com.Student.Service;

import java.util.Scanner;
import com.Student.Dao.AllInsertDao;
import com.Student.Dao.CourseDao;

public class SystemService {

	public void systemMenu() {

		Scanner sc = new Scanner(System.in);
		AllInsertDao aid = new AllInsertDao();
		CourseDao cd = new CourseDao();

		while (true) {

			System.out.println("------ System Menu --------");
			System.out.println("1. Batch Execution for Course (JDBC)");
			System.out.println("2. Insert using Stored Procedure");
			System.out.println("3. RETURN");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				aid.insertAllData();
				break;

			case 2:
				cd.insertCourseBatch();
				break;

			case 3:
				System.out.println("Go back...");
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}
}
