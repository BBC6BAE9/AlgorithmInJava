package com.bbc6bae9;

/*
 数组是一种顺序存储的线性表，所有元素的内存地址是连续的 
 在很多编程语言中，数组有一个致命的缺点，无法动态修改容量
 解决方案：自己写一个动态数组
 */
public class Main {
	public static void main(String[] args) {
		int array[] = new int[] {11, 22, 33};
		
		ArrayList<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person(10,"Jack"));
		persons.add(new Person(10,"Rose"));
		persons.add(new Person(10,"Philip"));
		
		// 提醒JVM进行垃圾回收,Java虚拟机当在内存不够用的时候，会检查有哪些可以回收的内存
		System.gc();
		System.out.println(persons);
				
	}
	
}
