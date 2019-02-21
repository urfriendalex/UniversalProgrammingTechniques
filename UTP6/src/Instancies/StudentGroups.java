package Instancies;

import Classes.StudentGroup;

import java.util.*;

public class StudentGroups {
    private static final Set<StudentGroup> STUDENT_GROUPS;

    static {
        STUDENT_GROUPS = new TreeSet<>();
    }

    public static void add(StudentGroup studentGroup){
        STUDENT_GROUPS.add(studentGroup);
    }

    public static Set<StudentGroup> instancies(){
        return STUDENT_GROUPS;
    }
}
