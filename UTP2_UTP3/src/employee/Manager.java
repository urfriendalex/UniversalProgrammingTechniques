package employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Manager extends Worker {

	// attributes
	// * subordinates (a list of immediate subordinates)
	// * all subordinates (a list of subordinates in all hierarchy)
    List<Employee> _imSubList = new ArrayList<>();


	public Manager(String firstName, String surname, LocalDate dateOfBirth,
                   Manager manager, BigDecimal sal, LocalDate empDate, BigDecimal bonus) {
		super(firstName,surname,dateOfBirth,manager,sal, empDate, bonus);
	}

	public List<Employee> get_allSubList() {
	    List<Employee> _allSubList = new ArrayList<>();
        _allSubList.addAll(_imSubList);
	    _allSubList.addAll(
	            _imSubList
                .stream() //
                .filter(e -> e instanceof Manager) //
                .map(e -> (Manager) e)
                .flatMap(e -> e.get_allSubList().stream()) //
                .collect(Collectors.toList())
        );
		return _allSubList;
	}

	public List<Employee> get_imSubList() {
		return _imSubList;
	}

	public void set_imSubList(List<Employee> _imSubList) {
		this._imSubList = _imSubList;
	}

	public void addSub(Employee emp){
		_imSubList.add(emp);
    }
}