package com.Student.Service;

import java.util.Scanner;

import com.Student.Dao.CourseDao;
import com.Student.Dao.StudentDao;
import com.Student.Entity.Course;

public class StudentService {

	public void Studentmenu() {
		Scanner sc = new Scanner(System.in);
		StudentDao sd=new StudentDao();
		CourseDao cd=new CourseDao();
		while(true) {
		System.out.println(" ------- Student Menu -------- ");
		System.out.println("Press 1  for : Register Student");
		System.out.println("Press 2  for : Update Student Profile");
		System.out.println("Press 3  for : Enrollment in a Course");
		System.out.println("Press 4  for : View all Courses");	
		System.out.println("Press 5  for : View all Student");
		System.out.println("Press 6  for : View Grade");
		System.out.println("Press 7  for : Go Back");
		System.out.println();
		System.out.println("-------Enter Your Choice---------");

		int Choice = sc.nextInt();
		switch (Choice) {
		case 1:
			sd.registedStudentBatch();
			break;
		case 2:
			sd.updateStudent();
			break;
		case 3:
			cd.insertCourseBatch();
			break;
		case 4:
			cd.selectCourse();
			break;
		case 5:
			sd.selectAllStudent();
			break;
		case 6:
			sd.getStudentGrade();
			break;
		case 7:
			System.out.println("Thank you....!!");
			return;
		default:
			System.out.println("Enter Valid input");
			break;
		}
		}

	}
}
