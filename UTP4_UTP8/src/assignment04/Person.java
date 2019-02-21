package assignment04;

import assignemnt08.Assignment08Exception;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Person implements Comparable<Person> {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");
	private final String _firstName;
	private final String _surname;
	private final Date _birthDate;
	
	public Person(String firstName, String surname, String birthDate) throws ParseException {
		this._firstName = firstName;
		this._surname = surname;
		this._birthDate = DATE_FORMAT.parse(birthDate);
	}

	public Person(String newFirstName, String newSurname, Date newBirthDate) {
		this._firstName = newFirstName;
		this._surname = newSurname;
		this._birthDate = newBirthDate;
	}

	@Override
	public int compareTo(Person otherPerson) {
	    int result;
	        result = this.get_firstName().compareTo(otherPerson.get_firstName());
		        if (result!=0) return result;
		    result = this.get_surname().compareTo(otherPerson.get_surname());
                if (result!=0) return result;
        return  this.get_birthDate().compareTo(otherPerson.get_birthDate());
	}

    public String get_firstName() {
        return _firstName;
    }

    public String get_surname() {
        return _surname;
    }

    public Date get_birthDate() {
        return _birthDate;
    }

	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {
		// serialize birth date with getTime() method
		// encapsulate IOException in Assignment08Exception
		try {
			output.writeUTF(_firstName);
			output.writeUTF(_surname);
			output.writeLong(_birthDate.getTime());
		}catch (Throwable e){
			throw new Assignment08Exception(e);
		}
	}

	public static Person deserialize(DataInputStream input) throws Assignment08Exception {
		try {
			String newFirstName = input.readUTF();
			String newSurname = input.readUTF();
			Date newBirthDate =  new Date(input.readLong());
				return new Person(newFirstName,newSurname,newBirthDate);
		}catch (Throwable e){
			throw  new Assignment08Exception(e);
		}
	}

	@Override
	public String toString() {
		return get_firstName() + " " + get_surname() + " " + get_birthDate();
	}
}

