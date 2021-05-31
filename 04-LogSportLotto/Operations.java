
public class Operations {
	public static int getBit(long number, int nBit) {
		int bitValue = (int) (number >> nBit) & 1;
		return bitValue;
	}

	/**
	 * 
	 * @param n
	 * @return logN - power of 2 to get n (see tests)
	 */
	public static int log2(long n) {
		int log2Result = 0;
		
		if (n == 0) {
			return log2Result;
		}
		
		n = (n < 0) ? (~n + 1) : (n);

		int i = 62;
		while (log2Result == 0) {
			log2Result = getBit(n, i);
			if (log2Result == 1) {
				return i;
			}
			i--;
		}

		return log2Result;
	}

}
