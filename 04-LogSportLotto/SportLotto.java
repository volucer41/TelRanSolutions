
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

		long counter = 0;
		while (counter < Math.pow(2, 50) * 7) {
			int number = (int) (1 + Math.random() * 49);
			if (getBit(counter, number) == 0) {
				counter = setBit(counter, number);
				counter += Math.pow(2, 50);
				System.out.println(number);
			}
		}
	}
}
