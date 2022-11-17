package com.aa.act.interview.org;

import java.util.ArrayList;
import java.util.Optional;
import com.aa.act.interview.org.Employee;

public abstract class Organization {

	private Position root;
	private ArrayList<Position> positions = new ArrayList<>();
	private ArrayList<Employee> employees = new ArrayList<>();
	
	public Organization() {
		root = createOrganization();
	}
	
	protected abstract Position createOrganization();
	
	/**
	 * hire the given person as an employee in the position that has that title
	 * 
	 * @param person
	 * @param title
	 * @return the newly filled position or empty if no position has that title
	 */
	public Optional<Position> hire(Name person, String title) {
		Employee newEmployee = new Employee(person, title);
		Position pos = new Position(title);
		String returnedString = pos.getTitle();
		Position result = new Position(returnedString,newEmployee);
		employees.add(newEmployee);
		positions.add(result);
		return Optional.of(result);
	}

	@Override
	public String toString() {
		return printOrganization(root,"");
	}
	
	private String printOrganization(Position pos,String prefix){
		StringBuilder sb = new StringBuilder(pos.toString() + "\n");
		sb.append(printPositions(pos));
		sb.append(printEmployees(employees,sb.toString()));
		return sb.toString();
	}
	private String printPositions(Position position){
		StringBuilder sb = new StringBuilder(position.toString() + "\n");
		for(Position p : position.getDirectReports()){
			sb.append(printPositions(p));
		}
		return sb.toString();
	}
	private String printEmployees(ArrayList<Employee> employee, String currentString){
		StringBuilder sb = new StringBuilder(employee.toString() + "\n");
		return sb.toString();
	}
}
