package Instancies;

import Classes.Person.Student;

import java.util.*;

public class Students {
    private static final Set<Student> STUDENTS;

    static {
        STUDENTS = new TreeSet<>();
    }

    public static void add(Student student) {
        STUDENTS.add(student);
    }

    public static Set<Student> instancies() {
        return STUDENTS;
    }

    public static Student getInstance(int i) {
        return (Student) STUDENTS.toArray()[i];
    }
}
