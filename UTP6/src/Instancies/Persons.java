package Instancies;

import Classes.Person.Person;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Persons {
    private static final Set<Person> PEOPLE;

    static {
        PEOPLE = new TreeSet<>();
    }

    public static void add(Person person){
        PEOPLE.add(person);
    }

    public static Set<Person> instancies(){
        return PEOPLE;
    }
    public static List sorted(String s){
        Collator coll = Collator.getInstance(new Locale(s));
        return PEOPLE.stream()
                .filter(p -> s.equals(p.getNationality().toString()))
                .sorted(coll)
                .collect(Collectors.toList());
    }
}
