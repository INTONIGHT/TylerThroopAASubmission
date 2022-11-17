package com.aa.act.interview.org;

public class Employee {

	private int identifier;
	private Name name;
	private String title;

	public Employee(int identifier, Name name) {
		if(name == null)
			throw new IllegalArgumentException("name cannot be null");
		this.identifier = identifier;
		this.name = name;
	}
	public Employee(Name name, String title){
		if(name == null){
			throw new IllegalArgumentException("name cannot be null");
		}
		if(title == null){
			throw new IllegalArgumentException("Title cant be null");
		}
		this.title = title;
		this.name = name;
	}
	public int getIdentifier() {
		return identifier;
	}
	
	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return name.toString() + ": " + title;
	}
}
