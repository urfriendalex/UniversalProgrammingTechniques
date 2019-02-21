package Classes.Person;

import Instancies.Students;

import java.util.Objects;
import java.util.Random;

public class Student extends Person{
    private int StudnentBookNum;
    Random random = new Random();

    public Student() {
        super();
        StudnentBookNum = random.nextInt(9999);
        Students.add(this);
    }

    public int getStudnentBookNum() {
        return StudnentBookNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getStudnentBookNum() == student.getStudnentBookNum();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStudnentBookNum());
    }
}
