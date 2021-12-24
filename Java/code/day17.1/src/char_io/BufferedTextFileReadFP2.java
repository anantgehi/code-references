package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedTextFileReadFP2 {

	public static void main(String[] args) {
		System.out.println("Enter file name along with path to read data");
		try (Scanner sc = new Scanner(System.in);
				// Java App <----BR <----FR <---Text file
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) {
			// => chaining of I/O strms successful!

			//Functional API of BR : public Stream<String> lines()
			br.lines() //Stream<String>
			.filter(s -> s.length() > 50)
			.map(String :: toUpperCase) //s -> s.toUpperCase()
			.forEach(System.out::println);
			System.out.println("data read over....");

		} catch (Exception e) {
			e.printStackTrace();
		//	System.out.println(e);
		}
		System.out.println("main over....");

	}

}
