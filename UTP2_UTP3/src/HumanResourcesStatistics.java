import employee.*;
import payroll.PayrollEntry;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public final class HumanResourcesStatistics {

	static List<PayrollEntry> payroll(List<Employee> employees) {

        return employees.stream().map(HumanResourcesStatistics::payrollEntry).collect(Collectors.toList());
	}

	private static PayrollEntry payrollEntry(Employee e){
	    if (e instanceof Worker){
                return new PayrollEntry(e,e.getSal(),((Worker) e).get_bonus());
        }else {
                return new PayrollEntry(e,e.getSal(),null);
        }
    }

	public static List<PayrollEntry> subordinatesPayroll(Manager manager) {
		return payroll(manager.get_allSubList());
	}

	public static BigDecimal bonusTotal(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e instanceof Worker)
                .map(w -> ((Worker) w).get_bonus())
                .reduce(BigDecimal.ZERO,(partialResult,next) -> { return partialResult.add(next);
                });
    }

	public static BigDecimal maxSal(List<Employee> employees){
        return employees //
                .stream() //
                .map(e -> e.getSal()) //
                .reduce(BigDecimal.ZERO, (partialResult, next) -> {
                    if (partialResult.compareTo(next) > 0) {
                        return partialResult;
                    } else {
                        return next;
                    }
                });
    }
    public static BigDecimal maxSalBonus(List<Employee> employees){
        return employees //
                .stream() //
                .map(e -> e.getSal().add(HumanResourcesStatistics.getBonus(e))) //
                .reduce(BigDecimal.ZERO, (partialResult, next) -> {
                    if (partialResult.compareTo(next) > 0) {
                        return partialResult;
                    } else {
                        return next;
                    }
                });
    }



    public static List<Employee> getLongestSen(List<Employee> employees) {
        return employees
                .stream().filter(e -> HumanResourcesStatistics.getSen(e).equals(employees.stream()
                .map(emp -> HumanResourcesStatistics.getSen(emp)) //
                .reduce(Period.ZERO, (partialResult, next) -> {
                    if (partialResult.toTotalMonths() * 30 + partialResult.getDays() > next.toTotalMonths() * 30 + next.getDays()) {
                        return partialResult;
                    } else {
                        return next;
                    }
                }))).collect(Collectors.toList());
    }


    public static List<Employee> getAllSubA(Manager m){
	    List<Employee> all = m.get_allSubList();
	    return all
                .stream()
                .filter(employee -> employee.getSurname().startsWith("A"))
                .collect(Collectors.toList());
    }

	public static List<Employee> more1000 (List<Employee> employees){
             return employees
                     .stream()
                     .filter(e -> compTo1000(e))
                     .collect(Collectors.toList());
    }

    // (assignment 03)
    // methods:
    //
    // * search for Employees older than given employee and earning less than him

    private static Predicate<Employee> isWorker = e -> e instanceof Worker;
    private static Predicate<Employee> isTrainee = e -> e instanceof Trainee;

    public static List<Employee> olderThenAndEarnMore(List<Employee> allEmployees, Employee employee) {
	   return allEmployees
                .stream()
                .filter(e -> (e.getAge()>employee.getAge() && e.getSal().compareTo(employee.getSal())>0))
                .collect(Collectors.toList());
    }

    // * search for Trainees whose practice length is longer than given number of days and raise their salary by 5%
    public static List<Trainee> practiceLengthLongerThan(List<Employee> allEmployees, int daysCount) {
        List<Trainee> traineeList = new ArrayList<>();
	    allEmployees
                .stream()//
                .filter(isTrainee)
                .filter(t -> ((Trainee) t).get_practiceLength()>daysCount)
                .forEach(t->{
                    t.set_sal(t.getSal().add(t.getSal().multiply(new BigDecimal(0.05))));
                    traineeList.add((Trainee) t);
                });
	 return traineeList;
    }

    // * search for Workers whose seniority is longer than given number of months and give them bonus of 300 if their bonus is smaller
    public static List<Worker> seniorityLongerThan(List<Employee> allEmployees, int monthCount) {
        List<Worker> workerList = new ArrayList<>();

        allEmployees
                .stream()
                .filter(e -> e instanceof Worker && (Period.between(((Worker) e).get_empDate(),LocalDate.now()).getMonths()
                        + Period.between(((Worker) e).get_empDate(),LocalDate.now()).getYears() * 12 )
                        >monthCount)
                .map(e -> (Worker) e)
                .forEach((w->{
                    if ( w.get_bonus().compareTo(new BigDecimal(300))<0)
                        w.set_bonus(new BigDecimal(300));
                    workerList.add(w);
                }));
       return workerList;
    }

    // * search for Workers whose seniority is between 1 and 3 years and give them raise of salary by 10%
    public static List<Worker> seniorityBetweenOneAndThreeYears(List<Employee> allEmployees) {
        List<Worker> workerList = new ArrayList<>();
        allEmployees
                .stream()
                .filter(e -> e instanceof Worker && HumanResourcesStatistics.getSen(e).getYears()>1
                        && HumanResourcesStatistics.getSen(e).getYears()<3)
                .map(e -> (Worker) e)
                .forEach((w -> {
                        w.set_sal(w.getSal().add(w.getSal().multiply(new BigDecimal(0.1))));
                        workerList.add(w);
                                }));
	    return workerList;
    }

    // * search for Workers whose seniority is longer than the seniority of a given employee and earn less than him and align their salary with the given employee

    public static List<Worker> seniorityLongerThan(List<Employee> allEmployees, Employee employee) {
	    List<Worker> workerList= new ArrayList<>();
	    allEmployees
                .stream()
                .filter(isWorker)
                .map(e -> (Worker) e)
                .forEach(w ->{
                    if (HumanResourcesStatistics.getSen(w).toTotalMonths()
                            >HumanResourcesStatistics.getSen(employee).toTotalMonths() &&
                    w.getSal().compareTo(employee.getSal())<0) {
                        w.set_sal(employee.getSal());
                        workerList.add(w);
                    }
                });
        return workerList;
    }

    // * search for Workers whose seniority is between 2 and 4 years and whose age is greater than given number of years
    public static List<Worker> seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(List<Employee> allEmployees, int age) {
	   return  allEmployees
                .stream()
                .filter(e -> e instanceof Worker && HumanResourcesStatistics.getSen(e).getYears()>=2
                        && HumanResourcesStatistics.getSen(e).getYears()<=4
                        && e.getAge()>age)
                .map(e -> (Worker) e)
                .collect(Collectors.toList());

    }

    private static Period getSen(Employee e){

        if (e instanceof Worker)
            return Period.between(((Worker) e).get_empDate(),LocalDate.now());
        else
        if (e instanceof Trainee)
            if(((Trainee) e).get_startDate()
                    .plusMonths(((Trainee) e).get_practiceLength()).isBefore(LocalDate.now()))
                return Period.between(((Trainee) e).get_startDate(),((Trainee) e).get_startDate()
                        .plusMonths(((Trainee) e).get_practiceLength()));
            else
                return Period.between(((Trainee) e).get_startDate(),LocalDate.now());
        else
            return null;
    }

    private static BigDecimal getSalPlusBonus(Employee e){
        if (e instanceof Worker)
            return e.getSal().add(((Worker) e).get_bonus());
        else return e.getSal();
    }
    private static boolean compTo1000(Employee e){
        return HumanResourcesStatistics.getSalPlusBonus(e).compareTo(new BigDecimal(1000))>0;
    }
    private static BigDecimal getBonus(Employee e){
        if (e instanceof Worker){
            return ((Worker) e).get_bonus();
        }
        else return new BigDecimal(0);
    }
}