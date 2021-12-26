package Tester;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.app.students.CoursesAvailable;
import com.app.students.Student;

import static utils.CollectionUtils_Validations.*;

public class StudentEnrollmentApp {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			List<Student> students = populateList();
			boolean exit= false;
			while(!exit) {
				try {
					
					System.out.println("");
					System.out.println("***************************************************");
					System.out.println("Choose an Option: ");
					System.out.println("1) Display all students");
					System.out.println("2) Enroll a student in a course");
					System.out.println("3) Show course wise Student list");
					System.out.println("4) Store Student information to a Binary file"); //serialization
					System.out.println("5) Restore Student information from a Binary file"); //deserialization
					System.out.println("20) Exit");
					System.out.println("***************************************************");
					
					switch (sc.nextInt()) {
					case 1:
						
						/* Display all students */
						
						students.stream().forEach(System.out::println);

						break;
						
					case 2:
						
						/* Enroll a student in a course */
						
						System.out.println("Enter Student ID, Course Name and Registration Date(yyyy-mm-dd)");
						int id = sc.nextInt();
						String course = sc.next();
						LocalDate regDate = LocalDate.parse(sc.next());
						Student s1=checkDuplicatesPerStudentPerCourse(course,id,students);
						validateAndAddCourseAndRegDate(course,regDate,s1.getRegDateList(),s1.getCourseList());
						
						System.out.println("Student " + s1.getId()+" enrolled in course :"+ course);

						break;
						
					case 3:
						
						/* Show course wise Student list */
						
						for(CoursesAvailable c1 : CoursesAvailable.values())
						{
							System.out.println("Students Enrolled in course: "+ c1);
							for(Student s : students)
							{
								for(String course1 : s.getCourseList())
								{
									CoursesAvailable cour=CoursesAvailable.valueOf(course1.toUpperCase());
									if(c1==cour)
									{
										
										System.out.println("StudentName: "+s.getName()+ " ID: "+s.getId());
										
									}
								}
							}
							System.out.println();
						}

						break;
						
					case 4:

						break;
						
					case 5:

						break;
						
						
						
					case 20:
						exit = true;
						System.out.println("Exiting...Good Bye...");
						break;

					default:
						System.out.println("Invalid choice!!");	
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}
		}

	}

}

//2 1 Java 2021-12-26
//2 1 Angular 2021-12-26
//2 1 React 2021-12-26
//2 1 DBT 2021-12-26
//2 2 Angular 2021-12-26
//2 2 React 2021-12-26
//2 3 Angular 2021-12-26
//2 3 Python 2021-12-26
//2 4 se 2021-12-26
//2 4 React 2021-12-26
//2 5 DBT 2021-12-26
//2 5 Python 2021-12-26
