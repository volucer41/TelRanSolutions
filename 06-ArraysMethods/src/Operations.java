import java.util.Arrays;

public class Operations {
	
	public static int[] addNumber(int ar[], int num) {
		int[] res = Arrays.copyOf(ar, ar.length + 1);
		res[res.length - 1] = num;
		return res;
	}
	
	public static int[] insertNumber(int ar[], int index, int num) {
		//index [0-ar.length]
		//in the case of wrong index the function returns the same reference
		//Using System.arraycopy
		
		if (index < 0  || index > ar.length) {
			return ar;
		}
		int res[] = new int[ar.length + 1];
		System.arraycopy(ar, 0, res, 0, index);
		res[index] = num;
		System.arraycopy(ar, index, res, index + 1, ar.length - index);
		return res;
	}
	
	/*
	 * @param ar - sorted
	 * @param num
	 * @parameter count of num's occurrences in ar
	 */
	public static int binaryCount(int arSorted[], int num) {
		int index = numSearcher (arSorted, num);
		if (arSorted[index] != num) return -1;
		
		int indexOfRight = index;
		int indexOfLeft = index;
		while (arSorted[indexOfRight + 1] == num) {
			indexOfRight++;
		}
		while (arSorted[indexOfLeft - 1] == num) {
			indexOfLeft--;
		}
		return indexOfRight - indexOfLeft + 1;
	}
	
	/*
	 *@numSearcher - to find num o closest digit 
	 */
	private static int numSearcher(int[] arSorted, int num) {
		int index = -1;
		int leftIndex = 0;
		int rightIndex = arSorted.length -1;
		while (leftIndex <= rightIndex) {
			index = (leftIndex + rightIndex) / 2;
			if (arSorted[index] == num) 
				return index;
			else if (arSorted[index] < num) 
				leftIndex = index + 1;
			else 
				rightIndex = index -1;
		}
		return index;		
	}

	/**
	 * 
	 * @param ar sorted array
	 * @param num
	 * @return sorted array with added num
	 */
	public static int[] addNumberSorted(int ar[], int num) {
		int index = numSearcher(ar, num); //from 0 to arSorted.length -1
		int[] res = new int[ar.length +1];
		if (ar[index] > num) {
			System.arraycopy(ar, 0, res, 1, ar.length);
			res[0] = num;
		}
		else if (ar[index] < num) {
			System.arraycopy(ar, 0, res, 0, ar.length);
			res[ar.length] = num;
		}
		else {
			System.arraycopy(ar, 0, res, 0, index);
			res[index] = num;
			System.arraycopy(ar, index, res, index + 1, ar.length - index);
		}
		
		return res;
	}
	
	/**
	 * 
	 * @param ar array
	 * @param index
	 * @return array with no number at the given index
	 */
	public static int[] removeNumber (int ar[], int index) {
		if (index < 0  || index > ar.length) {
			return ar;
		}
		int[] res = new int[ar.length - 1];
		System.arraycopy(ar, 0, res, 0, index);
		if (index < ar.length - 1)
			System.arraycopy(ar, index + 1, res, index, ar.length - index - 1);
		return res;
	}
}
