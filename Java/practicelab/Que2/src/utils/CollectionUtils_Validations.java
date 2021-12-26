package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.EmpService.Department;
import com.app.EmpService.Employee;

import custom_exception.EmployeeHandlingException;

public interface CollectionUtils_Validations {
	
	public static List<Employee> populateList(){
	List<Employee> list= new ArrayList<>();
	//int id, String name, LocalDate hireDate, double salary, Department department
	
	list.add(new Employee(1234,"Kamal",LocalDate.parse("1978-11-01"),LocalDate.parse("1998-12-01"),40000,Department.HR));
	list.add(new Employee(4589,"Manish", LocalDate.parse("1979-10-15"),LocalDate.parse("1996-10-11"),65000,Department.FINANCE));
	list.add(new Employee(2589,"Avnish", LocalDate.parse("1965-07-01"),LocalDate.parse("1994-05-05"),75000,Department.MARKETING));
	list.add(new Employee(3654,"Mohan", LocalDate.parse("1981-12-27"),LocalDate.parse("1999-12-01"),55000,Department.OPERATIONS));
	list.add(new Employee(7896,"Sam", LocalDate.parse("1976-02-05"),LocalDate.parse("1992-01-10"),45000,Department.PURCHASING));
	list.add(new Employee(2546,"Rohan", LocalDate.parse("1972-01-10"),LocalDate.parse("2000-09-08"),40000,Department.RESEARCH));
	list.add(new Employee(9635,"Akash", LocalDate.parse("1967-03-30"),LocalDate.parse("2000-09-08"),30000,Department.HR));
	list.add(new Employee(1389,"Kunal", LocalDate.parse("1961-09-07"),LocalDate.parse("1998-12-01"),50000,Department.OPERATIONS));
	
	return list;
	
	}
	
	public static void checkForDuplicates(int id, List<Employee> employees) throws EmployeeHandlingException
	{
		Employee e1 = new Employee(id);
		
		if(employees.contains(e1)) throw new EmployeeHandlingException("Duplicate employee entry is not allowed!!")	;
	}
	
	public static Department validateDepartment(String dept) throws EmployeeHandlingException
	{
		Department d1;
		try {
			d1 = Department.valueOf(dept.toUpperCase());
			return d1;		
		}catch(IllegalArgumentException e) {
			throw new EmployeeHandlingException("Department does not exists!! Choose from :" + Arrays.toString(Department.values()));
		}
	}
	
	public static Employee validateAll(int id, String name, LocalDate dob,LocalDate hireDate, double salary, String department,List<Employee> employees) throws EmployeeHandlingException
	{
		checkForDuplicates(id, employees);
		Department d1 = validateDepartment(department);
		return new Employee(id,name,dob,hireDate,salary,d1);
	}
	
	

}
