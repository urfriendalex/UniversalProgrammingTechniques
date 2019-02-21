package Instancies;

import Classes.Department;

import java.util.*;

public class Departments {
    private static final Set<Department> DEPARTMENTS;

    static {
        DEPARTMENTS = new TreeSet<>();
    }

    public static void add(Department department){
        DEPARTMENTS.add(department);
    }

    public static Set<Department> instancies(){
        return DEPARTMENTS;
    }

    public static Department getInstance(int i) {
        return (Department)DEPARTMENTS.toArray()[i];
    }
}
