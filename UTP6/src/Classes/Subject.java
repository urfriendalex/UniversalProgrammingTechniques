package Classes;

import Classes.Person.Student;
import Classes.Person.Teacher;
import Instancies.Subjects;

import java.util.Objects;
import java.util.Set;

public class Subject implements Comparable<Subject> {
    String Name;
    Department department;
    Teacher lecturer;
    Set<Student> students;

    public Subject(String _name, Department _department, Teacher _lecturer, Set<Student> _students) {
        Name = _name;
        this.department = _department;
        this.lecturer = _lecturer;
        this.students = _students;
        Subjects.add(this);
    }

    public String getName() {
        return Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return Objects.equals(Name, subject.Name) &&
                Objects.equals(department, subject.department) &&
                Objects.equals(lecturer, subject.lecturer) &&
                Objects.equals(students, subject.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, department, lecturer, students);
    }

    @Override
    public int compareTo(Subject otherSubject) {
        return this.getName().compareTo(otherSubject.getName());
    }
}
