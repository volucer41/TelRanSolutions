package telran.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {
List<Integer> listInt;
List<String> listString;
	@BeforeEach
	void setUp() throws Exception {
		listInt =  new ArrayList<>(1);
		listString = new ArrayList<>();
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		listInt.add(5);
		
	}
	

	@Test
	void addByIndexTest() {
		
		assertEquals(true, listInt.add(5, 20));
		assertEquals(false, listInt.add(5, -20));
		//assertEquals(//true, null);
	}
	
	@Test
	void getByIndexTest() {
		listInt.add(10, 50);
		assertEquals(1, listInt.get(0));
		assertEquals(10, listInt.get(50));
		assertEquals(null, listInt.get(-1));
		assertEquals(1, listInt.get(0));
		assertEquals(5, listInt.get(4));
		assertEquals(null, listInt.get(51));
	}
	
	@Test
	void removeByIndexTest() {
		assertEquals(true, listInt.remove(0));
		assertEquals(2, listInt.get(0));
		assertEquals(false, listInt.remove(-1));
		assertEquals(false, listInt.remove(10));
		assertEquals(4, listInt.size());
		
	}

}
