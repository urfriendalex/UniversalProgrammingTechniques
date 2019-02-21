package assignment08;

import assignemnt08.Assignment08Exception;
import assignment04.PersonDatabase;
import org.junit.jupiter.api.Test;

import java.io.*;

public class PersonDatabaseTest {
    private PersonDatabase database;

    {
        database = new PersonDatabase(new File("/Users/tobeurdeath/Desktop/untitled/prog/UTP_Projects/UTP4_UTP8/input.txt"));
    }

    @Test
    public void serialize() throws Assignment08Exception, FileNotFoundException {
            database.serialize(new DataOutputStream(new FileOutputStream("db")));
    }
    @Test
    public void deserialize() throws Assignment08Exception, IOException {
       PersonDatabase newDatabase = PersonDatabase.deserialize(new DataInputStream(new FileInputStream(new File("/Users/tobeurdeath/Desktop/untitled/prog/UTP_Projects/UTP4_UTP8/db"))));
        System.out.println(database.sortedBySurnameFirstNameAndBirthdate());
        System.out.println(newDatabase.sortedBySurnameFirstNameAndBirthdate());
    }
}
