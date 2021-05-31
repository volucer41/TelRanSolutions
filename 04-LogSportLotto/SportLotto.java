
public class SportLotto {
	public static void main(String[] args) {
		displaySportLotto();
	}

	public static int getBit(long number, int nBit) {
		int bitValue = (int) (number >> nBit) & 1;
		return bitValue;
	}

	public static long setBit(long number, int nBit) {
		long numberRes = (number | 1L << nBit);
		return numberRes;
	}

	public static void displaySportLotto() {

		long checker = 0;
		int counter = 0;
		while (counter <  7) {
			int number = (int) (1 + Math.random() * 49);
			if (getBit(checker, number) == 0) {
				checker = setBit(checker, number);
				counter++;
				System.out.println(number);
			}
		}
	}
}
