package telran.utils;

import java.util.Comparator;
import java.util.function.Predicate;

public interface List<T> {
/**
 * 
 * @return number of elements
 */
	int size();
	/**
	 * adding obj at the end
	 * 
	 * @param obj
	 */
	void add(T obj);

	/**
	 * 
	 * @param obj
	 * @param index [0, size]
	 * @return true if added, otherwise false (wrong index)
	 */
	boolean add(T obj, int index);

	/**
	 * 
	 * @param index [0, size -1]
	 * @return reference to T object; if a given index is wrong -> null
	 */
	T get(int index);

	/**
	 * removes object at a given index
	 * @param index [0, size - 1]
	 * @return true if removed, otherwise false (wrong index)
	 */
	boolean remove(int index);
	/**
	 * 
	 * @param pattern
	 * @return index of first occurrence for an object equaled to the pattern
	 * in the case no object equaled to the pattern returns -1
	 */
	default int indexOf(T pattern) {
		Predicate<T> isEqual = value -> value.equals(pattern);
		return indexOf(isEqual);
	}
	/**
	 * 
	 * @param pattern
	 * @return index of the last occurrence for an object equaled to the pattern
	 * in the case no object equaled to the pattern, returns -1
	 */
	default int lastIndexOf(T pattern) {
		Predicate<T> isEqual = value -> value.equals(pattern);
		return lastIndexOf(isEqual);
	}
	
	/**
	 * removes first occurred object equaled to a given pattern
	 * @param pattern
	 * @return true if removed otherwise false
	 * (here there is some challenge, try to understand it)
	 */
	boolean remove(T pattern);
	
	/** 
	 * adds all objects 
	 * @param objects
	 */
	void addAll(List<T> objects);
	
	/**
	 * removes all objects equaled to the given patterns
	 * @param patterns
	 * @return true if at least one object has been removed
	 */
	default boolean removeAll (List<T> patterns) {
		boolean res = false;
		boolean isRetain = false;
		res = remove(patterns, isRetain);
		return res;
	}
	
	private boolean remove(List<T> patterns, boolean isRetain) {
		boolean res = false;
		if (getList().equals(patterns)) {
			if (!isRetain)
				clean();
			res = true;
		}
		for (int i = 0; i < patterns.size(); i++) {
			final T pattern = patterns.get(i);
			if (isRetain) {
				Predicate<T> isEqual = value -> !pattern.equals(value);
				res = removeIf(isEqual);
			}
			else {
				Predicate<T> isEqual = value -> pattern.equals(value);
				res = removeIf(isEqual);
			}
		}
		return res;
	}
	
	/**
	 * removes all objects not equaled to the given patterns
	 * @param patterns
	 * @return true if at least one object has been removed
	 */
	default boolean retainAll (List<T> patterns) {
		boolean res = false;
		boolean isRetain = true;
		res = remove(patterns, isRetain);
		return res;
	}
	
	/**
	 * sets new reference to an object at existing index
	 * @param object
	 * @param index
	 * @return reference to an old object at the index or null in the case of wrong index
	 */
	T set(T object, int index);
	
	/**
	 * swaps objects at the given indexes
	 * @param index1
	 * @param index2
	 * @return return true if swapped, false in the case of any wrong index
	 */
	boolean swap(int index1, int index2);
	default boolean contains(T pattern) {
		return indexOf(pattern) >= 0;
	}
	static <T> T max(List<T> list, Comparator<T> comp) {
		T max = list.get(0);
		int size = list.size();
		for (int i = 1; i < size; i++) {
			T current = list.get(i);
			if (comp.compare(max, current) < 0) {
				max = current;
			}
		}
		return max;
	}
	@SuppressWarnings("unchecked")
	static <T> T max(List<T> list) {
		return max(list, (Comparator<T>)Comparator.naturalOrder());
	}
	static <T> T min(List<T> list, Comparator<T> comp) {
		return max(list, comp.reversed());
	}
	@SuppressWarnings("unchecked")
	static <T> T min(List<T> list) {
		return min(list, (Comparator<T>)Comparator.naturalOrder());
	}
	@SuppressWarnings("unchecked")
	default void sort() {
		sort((Comparator<T>)Comparator.naturalOrder());
	}
	default void sort(Comparator<T> comp) {
		int size = size();
		boolean isSorted = true;
		do {
			size--;
			isSorted = true;
			for(int i = 0; i < size; i++) {
				if (comp.compare(get(i), get(i + 1)) > 0) {
					isSorted = false;
					swap(i, i + 1);
				}
			}
		}while(!isSorted);
	}
	/**
	 * 
	 * @param predicate
	 * @return either index (first object matching predicate) or -1 
	 */
	int indexOf(Predicate<T> predicate);
	
	/**
	 * 
	 * @param predicate
	 * @return either index (last object matching predicate) or -1 
	 */
	int lastIndexOf(Predicate<T> predicate);
	/**
	 * removing all objects matching a given predicate
	 * @param predicate
	 * @return true if at least one object has been removed
	 */
	boolean removeIf(Predicate<T> predicate);
	
	/**
	 * for several equaled objects to leave only one and remove others 
	 * @return true if at least one object has been removed
	 */
	default boolean removeRepeated() {
		boolean res = false;
		for (int i = 0; i < size(); i++) {
			if (count(get(i)) > 0) {
				final T pattern = get(i);
				final int index = i;
				Predicate<T> removeRepeated = value -> {
					return value.equals(pattern) && indexOf(pattern) != index;
				};
				res = removeIf(removeRepeated);
			}
		}
		//return removeIf(predicate);
		return res;
	}
	
	/*
	 * return counts of pattern
	 * if pattern not exist, return -1
	 */
	default int count(T pattern) {
		int counter;
		Predicate<T> isEqual = value -> pattern.equals(value);
		counter = count(isEqual);
		return counter;
	}
	
	public int count(Predicate<T> predicate);
	
	/**
	 * remove all elements from list
	 */
	void clean() ;
	
	/*
	 * return exist List
	 */
	List<T> getList();
	
	
}
