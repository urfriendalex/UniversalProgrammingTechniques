package test;

import Classes.Department;
import Classes.Person.Person;
import Classes.Person.Student;
import Classes.Person.Teacher;
import Classes.StudentGroup;
import Classes.Subject;
import Instancies.*;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DB_GENERATOR {
    @Test
    public void generateBD(){
        //Students
        for (int i = 0;i<100;i++){
            Students.add(new Student());
        }
        //Teachers
        for (int i = 0; i < 10 ; i++) {
            Teachers.add(new Teacher());
        }
        //StudentGroups
        StudentGroups.add(new StudentGroup("Group 1",Students.instancies()
                .stream()
                .filter(p->p.getStudnentBookNum()>5000)
                .collect(Collectors.toSet())));
        StudentGroups.add(new StudentGroup("Group 2",Students.instancies()
                .stream()
                .filter(p->p.getStudnentBookNum()<3000)
                .collect(Collectors.toSet())));
        StudentGroups.add(new StudentGroup("Group 3",Students.instancies()
                .stream()
                .filter(p->p.getStudnentBookNum()>3000 && p.getStudnentBookNum()<5000)
                .collect(Collectors.toSet())));
        //Departments
        Departments.add(new Department("Math",Teachers.instancies()
                .stream()
                .filter(p->p.getDegree().toString().equals("BC"))
                .collect(Collectors.toSet())));
        Departments.add(new Department("Programming",Teachers.instancies()
                .stream()
                .filter(p->p.getDegree().toString().equals("MS"))
                .collect(Collectors.toSet())));
        Departments.add(new Department("Language",Teachers.instancies()
                .stream()
                .filter(p->p.getDegree().toString().equals("PHD"))
                .collect(Collectors.toSet())));
        //Subjects
        Set<Student> studentsForCalculus = new TreeSet<>();
        for (int i = 0; i <20 ; i++) {
            studentsForCalculus.add(Students.getInstance(i));
        }
        Set<Student> studentsForJava = new TreeSet<>();
        for (int i = 0; i <40 ; i++) {
            studentsForCalculus.add(Students.getInstance(i));
        }
        Set<Student> studentsForSQL = new TreeSet<>();
        for (int i = 50; i <90 ; i++) {
            studentsForCalculus.add(Students.getInstance(i));
        }

        Subjects.add(new Subject("Calculus",Departments.getInstance(0),Teachers.getInstance(0),studentsForCalculus));
        Subjects.add(new Subject("Java",Departments.getInstance(0),Teachers.getInstance(3),studentsForJava));
        Subjects.add(new Subject("SQL",Departments.getInstance(0),Teachers.getInstance(7),studentsForSQL));

        for (Person person: Persons.instancies()) {
            System.out.println(person.toString());
        }
    }
    @Test
    public void sortPeople(){
        //Students
        for (int i = 0;i<100;i++){
            Students.add(new Student());
        }
        //Teachers
        for (int i = 0; i < 20 ; i++) {
            Teachers.add(new Teacher());
        }

        System.out.print(Persons.instancies());
        System.out.println(Persons.sorted("pl"));
    }
}
