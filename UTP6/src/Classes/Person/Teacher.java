package Classes.Person;

import Enums.Degree;
import Generators.DATE_GENERATOR;
import Instancies.Teachers;

import java.time.LocalDate;
import java.util.Objects;

public class Teacher  extends Person{
    private Degree degree;
    private LocalDate hireDate;

    public Teacher() {
        super();
        degree = Degree.random();
        hireDate = new DATE_GENERATOR(LocalDate.of(2000,1,1),LocalDate.now()).generate();
        Teachers.add(this);
    }

    public Degree getDegree() {
        return degree;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return degree == teacher.degree &&
                Objects.equals(hireDate, teacher.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), degree, hireDate);
    }
}
