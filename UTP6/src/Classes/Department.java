package Classes;

import Classes.Person.Teacher;
import Instancies.Departments;

import java.util.Objects;
import java.util.Set;

public class Department implements Comparable<Department> {

    String deptName;
    Set<Teacher> employees;

    public Department(String deptName, Set<Teacher> employees) {
        this.deptName = deptName;
        this.employees = employees;
        Departments.add(this);
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(deptName, that.deptName) &&
                Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptName, employees);
    }

    @Override
    public int compareTo(Department OtherDepartment) {
        return this.getDeptName().compareTo(OtherDepartment.getDeptName());
    }
}
