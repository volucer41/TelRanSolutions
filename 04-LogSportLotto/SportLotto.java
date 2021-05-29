
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
		while (counter < 7881299347898368L) {
			// 7881299347898368L is a same as Math.pow(2 ,50) * 7
			int number = (int) (1 + Math.random() * 49);
			if (getBit(counter, number) == 0) {
				counter = setBit(counter, number);
				counter += 1125899906842624L;
				// 1125899906842624L is a same as Math.pow(2 ,50)
				System.out.println(number);
			}
		}
	}
}
