package employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Trainee extends Employee {

	// attributes:
	// * practice start date
	// * practice length (in days)
	LocalDate _startDate;
	int _practiceLength;

	public Trainee(String firstName, String surname, LocalDate dateOfBirth,
				   Manager manager, BigDecimal sal,
				   LocalDate startDate, int practiceLength) {
		super(firstName,surname,dateOfBirth,manager,sal);
		_startDate = startDate;
		_practiceLength = practiceLength;
		manager.addSub(this);
	}


	public void set_practiceLength(int _practiceLength) {
		this._practiceLength = _practiceLength;
	}

	public void set_startDate(LocalDate _startDate) {
		this._startDate = _startDate;
	}

    public LocalDate get_startDate() {
        return _startDate;
    }

    public int get_practiceLength() {
        return _practiceLength;
    }
}