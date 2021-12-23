package java8_strms;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

//Write a tester to print average of  gpa of students for the specified subject
public class Test4 {

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
			
					OptionalDouble optional = map.values()
			.stream()
			.filter(s -> s.getSubject()==subject)
			.mapToDouble(Student :: getGpa)
			.average();
					if(optional.isPresent())
						System.out.println("Avg : "+optional.getAsDouble());
					else
						System.out.println("empty optional");

		}

	}

}
