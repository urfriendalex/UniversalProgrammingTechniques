package employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Worker extends Employee {

	// attributes
	// * employment date
	// * bonus
	LocalDate _empDate;
	BigDecimal _bonus;

	public Worker(String firstName, String surname, LocalDate dateOfBirth,
				  Manager manager, BigDecimal sal, LocalDate empDate, BigDecimal bonus){
		super(firstName,surname,dateOfBirth,manager,sal);
		_empDate = empDate;
		_bonus = bonus;
		if (manager != null)
		manager.addSub(this);
	}

	public void set_empDate(LocalDate _empDate) {
		this._empDate = _empDate;
	}

	public void set_bonus(BigDecimal _bonus) {
		this._bonus = _bonus;
	}

	public BigDecimal get_bonus() {
		return _bonus;
	}

	public LocalDate get_empDate() {
		return _empDate;
	}
}