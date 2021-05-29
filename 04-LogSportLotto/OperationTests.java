import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperationTests {

	@Test
	void log2Test() {
		assertEquals(1, Operations.log2(3));
		assertEquals(7, Operations.log2(128));
		assertEquals(8, Operations.log2(256));
		assertEquals(8, Operations.log2(400));
		assertEquals(10, Operations.log2(1024));
		assertEquals(10, Operations.log2(-1024));

	}

	@Test
	void sportLottoTest() {
		SportLotto.displaySportLotto();
	}
}