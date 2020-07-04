package com.learning.Microservice2;

public class Employee {

	int empID;
	int salary;
	String name;
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", salary=" + salary + ", name=" + name + "]";
	}
	public Employee(int empID, int salary, String name) {
		super();
		this.empID = empID;
		this.salary = salary;
		this.name = name;
	}
	public Employee() {
		super();
	}
	
	
}
