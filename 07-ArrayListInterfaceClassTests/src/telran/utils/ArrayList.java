package telran.utils;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ArrayList<T> implements List<T> {
private static final int DEFAULT_CAPACITY = 16;
private T array[];
int size = 0;

public ArrayList(int capacity) {
	array = (T[]) new Object[capacity];
}
public ArrayList() {
	this(DEFAULT_CAPACITY);
}
	@Override
	public void add(T obj) {
		if (size >= array.length) {
			allocate();
		} 
		array[size++] = obj;
		
	}

	private void allocate() {
		array = Arrays.copyOf(array, array.length * 2);
		
	}
	@Override
	public boolean add(T obj, int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size) {
			return false;
		}
		if (size >= array.length)
			allocate();
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
		return true;
	}

	@Override
	public T get(int index) {
		T res = null;
		if (index < 0 || index > size) {
			return res;
		}
		res = array[index];
		return res;
	}

	@Override
	public boolean remove(int index) {
		boolean res = false;
		if (index < size && index >= 0) {
			size--;
			System.arraycopy(array, index + 1, array, index, size - index);
			//Potential memory leak, to avoid move null to array[size] it is
			//the last element of array before remove
			array[size] = null;
		}
		return res;
	}
	@Override
	public int size() {
		
		return size;
	}
	@Override
	public int indexOf(T pattern) {
		int index = 0;
		//code bellow will be check links to the objects
		//as a result, result never be equals
		//To avoid work with links, need to use .equals method
		//.equals method will be check value, but not link
		//NOTE test will be work from -128:127 - this objects precreated by JVM and have a same links
		//while(index < size && array[index] != pattern) {
		while(index < size && !array[index].equals(pattern)) {
			index++;
		}
		return index < size ? index : -1;
	}

}
