import java.util.function.Predicate;
import java.util.Iterator;
import java.util.LinkedList;

public class Range implements RangeIteratorInterface, java.lang.Iterable<Integer> {
	
	int min, max;
	private LinkedList<Integer> range = new LinkedList<Integer>();
	
	public Range(int min, int max){
		this.min = min;
		this.max = max;
		int capacity = max - min + 1;
		for (int i = 0; i < capacity; i++) {
			range.add(min++);
		}
	}
	
	public Iterator<Integer> iterator() {
		return new RangeIterator();
	}
	
	private class RangeIterator implements Iterator<Integer>{
		int currentIndex = 0;
		@Override
		public boolean hasNext() {
			return currentIndex < range.size() ? true : false;
		}

		@Override
		public Integer next() {
			return range.get(currentIndex++);
		}

		@Override
		public void remove() {
			range.remove(currentIndex - 1);
		}

	}

	@Override
	public void setPredicate(Predicate<Integer> predicate) {
		Iterator<Integer> it = iterator();
		while (it.hasNext()) {
			if (!predicate.test(it.next())) {
					it.remove();
			}
		}
	}
	
	public void print() {
		for (int i = 0; i < range.size(); i++) {
			System.out.println(range.get(i));
		}
	}
	

}
