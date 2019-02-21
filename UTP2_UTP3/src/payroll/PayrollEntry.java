package payroll;

import employee.Employee;

import java.math.BigDecimal;


public final class PayrollEntry {

	private final Employee _employee;
	private final BigDecimal _salaryPlusBonus;
	
	public PayrollEntry(Employee employee, BigDecimal salary, BigDecimal bonus){
        _employee = employee;
        if (salary != null && bonus!= null) {
            _salaryPlusBonus = salary.add(bonus); // validate whether salary and bonus are not null
        }else
        if(salary != null){
            _salaryPlusBonus = salary;
        }else
            _salaryPlusBonus = null;
    }

    public BigDecimal get_salaryPlusBonus() {
        return _salaryPlusBonus;
    }

    public Employee get_employee() {
        return _employee;
    }

    @Override
	public String toString() {

		return _employee.getFirstName() + " " + _employee.getSurname() + " his salary: " + _salaryPlusBonus;
	}
}