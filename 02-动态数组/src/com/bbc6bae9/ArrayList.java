package com.bbc6bae9;

public class ArrayList {

	// 元素的数量
	private int size;

	// 所有的数组
	private int[] elements;
	
	// final相当于其他编程语言的const
	private static final int DEFAULT_CAPACITY = 10;
	
	// 构造函数 - 参数
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = new int[capaticy];
	}
	
	public ArrayList() {
		// 调用有参的构造函数
		this(DEFAULT_CAPACITY);
	}
	
	// 构造函数 - 无参
	
	// 清除数组
	public void clear() {
		
	}

	// 数组容量
	public int size() {
		return 0;
	}

	// 数组是否为空
	public boolean isEmpty() {
		return false;
	}
	
	// 是否包含某个元素
	public boolean contains(int element) {
		return false;
	}
	
	// 获取index位置的元素
	public int get(int index) {
		return 0;
	}
	
	// 设置index位置的元素
	public int set(int index) {
		return 0;
	}

	// 删除index位置的元素
	public int remove(int index) {
		return -1;
	}
}
