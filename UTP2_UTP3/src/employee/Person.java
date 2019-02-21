package employee;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

	// To implement an attribute means that you provide a backing field and
	// getter or optionally setter for read-write properties/attributes
	// 
	// NO BACKING FIELDS SHOULD BE PROVIDED FOR DERIVED ATTRIBUTES
	// THOSE SHOULD BE COMPUTED ON-LINE
	//
	// attributes:
	// * first name (read-only)
	// * surname (read-only)
	// * birth date (read-only) --- date MUST BE represented by an instance of
	// type designed for date representation (either Date or LocalDate)
	//
	// * age (derived --- computed based on birth date) --- implemented as a
	// getter calculating the difference between the current date and birth date

	private final String _firstName;
	private final String _Surname;// backing field
	private final LocalDate _birthDate;
	private int age;

	protected Person(String firstName, String surname, LocalDate birthDate) {
		_firstName = firstName;
		_Surname = surname;
		_birthDate = birthDate;
		Period period;
		period = Period.between(_birthDate, LocalDate.now());
		age = period.getYears();
	}

	public String getFirstName() { // getter
		return _firstName;
	}
	public String getSurname(){
	    return _Surname;
    }
    public LocalDate getbirthDate(){
	    return _birthDate;
    }
    public int getAge() {
        return age;
    }

}