import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RangeTest {

	@Test
	void NoPredicateTest() {
		System.out.println("NoPredicateTest");
		Range range = new Range(1, 5);
		for (int num : range) {
			System.out.print(num + ";");
		}
		System.out.print("\n");
	}
	
	@Test
	void Predicate1Test() {
		System.out.println("n -> n % 2 == 0");
		Range range = new Range(1, 5);
		range.setPredicate(n -> n % 2 == 0);
		for (int num : range) {
			System.out.print(num + ";");
		}
		System.out.print("\n");
	}
	
	@Test
	void Predicate2Test() {
		System.out.println("empty predicate");
		Range range = new Range(1, 5);
		range.setPredicate();
		for (int num : range) {
			System.out.print(num + ";");
		}
		System.out.print("\n");
	}
	
	@Test
	void Predicate3Test() {
		System.out.println("n -> n % 2 != 0");
		Range range = new Range(1, 5);
		range.setPredicate(n -> n % 2 != 0);
		for (int num : range) {
			System.out.print(num + ";");
		}
		System.out.print("\n");
	}
}
