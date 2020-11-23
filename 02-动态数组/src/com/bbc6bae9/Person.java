package com.bbc6bae9;

public class Person {

	private int age;
	private String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	// java里面提供的重写方法
	@Override
	public boolean equals(Object obj) {

		Person person = (Person) obj;
		return this.age == person.name;
	}
}
 