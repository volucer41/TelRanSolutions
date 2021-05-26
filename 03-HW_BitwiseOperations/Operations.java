
public class Operations {
/**
 * 
 * @param number - given number
 * @param nBit - given sequential number of bit from 0
 * @return value of nBit in the given number (see tests)
 */
	public static int getBit(int number, int nBit) {
		//int bitValue = 0; //I don't want set bitValue to 0.
		//I think it can return wrong results if somthing goes wrong
		int bitValue;
		bitValue = 1 << nBit;
		bitValue = number & bitValue;
		bitValue = bitValue >> nBit;
		return bitValue;
}
	/**
	 * 
	 * @param number - given number
	 * @param nBit
	 * @return new number (as a particular case it may be the same number)
	 *  with value of the given bit - 1 (see tests)
	 */
	public static int setBit(int number, int nBit) {
		//int numberRes = number; //I don't know why you set numberRes as a number.
		//I want to change that
		//I hope my solution will not be wrong
		int numberRes;
		numberRes = 1 << nBit;
		numberRes = number | numberRes;		
		return numberRes;
	}
	/**
	 * 
	 * @param number - given number
	 * @param nBit
	 * @return new number (as a particular case it may be the same number)
	 *  with value of the given bit - 0 (see tests)
	 */
	public static int resetBit(int number, int nBit) {
		//int numberRes = number; //Same as previous method
		int numberRes;
		numberRes = 1 << nBit;
		numberRes = number & ~numberRes;	
		
		return numberRes;
	}
	

}
