package assignment04;

import assignemnt08.Assignment08Exception;
import assignment04.comparators.BirthdateComparator;
import assignment04.comparators.FirstNameComparator;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {

    private static final Comparator<Person> BY_SURNAME_NAME_BIRTHDAY = Comparator.naturalOrder();
    private static final Comparator<Person> BY_NAME = new FirstNameComparator();
    private static final Comparator<Person> BY_BIRTHDAY = new BirthdateComparator();

    private final List<Person> _bySurnameAndFirstNameAndBirthDate;
    private final List<Person> _byBirthDate;
    private final List<Person> _byFirstName;
    private final Map<Date, List<Person>> _searchByBirthDate;

	public PersonDatabase(File file) {
		this(InputParser.parse(file));
	}


	public PersonDatabase(List<Person> data){
		_bySurnameAndFirstNameAndBirthDate = data;
		_byFirstName = data;
		_byBirthDate = data;

		_bySurnameAndFirstNameAndBirthDate.sort(BY_SURNAME_NAME_BIRTHDAY);
		_byFirstName.sort(BY_NAME);

		_byBirthDate.sort(BY_BIRTHDAY);
		_searchByBirthDate = data
				.stream()
				.collect(Collectors.groupingBy(	Person::get_birthDate,
												TreeMap::new,
												Collectors.mapping(
														p->p,Collectors.toList())));
	}

	// assignment 8 - factory method based on deserialization
	public static PersonDatabase deserialize(DataInputStream input) throws Assignment08Exception, IOException {
			List<Person> persons = new ArrayList<>();
			while (input.available()>0) {
				Person p = Person.deserialize(input);
				persons.add(p);
			}
			return new PersonDatabase(persons);
	}

	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {
		for (Person person: sortedBySurnameFirstNameAndBirthdate()) {
			person.serialize(output);
		}
	}

	// assignment 4
    public List<Person> sortedByFirstName() {
		return _byFirstName;
	}

	// assignment 4
	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
		return _bySurnameAndFirstNameAndBirthDate;
	}

	// assignment 4
	public List<Person> sortedByBirthdate() {
		return _byBirthDate;
	}

	// assignment 4
	public List<Person> bornOnDay(Date date) {
	    return _searchByBirthDate.get(date);
	}

}