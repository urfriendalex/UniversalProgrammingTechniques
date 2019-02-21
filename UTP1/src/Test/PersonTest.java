package Test;

import UTP1.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	private static final int AGE = 20;

	private Person _person;

	@Before
	public void before() {
		_person = new Person(AGE);
		Assert.assertEquals(AGE, _person.age());
	}

	@Test
	public void aggregate() {
		int aggregate = _person.aggregate(null);
		Assert.assertEquals(AGE, aggregate);
		final int init = 20;
		Assert.assertEquals((int)(AGE + init), (int) (_person.aggregate(init)));
	}

	@Test
	public void deepClone() {
		Person clone = _person.deepClone();
		Assert.assertEquals(_person.age(), clone.age());
		Assert.assertNotSame(_person, clone);
	}
}