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
		if (index < 0 || index > size) {
			return false;
		}
		if (size >= array.length) {
			allocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
		return true;
	}

	@Override
	public T get(int index) {
		T res = null;
		if (index >= 0 && index < size) {
			res = array[index];
		}
		return res;
	}

	@Override
	public boolean remove(int index) {
		boolean res = false;
		if (index >= 0 && index < size) {
			size--;
			System.arraycopy(array, index + 1, array, index, size - index);
			array[size] = null;
			res = true;
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
		while (index < size && !array[index].equals(pattern)) {
			index++;
		}
		return index < size ? index : -1;
	}

	@Override
	public int lastIndexOf(T pattern) {
		int index = size - 1;
		while (index >= 0 && !array[index].equals(pattern)) {
			index--;
		}
		return index;
	}

	@Override
	public boolean remove(T pattern) {
		int index = indexOf(pattern);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	@Override
	public void addAll(List<T> objects) {
		int objectsSize = objects.size();
		for (int i = 0; i < objectsSize; i++) {
			add(objects.get(i));
		}

	}

	@Override
	public boolean removeAll(List<T> patterns) {
		boolean isRemoved = false;
		int i = 0;
		while (i < size) {
			if (patterns.indexOf(get(i)) != -1)
				isRemoved = remove(get(i));
			else
				i++;
		}
		return isRemoved;
	}

	@Override
	public boolean retainAll(List<T> patterns) {
		boolean isRemoved = false;
		int i = 0;
		while (i < size) {
			if (patterns.indexOf(get(i)) == -1)
				isRemoved = remove(get(i));
			else
				i++;
		}
		return isRemoved;
	}

	@Override
	public T set(T object, int index) {
		if (index < 0 || index > size - 1)
			return null;
		var oldValue = array[index];
		array[index] = object;
		return oldValue;
	}

	@Override
	public boolean swap(int index1, int index2) {
		if (index1 < 0 || index1 > size - 1)
			return false;
		if (index2 < 0 || index2 > size - 1)
			return false;
		var swap = array[index1];
		array[index1] = array[index2];
		array[index2] = swap;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayList other = (ArrayList) obj;
		if (size != other.size)
			return false;
		return true;
	}
	
	default void sort() {
		//TODO sort by natural order
		
	}
	
	default void sort(Comparator<T> comp) {
		//TODO sorting according to the given comparator
		
	}

}
