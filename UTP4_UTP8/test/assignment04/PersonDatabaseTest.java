package assignment04;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonDatabaseTest {

    private PersonDatabase database;

    {
        database = new PersonDatabase(new File("/Users/tobeurdeath/Desktop/untitled/prog/UTP_Projects/UTP4_UTP8/input.txt"));
    }

    @Test
    public void sortedByFirstName() {
        for (int i = 0; i < database.sortedByFirstName().size(); i++) {
            System.out.println(database.sortedByFirstName().get(i).get_firstName());
        }
    }

    @Test
    public void sortedBySurnameFirstNameAndBirthDate() {
        for (int i = 0; i < database.sortedBySurnameFirstNameAndBirthdate().size(); i++) {
            System.out.print(database.sortedBySurnameFirstNameAndBirthdate().get(i).get_firstName() + "\t");
            System.out.print(database.sortedBySurnameFirstNameAndBirthdate().get(i).get_surname() + "\t");
            System.out.println(database.sortedBySurnameFirstNameAndBirthdate().get(i).get_birthDate());
        }
    }

    @Test
    public void sortedByBirthDate() {
        for (int i = 0; i < database.sortedByBirthdate().size(); i++) {
            System.out.print(database.sortedByBirthdate().get(i).get_firstName() + "\t");
            System.out.print(database.sortedByBirthdate().get(i).get_surname() + "\t");
            System.out.println(database.sortedByBirthdate().get(i).get_birthDate());
        }
    }

    @Test
    public void bornOnDay() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse("1980-01-03");
        for (int i = 0; i < database.bornOnDay(date).size(); i++) {
            System.out.print(database.bornOnDay(date).get(i).get_firstName() + "\t");
            System.out.print(database.bornOnDay(date).get(i).get_surname() + "\t");
            System.out.println(database.bornOnDay(date).get(i).get_birthDate());
        }
    }
}