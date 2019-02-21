package employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public abstract class Employee extends Person {

	//
	// attributes:
	// * salary (use BigDecimal type for representing currency values)
	// * manager (empty if at top of hierarchy)

    private BigDecimal _sal;
    private Manager _manager;


	protected Employee(String firstName, String surname, LocalDate dateOfBirth,
                       Manager manager, BigDecimal sal) {
		super(firstName,surname,dateOfBirth);
		_manager = manager;
		_sal = sal;
	}


    public BigDecimal getSal() {
        return _sal;
    }

    public Manager getManager() {
        return _manager;
    }

    public void set_manager(Manager _manager) {
        this._manager = _manager;
    }

    public void set_sal(BigDecimal _sal) {
        this._sal = _sal;
    }
}