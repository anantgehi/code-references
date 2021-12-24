package java8_strms;

import static utils.StudentCollectionUtils.populateList;

import java.util.Comparator;
import java.util.List;

import com.app.core.Student;
import static java.util.Comparator.comparing;


//2. Display all student details(list) sorted as per GPA : (using single java statement)
public class Test2 {

	public static void main(String[] args) {
		// Display all student details from a list
		List<Student> list = populateList();
		System.out.println("original list ");
		list.forEach(System.out::println);
//		Comparator<Student> studComp = (s1, s2) -> ((Double) s1.getGpa()).compareTo(s2.getGpa());
		// list.stream().sorted().forEach(System.out::println); un comment this to
		// understand Natural ordering vs Custom ordering
		System.out.println("Student details sorted as per GPA ");
//		list.stream().sorted(studComp).forEach(System.out::println);//custom ordering
		//OR 
//		list.stream().sorted(comparing(s -> s.getGpa())).forEach(System.out::println);
		list.stream().sorted(comparing(Student::getGpa).reversed()).forEach(System.out::println);

	}

}
