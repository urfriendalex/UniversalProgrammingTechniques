package Instancies;

import Classes.Person.Teacher;

import java.util.*;

public class Teachers {
    private static final Set<Teacher> TEACHERS;

    static {
        TEACHERS = new TreeSet<>();
    }

    public static void add(Teacher teacher){
        TEACHERS.add(teacher);
    }

    public static Set<Teacher> instancies(){
        return TEACHERS;
    }
    public static Teacher getInstance(int i) {
        return (Teacher) TEACHERS.toArray()[i];
    }
}
