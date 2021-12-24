package java8_strms;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

import custom_exception.StudentHandlingException;

//Write a tester to print average of  gpa of students for the specified subject
public class Test5 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// get populated student map
			Map<String, Student> map = populateMap(populateList());
			System.out.println("Student data");
			//print the map entries
			map.forEach((k,v) -> System.out.println(v));
			// convert Map --> Collection<Student> : values() --> Stream<Student> : stream()
			// --> filter : subject wise --> mapToDouble : Function : s--> GPA  --> sum
			System.out.println("Enter subject");
			Subject subject=Subject.valueOf(sc.next().toUpperCase());
			
					System.out.println("Avg "+ map.values()
			.stream()
			.filter(s -> s.getSubject()==subject)
			.mapToDouble(Student :: getGpa)
			.average().orElseThrow(()->new StudentHandlingException("Empty stream!!!!!")));
					

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
