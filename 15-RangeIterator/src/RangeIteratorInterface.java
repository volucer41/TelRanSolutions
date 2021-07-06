import java.util.function.Predicate;


public interface RangeIteratorInterface {
	/*
	 * Sets predicate for iterating
	 */
	void setPredicate(Predicate<Integer> predicate);
	
	default void setPredicate() {
		setPredicate(n -> true);
	}
	
}
