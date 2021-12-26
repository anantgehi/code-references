package Tester;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.EmpService.Employee;

import custom_exception.EmployeeHandlingException;

import static utils.CollectionUtils_Validations.*;

public class EmpServiceApp {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			List<Employee> employees = populateList();
			boolean exit= false;
			while(!exit) {
				try {
					
					System.out.println("");
					System.out.println("***************************************************");
					System.out.println("Choose an Option: ");
					System.out.println("1) Add Employee");
					System.out.println("2) View Employee");
					System.out.println("3) Display all the employees in ascending order with respect to date of joining");
					System.out.println("4) Delete Employee records");
					System.out.println("20) Exit");
					System.out.println("***************************************************");
					
					switch (sc.nextInt()) {
					case 1:
						/* Add Employee */
						
						System.out.println("Enter Employee details: ID, FirstName, Date Of Birth(yyyy-mm-dd), HireDate(yyyy-mm-dd), Salary , Department Name ");
						Employee e1=validateAll(sc.nextInt(), sc.next(), LocalDate.parse(sc.next()), LocalDate.parse(sc.next()), sc.nextDouble(), sc.next(), employees);
						employees.add(e1);
						System.out.println("Employee Details added successfully!!");
						break;
						
					case 2:
						/* View Employee */
						System.out.println("Enter employee ID:");
						e1= new Employee(sc.nextInt());
						int index= employees.indexOf(e1);
						if(index==-1) throw new EmployeeHandlingException("Employee record not found. Try Again!!");
						System.out.println(employees.get(index));
						break;
						
					case 3:
						
						employees.stream().sorted(Comparator.comparing(Employee::getHireDate)).forEach(System.out::println);

						break;
						
					case 4:
						
						/* Delete Employee records */
						
						System.out.println("Enter employee ID:");
						e1= new Employee(sc.nextInt());
						index= employees.indexOf(e1);
						if(index==-1) throw new EmployeeHandlingException("Employee record not found. Try Again!!");
						employees.remove(index);
						System.out.println("Employee details deleted successfully!!");
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
