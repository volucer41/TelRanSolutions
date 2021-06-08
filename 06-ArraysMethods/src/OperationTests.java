import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class OperationTests {
	private static final int N_NUMBERS = 1_000_000;
	@Test
	void binaryCountTest() {
		assertEquals(20, Operations.binaryCount(createSortArray(N_NUMBERS, 20), 10));
	}
	
	@Test
	void addNumberSortedTest() {
		int[] ar = createSortArray(N_NUMBERS, 400);
		int[] resNumber = Operations.addNumberSorted(ar, 150);
		int[] resMin = Operations.addNumberSorted(ar, 0);
		int[] resMax = Operations.addNumberSorted(ar, 2499);
		int[] resBigger = Operations.addNumberSorted(ar, 1_000_000);
		int[] resSmaller = Operations.addNumberSorted(ar, -1_000_000);
		int lim = N_NUMBERS;
		for (int i = 0; i < lim; i++) {
			assertTrue(resNumber[i] <= resNumber[i + 1]);
			assertTrue(resMin[i] <= resMin[i + 1]);
			assertTrue(resMax[i] <= resMax[i + 1]);
			assertTrue(resBigger[i] <= resBigger[i + 1]);
			assertTrue(resSmaller[i] <= resSmaller[i + 1]);
		}
		assertEquals(1_000_000, resBigger[resBigger.length - 1]);
		assertEquals(-1_000_000, resSmaller[0]);
		
		
	}
	
	@Test
	void removeNumber() {
		int[] ar = createSortArray(N_NUMBERS, 1);
		assertEquals(1, (Operations.removeNumber(ar, 0))[0]);
		assertEquals(999_998, (Operations.removeNumber(ar, N_NUMBERS - 1))[ar.length - 2]);
		assertEquals(32, (Operations.removeNumber(ar, 31))[31]);
	}
	
	
	private static int[] createSortArray(int n_Numbers, int div){
		int[] sortedArray = new int[n_Numbers];
		for (int i = 0; i < n_Numbers; i++) {
			sortedArray[i] = i / div;
		}
		return sortedArray;
	}
	
	@Test
	void binarySearchTest() {
		int div = 10;
		int[] ar = createSortArray(N_NUMBERS, div);
		assertEquals(10, ar[Arrays.binarySearch(ar, 10)]);
		assertEquals(100, Arrays.binarySearch(ar, 10));
		
	}
}
