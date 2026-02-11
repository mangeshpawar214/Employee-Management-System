package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Entity.Employee;
import com.Util.JDBCUtil;

public class EmployeeDao {

	Connection con = JDBCUtil.jdbcConnection();

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String saveEmployee(Employee employee) {

		try {
			PreparedStatement pst = con.prepareStatement("Insert into employees values(?,?,?,?,?,?,?,?,?)");

			pst.setInt(1, employee.getId());
			pst.setString(2, employee.getName());
			pst.setInt(3, employee.getAge());
			pst.setString(4, employee.getGender());
			pst.setString(5, employee.getEmail());
			pst.setString(6, employee.getPassword());
			pst.setString(7, employee.getDepartment());
			pst.setDouble(8, employee.getSalary());
			pst.setString(9, employee.getCity());

			pst.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "employee saved Successfully";

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String updateEmployee(Employee employee) {

		try {
			PreparedStatement pst = con.prepareStatement(

					"update employees set name=?,age=?,gender=?,email=?,password=?,department=?,salary=?,city=? where id=?");

			pst.setString(1, employee.getName());
			pst.setInt(2, employee.getAge());
			pst.setString(3, employee.getGender());
			pst.setString(4, employee.getEmail());
			pst.setString(5, employee.getPassword());
			pst.setString(6, employee.getDepartment());
			pst.setDouble(7, employee.getSalary());
			pst.setString(8, employee.getCity());
			pst.setInt(9, employee.getId());

			pst.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "Employee updated Successfully";
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Employee getEmployeeById(int id)

	{
		Employee employee = null;

		try {
			PreparedStatement pst = con.prepareStatement("select * from Employees where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id1 = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String departmet = rs.getString("department");
				double salary = rs.getDouble("salary");
				String city = rs.getString("city");

				employee = new Employee(id1, name, age, gender, email, password, departmet, salary, city);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Employee> getAllEmployee()

	{

		ArrayList<Employee> employees = new ArrayList<Employee>();

		try {
			PreparedStatement pst = con.prepareStatement("select * from employees");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String departmet = rs.getString("department");
				double salary = rs.getDouble("salary");
				String city = rs.getString("city");

				Employee employee = new Employee(id, name, age, gender, email, password, departmet, salary, city);

				employees.add(employee);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return employees;

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String deleteEmployeeById(int id) {

		try {
			PreparedStatement pst = con.prepareStatement("delete from employees where id=?");

			pst.setInt(1, id);

			boolean count = pst.execute();
			if (count == false) {
				return "Employee  is deleted Successfully";
			} else {
				return "employee is not Deleted Due some Error";
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String deleteAllEmployee() {

		try {
			PreparedStatement pst = con.prepareStatement("truncate table employees");

			pst.executeUpdate();

			return "All Employees Are Deleted Successfully";

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

}
