package java8_strms;
import static utils.StudentCollectionUtils.populateList;

import java.util.List;

import com.app.core.Student;

//1. Display all student details from a list
//eg : Iterable's forEach (lambda expr / method ref)
public class Test1 {

	public static void main(String[] args) {
		// Display all student details from a list
		List<Student> list = populateList();
		System.out.println("printing list using lambda expr");
		list.forEach(s -> System.out.println(s));
		System.out.println("printing list using method reference");
		list.forEach(System.out::println);
		

	}

}
