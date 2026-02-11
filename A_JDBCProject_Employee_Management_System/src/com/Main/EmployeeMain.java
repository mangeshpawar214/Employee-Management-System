package com.Main;

import java.util.ArrayList;
import java.util.Scanner;

import com.Controller.EmployeeController;
import com.Entity.Employee;

import Exception.EmployeeNotFoundException;

public class EmployeeMain {

	private String username="Mangesh";
	private String password="Mangesh@123";
	public static void main(String[] args) {
		EmployeeMain em = new EmployeeMain();
		
		EmployeeController controller = new EmployeeController();

		Scanner sc = new Scanner(System.in);
		
		int choice;
		while (true) {

			System.out.println("======================= welcome ========================");
			System.out.println("1.Register Employee...");
			System.out.println("2.Update Employee...");
			System.out.println("3.Get EmployeeById...");
			System.out.println("4.get AllEmployees...");
			System.out.println("5.Delete Employee by ID...");
			System.out.println("6.Delete all Employees");
			System.out.println("7.Get Male Employees");
			System.out.println("8.Get Female Employees");
			System.out.println("9.Exit");
			System.out.println("==================================");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
			
			if (choice == 1) {

				System.out.println("Enter Id :");
				int id = sc.nextInt();

				System.out.println("Enter name:");
				String name = sc.next();

				System.out.println("Enter age:");
				int age = sc.nextInt();

				System.out.println("Enter gender:");
				String gender = sc.next();

				System.out.println("Enter email:");
				String email = sc.next();

				System.out.println("Enter passsword:");
				String password = sc.next();

				System.out.println("Enter department:");
				String department = sc.next();

				System.out.println("Enter salary:");
				double salary = sc.nextDouble();

				System.out.println("Enter City");
				String city = sc.next();

				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setAge(age);
				e.setGender(gender);
				e.setEmail(email);
				e.setPassword(password);
				e.setDepartment(department);
				e.setSalary(salary);
				e.setCity(city);

				String msg = controller.saveEmployee(e);
				System.out.println(msg);
				System.out.println("=======================================");
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			else if (choice == 2) {
				System.out.println("Enter Id :");
				int id = sc.nextInt();

				System.out.println("Enter name:");
				String name = sc.next();

				System.out.println("Enter age:");
				int age = sc.nextInt();

				System.out.println("Enter gender:");
				String gender = sc.next();

				System.out.println("Enter email:");
				String email = sc.next();

				System.out.println("Enter passsword:");
				String password = sc.next();

				System.out.println("Enter department:");
				String department = sc.next();

				System.out.println("Enter salary:");
				double salary = sc.nextDouble();

				System.out.println("Enter City");
				String city = sc.next();

				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setAge(age);
				e.setGender(gender);
				e.setEmail(email);
				e.setPassword(password);
				e.setDepartment(department);
				e.setSalary(salary);
				e.setCity(city);

				String msg = controller.updateEmployee(e);
				System.out.println(msg);
				System.out.println("=================================");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			} else if (choice == 3) {

				System.out.println("Enter Id to get Employee");
				int id = sc.nextInt();
				try {
					Employee employee = controller.getById(id);

					System.out.println("Id			:" + employee.getId());
					System.out.println("Name		:" + employee.getName());
					System.out.println("Age			:" + employee.getAge());
					System.out.println("Gnender		:" + employee.getGender());
					System.out.println("Email		:" + employee.getEmail());
					System.out.println("Password	:" + employee.getPassword());
					System.out.println("Department	:" + employee.getDepartment());
					System.out.println("Salary		:" + employee.getSalary());
					System.out.println("City		:" + employee.getCity());

					System.out.println("=================================");
				} catch (EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			} else if (choice == 4) {

				ArrayList<Employee> employees = controller.getAllEmployee();

				for (Employee employee : employees) {
					System.out.println("Id			:" + employee.getId());
					System.out.println("Name		:" + employee.getName());
					System.out.println("Age			:" + employee.getAge());
					System.out.println("Gnender		:" + employee.getGender());
					System.out.println("Email		:" + employee.getEmail());
					System.out.println("Password	:" + employee.getPassword());
					System.out.println("Department	:" + employee.getDepartment());
					System.out.println("Salary		:" + employee.getSalary());
					System.out.println("City		:" + employee.getCity());

					System.out.println("=================================");
				}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			} else if (choice == 5) {

				System.out.println("Enter id to delete Employee:");
				int id = sc.nextInt();
				try {
					String msg = controller.deleteEmployeeById(id);
					System.out.println(msg);
				} catch (EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}

			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			else if(choice==6) {
				
				System.out.println("Enter the Following details to perform This Operations.");
				System.out.println("----------------------------------------------------");
				System.out.println("Enter Username:");
				String username=sc.next();
				System.out.println("Enter Password");
				String password= sc.next();
				if(username.equals(em.username)&&password.equals(em.password))
				{
				String msg= controller.deleteAllEmployee();
				System.out.println(msg);
				
				}else {
					System.out.println("You  are not Able to perform this operation....");
					System.out.println("----------------------------------------------------");
				}
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			else if(choice==7)
			{
				 ArrayList<Employee> employees =controller.getMaleEmployeesOnly();
				
				for( Employee employee:employees)
				{
					
						System.out.println("Id			:" + employee.getId());
						System.out.println("Name		:" + employee.getName());
						System.out.println("Age			:" + employee.getAge());
						System.out.println("Gnender		:" + employee.getGender());
						System.out.println("Email		:" + employee.getEmail());
						System.out.println("Password	:" + employee.getPassword());
						System.out.println("Department	:" + employee.getDepartment());
						System.out.println("Salary		:" + employee.getSalary());
						System.out.println("City		:" + employee.getCity());

						System.out.println("=================================");
					
				}
				
				
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			else if(choice==8)
			{
				ArrayList<Employee> employees =controller.getFemaleEmployeesOnly();
				
				for(Employee employee:employees)
				{
					System.out.println("Id			:" + employee.getId());
					System.out.println("Name		:" + employee.getName());
					System.out.println("Age			:" + employee.getAge());
					System.out.println("Gnender		:" + employee.getGender());
					System.out.println("Email		:" + employee.getEmail());
					System.out.println("Password	:" + employee.getPassword());
					System.out.println("Department	:" + employee.getDepartment());
					System.out.println("Salary		:" + employee.getSalary());
					System.out.println("City		:" + employee.getCity());

					System.out.println("=================================");
				
				}
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			
			else if (choice == 9)

			{
				System.out.println("thank you");
				System.out.println("==================================");
				break;

			} else {
				System.out.println("Enter Valid choice..");
			}
		}

		sc.close();
	}
}
