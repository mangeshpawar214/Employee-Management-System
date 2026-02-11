package com.Service;

import java.util.ArrayList;

import com.Dao.EmployeeDao;
import com.Entity.Employee;

import Exception.EmployeeNotFoundException;

public class EmployeeService {

	EmployeeDao dao = new EmployeeDao();

	public String saveEmployee(Employee employee) {
		String msg = dao.saveEmployee(employee);
		return msg;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String updateEmployee(Employee employee) {
		String msg = dao.updateEmployee(employee);
		return msg;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Employee getById(int id) {
		Employee employee = dao.getEmployeeById(id);
		if (employee == null) {

			throw new EmployeeNotFoundException("Employee not found with id : " + id);
		}
		return employee;

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Employee> getAllemployee() {
		ArrayList<Employee> employees = dao.getAllEmployee();
		
		if (employees.isEmpty())
		{
			System.out.println("No Any Employee Found...");
		}
		return employees;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Employee> getMaleEmployeesOnly() {
		ArrayList<Employee> employees = dao.getAllEmployee();

		ArrayList<Employee> maleemployees = new ArrayList<Employee>();

		for (Employee e : employees) {

			if (e.getGender().equals("Male")) {
				maleemployees.add(e);

			}

		}
		return maleemployees;

	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public ArrayList<Employee> getFemaleEmployeesOnly()
	{
		ArrayList<Employee> employees = dao.getAllEmployee();
		
		ArrayList<Employee>femaleemployees = new ArrayList<Employee>();
		
		for( Employee e:employees)
		{
			if(e.getGender().equals("Female")) 
			{
				femaleemployees.add(e);
				
			}
			
		}
		return femaleemployees;
		
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String deleteEmployeeById(int id) {
		String msg = dao.deleteEmployeeById(id);
		if (msg == null) {
			throw new EmployeeNotFoundException("Employee not found with id :" + id);

		}
		return msg;

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String deleteAllEmployees()
	{
		String msg =dao.deleteAllEmployee();
		return msg;
	}
}
