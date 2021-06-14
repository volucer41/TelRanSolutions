package telran.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {
	List<Integer> listInt, listInt2;
	List<String> listString;

	@BeforeEach
	void setUp() throws Exception {
		listInt = new ArrayList<>(1);
		listString = new ArrayList<>();
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		listInt.add(5);
		listInt2 = new ArrayList<>(1);
	}

	@Test
	void addTest() {
		listInt.add(6);
		assertEquals(6, listInt.get(5));
	}

	@Test
	void addIndexTest() {
		assertTrue(listInt.add(100, 0));
		assertEquals(100, listInt.get(0));
		assertEquals(1, listInt.get(1));
		assertTrue(listInt.add(200, listInt.size()));
		assertEquals(200, listInt.get(listInt.size() - 1));
		assertTrue(listInt.add(300, 1));
		assertEquals(300, listInt.get(1));
		assertEquals(1, listInt.get(2));
		assertFalse(listInt.add(400, -1));
		assertFalse(listInt.add(400, 100));
		assertEquals(8, listInt.size());
	}

	@Test
	void removeTest() {
		assertTrue(listInt.remove(0));
		assertEquals(2, listInt.get(0));
		assertTrue(listInt.remove(1));
		assertEquals(4, listInt.get(1));
		assertFalse(listInt.remove(-1));
		assertFalse(listInt.remove(listInt.size()));
		assertEquals(3, listInt.size());
		assertTrue(listInt.remove(listInt.size() - 1));
	}

	@Test
	void getTest() {
		assertEquals(1, listInt.get(0));
		assertNull(listInt.get(-1));
		assertNull(listInt.get(100));
	}

	@Test
	void sizeTest() {
		assertEquals(5, listInt.size());
	}

	@Test
	void indexOfTest() {
		assertEquals(0, listInt.indexOf(1));
		assertEquals(2, listInt.indexOf(3));
		assertEquals(3, listInt.indexOf(4));
		assertEquals(-1, listInt.indexOf(100));
		listInt.add(500, 2);
		assertEquals(2, listInt.indexOf(500));
//		Integer a =50;
//		Integer b = 50;
//		String hello = "Hello";
//		String hello1 = new String("Hello");
//		assertTrue(hello.equals(hello1));
		Person prs1 = new Person(0, "Moshe");
		Person pattern = new Person(0, null);
		List<Person> persons = new ArrayList<>();
		persons.add(prs1);
		assertEquals(0, persons.indexOf(pattern));

	}

	@Test
	void lastIndexOfTest() {
		assertEquals(0, listInt.lastIndexOf(1));
		assertEquals(2, listInt.lastIndexOf(3));
		assertEquals(3, listInt.lastIndexOf(4));
		listInt.add(4, 4);
		assertEquals(4, listInt.lastIndexOf(4));
		assertEquals(-1, listInt.lastIndexOf(100));
	}

	@Test
	void addAllTest() {
		listInt2.addAll(listInt);
		assertTrue(listInt.equals(listInt2));
		listInt.add(100);
		assertFalse(listInt.equals(listInt2));
		listInt2.addAll(listInt);
		assertEquals(listInt2.size() - 1, listInt2.lastIndexOf(100));
	}

	@Test
	void removeAllTest() {
		listInt2.addAll(listInt);
		listInt2.addAll(listInt);
		assertTrue(listInt.removeAll(listInt2));
		assertEquals(null, listInt.get(0));
		assertEquals(null, listInt.get(listInt.size() - 1));
		assertFalse(listInt.removeAll(listInt2));
	}

	@Test
	void retainAllTest() {
		listInt2.addAll(listInt);
		listInt2.addAll(listInt);
		assertFalse(listInt2.retainAll(listInt));
		assertEquals(listInt.get(0), listInt2.get(0));
		assertEquals(listInt.get(listInt.size() - 1), listInt2.get(listInt2.size() - 1));
		listInt.add(100);
		assertTrue(listInt2.removeAll(listInt));
	}

	@Test
	void setTest() {
		assertEquals(listInt.get(0), listInt.set(10, 0));
		assertEquals(10, listInt.get(0));
		assertEquals(listInt.get(listInt.size() / 2), listInt.set(100, listInt.size() / 2));
		assertEquals(100, listInt.get(listInt.size() / 2));
		assertEquals(listInt.get(listInt.size() - 1), listInt.set(1000, listInt.size() - 1));
		assertEquals(1000, listInt.get(listInt.size() - 1));
		listInt2.addAll(listInt);
		assertEquals(null, listInt.get(listInt.size()));
		assertEquals(null, listInt.get(-10));
		assertTrue(listInt.equals(listInt2));
	}

	@Test
	void swapTest() {
		assertTrue(listInt.swap(0, 1));
		assertEquals(1, listInt.get(1));
		assertEquals(2, listInt.get(0));
		listInt2.addAll(listInt);
		assertFalse(listInt.swap(0, -10));
		assertFalse(listInt.swap(listInt.size(), 2));
		assertTrue(listInt.equals(listInt2));
	}

}
