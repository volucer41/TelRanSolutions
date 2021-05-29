
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
		n = (n < 0) ? (~n + 1) : (n);
		for (int i = 62; i != -1; i--) {
			log2Result = getBit(n, i);
			if (log2Result == 1) {
				log2Result = i;
				break;
			}
		}

		return log2Result;
	}

}
