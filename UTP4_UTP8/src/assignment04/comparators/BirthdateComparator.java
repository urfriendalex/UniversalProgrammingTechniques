package assignment04.comparators;


import assignment04.Person;

import java.util.Comparator;

public final class BirthdateComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		return person1.get_birthDate().compareTo(person2.get_birthDate());
	}
}