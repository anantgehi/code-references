package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.app.students.CoursesAvailable;
import com.app.students.Student;

import custom_exception.StudentHandlingException;

public interface CollectionUtils_Validations {
	
	public static void validateAndAddCourseAndRegDate(String course,LocalDate regDate,List<LocalDate> regDateList,List<String> courseList) throws StudentHandlingException {
		
		//checking RegDate constraints
		if(regDate.isBefore(LocalDate.now())) throw new StudentHandlingException("Registration Date should be greater than current date.");
		
		//checking course constraints
		try {
			CoursesAvailable.valueOf(course.toUpperCase());
			
		}catch(IllegalArgumentException e)
		{
			throw new StudentHandlingException("Course not available!! Choose from :"+ Arrays.toString(CoursesAvailable.values()));
		}
		
		//if it reaches here that means given regDate and course are valid. So we add them to corresponding Student object's regDateList and courseList.
		regDateList.add(regDate);
		courseList.add(course);
		
	}
	public static Student checkDuplicatesPerStudentPerCourse(String course, int id , List<Student> students) throws StudentHandlingException {
		Student s1= new Student(id);
		int index = students.indexOf(s1);
		if(index == -1) throw new StudentHandlingException("Student not found!!");
		
		s1= students.get(index);
		
		if(s1.getCourseList().contains(course)) throw new StudentHandlingException("Student already enrolled in the course. Cannot enroll again.");
		
		return s1;
		
	}
	
	
	public static List<Student> populateList(){
		List<Student> list= new ArrayList<>();
		
		list.add(new Student("Kamal",21));
		list.add(new Student("Manish",26));
		list.add(new Student("Avnish",25));
		list.add(new Student("Mohan",28));
		list.add(new Student("Rohan",30));

		return list;
	}

}
