
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import employee.Employee;
import employee.Manager;
import employee.Trainee;
import employee.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HumanResourcesStatisticsTest {

	// Creates HR structure which resembles the below one:
	//
	// Director (an instance of Manager class (Director does not have a manager)
	//   |- Manager01
	//        |- Worker
	//        |- Worker
	//        |- Trainee
	//        |- ...
	//   |- Manager02
	//        |- ...
	//   |- ...
	//   |- Worker
	//   |- Worker
	//   |- Trainee

     private List<Employee> _allEmployees = new ArrayList<>(); // all employees ---  i.e. Workers, Trainees and their Managers and top Director (also an instance of Manager class)

	private Manager Director = new Manager("Richard","Branson",LocalDate.of(1971,1,3),null,
            new BigDecimal(20000),
            LocalDate.of(2000,1,1),
            new BigDecimal(5000));


    private Manager Manager01 = new Manager("Adam","Kolwiek",LocalDate.of(1984,8,26),
            Director,
            new BigDecimal(10000),
            LocalDate.of(2004,1,1),
            new BigDecimal(400));
    private Manager Manager02 = new Manager("Bob","Makrew",LocalDate.of(1986,5,7),
            Director,
            new BigDecimal(9999),
            LocalDate.of(2002,4,1),
            new BigDecimal(800));
    private Manager Manager03 = new Manager("Adam","Molley",LocalDate.of(1993,6,8),
            Manager02,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));
    private Manager Manager04 = new Manager("Adam","Molley",LocalDate.of(1993,6,8),
            Manager03,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));




    private Worker WorkerD1 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Director,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));
    private Trainee TraineeD1 = new Trainee("Adam","Molley",LocalDate.of(1993,6,8),
            Director,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            10);




    private Worker Worker011 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Manager01,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));
    private Worker Worker012 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Manager01,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));
    private Worker Worker013 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Manager01,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));

    private Trainee Trainee011 = new Trainee("Adam","Molley",LocalDate.of(1993,6,8),
            Manager01,
            new BigDecimal(10000),
            LocalDate.of(2016,6,1),
            6);
    private Trainee Trainee012 = new Trainee("Adam","Molley",LocalDate.of(1993,6,8),
            Manager01,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            6);




    private Worker Worker021 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Manager02,
            new BigDecimal(10000),
            LocalDate.of(2016,6,1),
            new BigDecimal(700));
    private Worker Worker022 = new Worker("Artem","Abramowic",LocalDate.of(1993,6,8),
            Manager02,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));

    private Trainee Trainee021 = new Trainee("Adam","Ambol",LocalDate.of(1993,6,8),
            Manager02,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            6);
    private Trainee Trainee022 = new Trainee("Adam","Molley",LocalDate.of(1993,6,8),
            Manager02,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            6);




    private Worker Worker031 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Manager03,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));
    private Worker Worker032 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Manager03,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));
    private Worker Worker033 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Manager03,
            new BigDecimal(10000),
            LocalDate.of(2015,6,1),
            new BigDecimal(700));
    private Trainee Trainee031 = new Trainee("Adam","Molley",LocalDate.of(1993,6,8),
            Manager03,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            6);




    private Worker Worker041 = new Worker("Adam","Molley",LocalDate.of(1993,6,8),
            Manager04,
            new BigDecimal(10000),
            LocalDate.of(2003,6,1),
            new BigDecimal(700));


    @Before
    public void setUp(){
        _allEmployees.add(Director);
        _allEmployees.add(WorkerD1);
        _allEmployees.add(TraineeD1);
        _allEmployees.add(Manager01);
        _allEmployees.add(Worker011);
        _allEmployees.add(Worker012);
        _allEmployees.add(Worker013);
        _allEmployees.add(Trainee011);
        _allEmployees.add(Trainee012);
        _allEmployees.add(Manager02);
        _allEmployees.add(Worker021);
        _allEmployees.add(Worker022);
        _allEmployees.add(Trainee021);
        _allEmployees.add(Trainee022);
        _allEmployees.add(Manager03);
        _allEmployees.add(Worker031);
        _allEmployees.add(Worker032);
        _allEmployees.add(Worker033);
        _allEmployees.add(Trainee031);
        _allEmployees.add(Manager04);
        _allEmployees.add(Worker041);
    }
	
	@Test
	public void payroll() {
		HumanResourcesStatistics.payroll(_allEmployees);
	}
	@Test
	public void subordinatesPayroll() {
		HumanResourcesStatistics.subordinatesPayroll(Director);
	}
	@Test
	public void bonusTotal() {
		BigDecimal total = HumanResourcesStatistics.bonusTotal(_allEmployees);
		Assert.assertEquals(new BigDecimal(14600), total);
	}
    @Test
    public void maxSal() {
        BigDecimal maxSal = HumanResourcesStatistics.maxSal(_allEmployees);
        Assert.assertEquals(new BigDecimal(20000),maxSal);
    }

    @Test
    public void maxSalBonus() {
        BigDecimal maxSalBonus = HumanResourcesStatistics.maxSalBonus(_allEmployees);
        Assert.assertEquals(new BigDecimal(25000),maxSalBonus);
    }

    @Test
    public void getLongestSen() {
        Assert.assertEquals(Director,
                HumanResourcesStatistics.getLongestSen(_allEmployees).get(0));
    }

    @Test
    public void getAllSubA() {
        List<Employee> assertE = new ArrayList<>();
        assertE.add(Worker022);
        assertE.add(Trainee021);
        Assert.assertEquals(assertE,HumanResourcesStatistics.getAllSubA(Manager02));
    }

    @Test
    public void more1000() {
        Assert.assertEquals(_allEmployees,HumanResourcesStatistics.more1000(_allEmployees));

    }

    @Test
    public void olderThenAndEarnMore() {
        List<Employee> d = new ArrayList<>();
        d.add(Director);
        Assert.assertEquals(d,HumanResourcesStatistics.olderThenAndEarnMore(_allEmployees,Manager01));
    }

    @Test
    public void practiceLengthLongerThan() {
        List<Employee> t = new ArrayList<>();
        t.add(TraineeD1);
        Assert.assertEquals(t,HumanResourcesStatistics.practiceLengthLongerThan(_allEmployees,8));
    }

    @Test
    public void seniorityLongerThan() {
        List<Employee> d = new ArrayList<>();
        d.add(Director);
        Assert.assertEquals(d,HumanResourcesStatistics.seniorityLongerThan(_allEmployees,210));
    }

    @Test
    public void seniorityBetweenOneAndThreeYears() {
        List<Employee> w = new ArrayList<>();
        w.add(Worker021);
        Assert.assertEquals(w,HumanResourcesStatistics.seniorityBetweenOneAndThreeYears(_allEmployees));
    }

    @Test
    public void seniorityLongerThan1() {
        List<Employee> m = new ArrayList<>();
        m.add(Manager02);
        Assert.assertEquals(m,HumanResourcesStatistics.seniorityLongerThan(_allEmployees,Manager01));
    }

    @Test
    public void seniorityBetweenTwoAndFourYearsAndAgeGreaterThan() {
        List<Employee> w = new ArrayList<>();
        w.add(Worker021);
        w.add(Worker033);
        Assert.assertEquals(w,HumanResourcesStatistics.seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(_allEmployees,23));
    }

}