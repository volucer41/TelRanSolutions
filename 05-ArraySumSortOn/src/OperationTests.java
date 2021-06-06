import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperationTests {

	@Test
	void stupidSortTest() {
		short[] sortedManual = {1, 3, 5, 5, 5, 5, 5, 5, 7, 9, 11};
		short[] unsorted = {11, 1, 5, 5, 3, 5, 5, 5, 5, 9, 7};
		short[] sorted = Operations.stupidSort(unsorted);
		for (int i = 0; i < unsorted.length; i++) {
			assertEquals(sorted[i] , sortedManual[i]);
		}
	}
	
	@Test
	void sumOfTwoTest() {
		short ar[] = {0, 9, 8, 7, 6, 10};
		short sum = 10;
		assertEquals(true, Operations.isSumOfTwo(ar, sum));
	}
	
	private static final int N_NUMBERS = 1_000_000;

	@Test
	void sortTest() {
		short ar[] = getShortArray(N_NUMBERS);
		Operations.sort(ar);
		int lim = N_NUMBERS - 1;
		for (int i = 0; i < lim; i++) {
			assertTrue(ar[i] <= ar[i + 1]);
		}
	}

	private short[] getShortArray(int nNumbers) {
		short[] res = new short[nNumbers];
		for(int i = 0; i < nNumbers; i++) {
			res[i] = (short) (Math.random() * Short.MAX_VALUE);
		}
		return res;
	}
	

}
