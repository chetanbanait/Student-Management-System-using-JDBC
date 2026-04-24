package com.Student.Service;

import java.util.Scanner;

import com.Student.Dao.AddDetails;
import com.Student.Dao.CourseDao;
import com.Student.Dao.EnrollmentDao;
import com.Student.Dao.StudentDao;

public class AdminServicec {

	public void adminMenu() {
		while (true) {
			System.out.println();
			Scanner sc = new Scanner(System.in);
			CourseDao cdd = new CourseDao();
			StudentDao sdd = new StudentDao();
			AddDetails ad = new AddDetails();

			EnrollmentDao edd = new EnrollmentDao();
			System.out.println("Press 1  for : Add/update/delete course");
			System.out.println("Press 2  for : View all Students");
			System.out.println("Press 3  for : View all courses");
			System.out.println("Press 4  for : View all Enrollments");
			System.out.println("Press 5  for : assign Grade");
			System.out.println("Press 6  for : add_course , add_student, add_enrollment");
			System.out.println("Press 7  for : Go back");
			System.out.println("Enter Your Choice");

			int Choice = sc.nextInt();
			switch (Choice) {
			case 1:
				cdd.callmethod();
				break;
			case 2:
				sdd.selectAllStudent();
				break;
			case 3:
				cdd.selectCourse();
				break;
			case 4:
				edd.selectEnrollments();
				break;
			case 5:
				sdd.assignGrade();
				break;
			case 6:
				ad.addingAll();
				break;
			case 7:
				return;

			default:
				System.out.println("Enter Valid input");
				break;
			}
		}

	}
}
