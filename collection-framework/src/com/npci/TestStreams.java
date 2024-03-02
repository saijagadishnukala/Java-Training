package com.npci;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class TestStreams extends Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = List.of(
				new Employee(500,"Charles",5000.00,LocalDate.parse("1999-12-29")),
				new Employee(1600,"sai",6000.00,LocalDate.parse("2003-12-29")),
				new Employee(700,"manoj",8000.00,LocalDate.parse("2000-12-29")),
				new Employee(800,"kiram",9000.00,LocalDate.parse("2000-12-29")),
				new Employee(900,"sajna",2000.00,LocalDate.parse("2000-12-29")),
				new Employee(1000,"badshah",1000.00,LocalDate.parse("2000-12-29")),
				new Employee(1100,"sumit",300.00,LocalDate.parse("2003-12-29")),
				new Employee(1200,"amit",4000.00,LocalDate.parse("2000-12-29"))
	);
	//streams make data processing efficient because it works in-memory without changing the existing
	//data structure, most of the stream methods take functional interface - lambda
	//filter(Predicate): Predicate has a method: boolean test(T t) : x ->x>20
	//forEach(Consumer): It is to iterate elements: Consumer has method: void accept(T t)
	//forEach(x->System.out.println(x)
	System.out.println("-----------printing salary greater than 400");
	employees.stream().filter(x -> x.getSalary()>400).forEach(x->System.out.println(x));
	//above stream has not modified any existing datastructure
	employees.stream().filter(x -> x.getSalary()>400).forEach(x->System.out.println(x));
	
	//copying all the elements from one datastructure to another: collect(Collectors.toSet()) method is used.
	//collect(Collectors.toList())
	
	System.out.println("--------------copying the list to set--------------");
	Set<Employee> employeeSet = employees.stream().collect(Collectors.toSet());
	//printing the set using foreach loop
	employeeSet.forEach(x->System.out.println(x));
	
	
	
	//applying multiple filters : filter().filter().filter()
	//apply multiple filter: that give employees having salary >400 and doj>2000
	
	System.out.println("------------------multiple filters------------------");
	employees.stream().filter(x->x.getSalary()>400).filter(y->y.getDoj().getYear()>1999).forEach(x->System.out.println(x));
	
	//sorted method usage
	System.out.println("-------------------sorted method usecase");
	employees.stream().sorted((e1,e2) -> e1.getId()-e2.getId()).forEach(x-> System.out.println(x));

	//applying map  to transform
	//getting only name of the employees in a seperate list
	System.out.println("-------------------map usecase");
	List<String> names = employees.stream().map(x->x.getName()).collect(Collectors.toList());
	names.forEach(y->System.out.println(y));
	
	//increased salary
	
	System.out.println("============transform employee to double with some increase in salary===========");
	
	List<Double> increasedSalary = employees.stream().map(x->x.getSalary()*1.1).collect(Collectors.toList());
	increasedSalary.forEach(x->System.out.println(x));
	
	//increasing salary by 10%
	System.out.println("------------------Increasing salary by 10%-----------------");
	
	List<Employee> increasedSalary10 = employees.stream().map(x->new Employee(x.getId(),x.getName(),x.getSalary()*1.1,x.getDoj())).collect(Collectors.toList());
	increasedSalary10.forEach(x->System.out.println(x));
	
	System.out.println("------------------sorting using comparable--------------");
	employees.stream().sorted().forEach(x->System.out.println(x));	
	}
}
