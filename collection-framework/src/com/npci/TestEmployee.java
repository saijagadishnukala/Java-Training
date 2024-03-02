package com.npci;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.*;
public class TestEmployee extends Employee{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list  = new ArrayList<>();
		//creating an object of employee and adding.
		
		Employee employee1 = new Employee(1,"SAI",2000.00,LocalDate.parse("2001-12-15"));
		list.add(employee1);
		list.add(new Employee(5,"shivam kumar",100.00,LocalDate.parse("2001-12-16")));
		list.add(new Employee(4,"shivam singh",1000.00,LocalDate.parse("2001-12-17")));
		list.add(new Employee(2,"vinod damineni",5000.00,LocalDate.parse("2001-12-18")));
		
		print(list);
		list.remove(2);
		print(list);
		
		//applying sort logic using comparator with lambda expression.
		//we can use the lambda expression with reference and pass it as a parameter.
		Comparator<Employee> compareById = (e1,e2) -> e1.getId()-e2.getId();
		//sorting based on id
		list.sort(compareById);
		print(list);
		
		//sorting by salary
		
		Comparator<Employee> compareBySalary = (e1,e2)->Double.compare(e1.getSalary(), e2.getSalary());
		list.sort(compareBySalary);
		print(list);
		
		//sorting by doj in both ascending order and descending order
		//ascending
		Comparator<Employee> compareByDoj  = (e1,e2)->e1.getDoj().compareTo(e2.getDoj());
		list.sort(compareByDoj);
		print(list);
		
		//descending
		Comparator<Employee> compareByDojDesc = (e1,e2)->e2.getDoj().compareTo(e1.getDoj());
		list.sort(compareByDojDesc);
		print(list);
		
		
		//Set implementation for storing unique elements
		// for complex types you  must override 2 methods of Object class: equals and hashCode
		// hashCode: tells the location of the object
		// equals : compares two objects to identify the duplicates.
		
		Set<Employee> set = new HashSet();
		
		set.add(new Employee(200,"souvik das",2500.00,LocalDate.parse("2024-05-20")));
		set.add(new Employee(200,"souvik das",2500.00,LocalDate.parse("2024-05-20")));
		set.add(new Employee(300,"shivam",2400.00,LocalDate.parse("2024-05-23")));
		set.add(new Employee(300,"shivam das",2600.00,LocalDate.parse("2025-05-20")));
		set.add(new Employee(600,"singh",2500.00,LocalDate.parse("2024-07-26")));
		System.out.println("-------------set elements --------------");
		print(set);
		
	}
	public static void print(Collection<Employee> collection) {
		System.out.println("------------printing employees details--------");
		for(Employee e : collection) {
			System.out.println(e);
		}
	}

}
