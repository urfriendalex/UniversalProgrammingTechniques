package Instancies;

import Classes.Subject;

import java.util.*;

public class Subjects {
    private static final Set<Subject> SUBJECTS;

    static {
        SUBJECTS = new TreeSet<>();
    }

    public static void add(Subject subject) {
        SUBJECTS.add(subject);
    }

    public static Set<Subject> instancies() {
        return SUBJECTS;
    }

    public static Subject getInstance(int i) {
        return (Subject) SUBJECTS.toArray()[0];
    }
}
