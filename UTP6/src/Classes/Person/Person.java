package Classes.Person;

import Enums.Names;
import Enums.Nationality;
import Enums.Surnames;
import Generators.BIRTHDATE_GENERATOR;
import Generators.PESEL_GENERATOR;
import Instancies.Persons;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person implements Comparable<Person> {
    private String PESEL;
    private String firstName;
    private String surname;
    private LocalDate birthDate;
    private Nationality nationality;

    public Person(){
        firstName = Names.random().toString();
        surname = Surnames.random().toString();
        birthDate = BIRTHDATE_GENERATOR.generate();
            PESEL = PESEL_GENERATOR.generate_PESEL(birthDate);
        nationality = Nationality.random();
        Persons.add(this);
    }

    public Nationality getNationality() {
        return nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPESEL() {
        return PESEL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(PESEL, person.PESEL) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(birthDate, person.birthDate) &&
                nationality == person.nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PESEL, firstName, surname, birthDate, nationality);
    }

    @Override
    public int compareTo(Person otherPerson) {
        int result;
        result = this.getFirstName().compareTo(otherPerson.getFirstName());
        if (result!=0) return result;
        result = this.getSurname().compareTo(otherPerson.getSurname());
        if (result!=0) return result;
        return  this.getPESEL().compareTo(otherPerson.getPESEL());
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getSurname() + " " + getNationality().toString() + " " + getPESEL();
    }
}
