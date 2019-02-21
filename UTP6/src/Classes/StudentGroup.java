package Classes;

import Classes.Person.Student;
import Instancies.StudentGroups;

import java.util.Objects;
import java.util.Set;


public class StudentGroup implements Comparable<StudentGroup>{
    String name;
    Set<Student> students;

    public StudentGroup(String _name, Set<Student> _students) {
        this.name = _name;
        this.students = _students;
        StudentGroups.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentGroup)) return false;
        StudentGroup that = (StudentGroup) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(students, that.students);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, students);
    }

    @Override
    public int compareTo(StudentGroup otherStudentGroup) {
        return this.getName().compareTo(otherStudentGroup.getName());
    }
}
