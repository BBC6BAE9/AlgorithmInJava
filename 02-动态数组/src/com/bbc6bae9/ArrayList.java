package com.bbc6bae9;

public class ArrayList<E> {

	// 元素的数量
	private int size;

	// 所有的数组
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;

	// 构造函数 - 参数 
	@SuppressWarnings("unchecked")
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
	}

	// 构造函数 - 无参	
	public ArrayList() {
		// 调用有参的构造函数
		this(DEFAULT_CAPACITY);
	}
		
	// 清除数组
	public void clear() {
		//️ ⚠️ 只要是size控制住了，在使用方看来，已经是clear了，销毁空间和申请空间都是耗时的，这种做法才是性能最好的，如果元素是对象，就是还是需要清除内存
		// 元素是对象的时候才需要这么做
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
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
	public void add(E element) {
		add(size, element);
	}
	
	// 在index的位置插入一个元素，需要扩容
	public void add(int index, E element) {

		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
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
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	// 设置index位置的元素 
	public E set(int index, E element) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}

	// 删除index位置的元素
	public void remove(int index) {
		rangeCheck(index);
		// 把index后面的元素都往前移动一个位置，并且size--，最后一个元素可以不处理，因为我们有size控制
		for (int i = index + 1; i < size -1; i++) {
			elements[i - 1] = elements[i];
		}
		elements[size--] = null;
	}
	
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) return i;
		}
		return ELEMENT_NOT_FOUND;
	}
	
	// 数组越界
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + "Size:" + size);
	}

	// 普通的越界校验
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	
	// 插入的越界校验
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
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
	
	// 保证有capacity的容量
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		// 扩容系数的问题：iOS平台系数是1.6，Java官方的是1.5，但是写法需要注意，乘以浮点数性能要差一些，所以用位移，左移动是X2，右移是/2,位运算效率特别高
		int oldCap = elements.length;
		if (oldCap >= capacity) return;
		int newCap = oldCap + (oldCap >> 1); // 按照系数扩容
		E[] newElements = (E[]) new Object[newCap];
		
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		
		elements = newElements;
		System.out.print("扩容\n"); 
	}
}
