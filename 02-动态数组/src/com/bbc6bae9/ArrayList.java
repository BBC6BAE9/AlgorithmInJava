package com.bbc6bae9;

public class ArrayList {

	// 元素的数量
	private int size;

	// 所有的数组
	private int[] elements;
	
	// final相当于其他编程语言的 const
	private static final int DEFAULT_CAPACITY = 10;
	// 元素未找到
	private static final int ELEMENT_NOT_FOUND = -1;

	// 构造函数 - 参数
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = new int[capaticy];
	}

	// 构造函数 - 无参	
	public ArrayList() {
		// 调用有参的构造函数
		this(DEFAULT_CAPACITY);
	}
		
	// 清除数组
	public void clear() {
		//️ ⚠️ 只要是size控制住了，在使用方看来，已经是clear了，销毁空间和申请空间都是耗时的，这种做法才是性能最好的
		size = 0;
	}

	// 数组容量
	public int size() {
		return size;
	}

	// 数组是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	// 在数组末尾添加元素
	public void add(int element) {
		elements[size++] = element;
		// 扩展容量的问题暂时不考虑
	}
	
	// 在index的位置插入一个元素
	public void add(int index, int element) {
		for (int i = size -1; i >= index; i--) {
			elements[i + 1] = elements[i]; 
		}
		elements[index] = element;
		size ++;
	}
		
	// 是否包含某个元素
	public boolean contains(int element) {
		return false;
	}
	
	// 获取index位置的元素
	public int get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + "Size:" + size);
		}
		return elements[index];
	}
	
	// 设置index位置的元素 
	public int set(int index, int element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + "Size:" + size);
		}
		int old = elements[index];
		elements[index] = element;
		return old;
	}

	// 删除index位置的元素
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + "Size:" + size);
		}
		// 把index后面的元素都往前移动一个位置，并且size--，最后一个元素可以不处理，因为我们有size控制
		for (int i = index + 1; i < size -1; i++) {
			elements[i - 1] = elements[i];
			size--;
		}
	}
	
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) return i;
		}
		return ELEMENT_NOT_FOUND;
	}
	
	@Override
	public String toString() {
		// size=3,[99,88,33]
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(",[");
		for (int i = 0; i < size; i++) {
			string.append(elements[i]);
			if (i != size -1) string.append(",");
		}
		string.append("]");
		return string.toString();
	}
}
