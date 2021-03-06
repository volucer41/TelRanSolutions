package telran.utils;

import java.util.function.Predicate;

public class DividerNumbersPredicate implements Predicate<Integer> {
	int divider;

	public DividerNumbersPredicate(int divider) {

		this.divider = divider;
	}

	public boolean test(Integer t) {
		return t % divider == 0;
	}
}
