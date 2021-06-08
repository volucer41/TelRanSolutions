
public class Operations {
	
	static final short MAX_SHORT = (1 << 15) -1;
	
	public static short[] stupidSort(short ar[]) {
		int position = 0;
		while (position != ar.length - 1) {
			if (ar[position] > ar[position + 1]) {
				ar = swap(ar, position, position + 1);
				position = position > 0 ? --position : position++;
			}
			else position++;
		}
		// В массиве положительные целые числа
		// Отсортировать массив
		// Использовать два прохода
		return ar;
	}
	
	private static short[] swap(short ar[], int firstIndex, int secondIndex) {
		int swap = 0;
		swap = ar[firstIndex];
		ar[firstIndex] = ar[secondIndex];
		ar[secondIndex] = (short)swap;		
		return ar;
	}
	
	public static void sort(short ar[]) {
		short counters[] = new short[MAX_SHORT];
		fillCounters(counters, ar);
		fillSortedArray(counters, ar);
	}
	
	private static void fillCounters(short counters[], short[] ar) {
		int index = 0;
		for (int i = 0; i < ar.length; i++) {
			index = ar[i];
			counters[index]++;					
		}
		
	}

	private static void fillSortedArray(short counters[], short ar[]) {
		int index = 0;
		for (int i = 0; i < counters.length && index < ar.length; i++) {
			for (int j = 0; j < counters[i]; j++) {
				ar[index] = (short) i;
				index++;
			}
		}
		
	}

	public static boolean isSumOfTwo(short ar[], short sum) {
		// В массиве положительные целые числа
		// Вернуть истину, если в массиве есть 2 числа, сумма которых равна sum
		// Выполнить за 1 проход
		boolean[] counter = new boolean[(sum == MAX_SHORT) ? (sum) : (sum + 1)];
		short firstElement = 0;
		short secondElement = 0;
		boolean isSumOfTwo = false;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] <= sum) {
				firstElement = ar[i];
				secondElement = (short) (sum - firstElement);
				if (counter[secondElement]) {
					isSumOfTwo = true;
					break;
				}
				else {
					counter[firstElement] = true;
				}
				
			}
		}
		return isSumOfTwo;
	}
}
