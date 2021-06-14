package telran.utils;

public class Person {

	/**
	 * @param anObject
	 * @return
	 * @see java.lang.String#equals(java.lang.Object)
	 */
	public boolean equals(Object anObject) {
		return name.equals(anObject);
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	int id;
	String name;

}
