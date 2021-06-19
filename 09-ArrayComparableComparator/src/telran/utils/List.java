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
	int indexOf(T pattern);
	/**
	 * 
	 * @param pattern
	 * @return index of the last occurrence for an object equaled to the pattern
	 * in the case no object equaled to the pattern, returns -1
	 */
	int lastIndexOf(T pattern);
	
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
	boolean removeAll (List<T> patterns);
	
	/**
	 * removes all objects not equaled to the given patterns
	 * @param patterns
	 * @return true if at least one object has been removed
	 */
	boolean retainAll (List<T> patterns);
	
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
	static  <T> T max(List<T> list, Comparator<T> comp) {
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
	static  <T> T max(List<T> list) {
		return max(list, (Comparator<T>)Comparator.naturalOrder());
	}
	static <T> T min(List<T> list, Comparator<T> comp) {
		return max(list, comp.reversed());
	}
	
	@SuppressWarnings("unchecked")
	default void sort() {
			sort((Comparator <T>)Comparator.naturalOrder());
		}
		// TODO sorting in natural order (Comparable defines natural order)
	
	
	default void sort(Comparator<T> comp) {
		for (int i = 0; i < size() - 1; i++) {
			int f = 0;
			for (int j = 0; j < size() - 1 - i; j++) {
				if (comp.compare(get(j),get(j + 1)) > 0) {					
					swap(j, j + 1);
					f = 1;
				}
			}
			if (f == 0)
				break;
		}
		//TODO sorting according to the given comparator
	}
	
	/**
	 * 
	 * @param predicate
	 * @return either index (first object matching predicate) or -1
	 * 
	 */
	int indexOf(Predicate<T> predicate);
	
	/**
	 * 
	 * @param predicate
	 * @return either index (last object matching predicate) or -1
	 * 
	 */
	int lastIndexOf(Predicate<T> predicate);
}
