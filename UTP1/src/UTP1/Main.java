package UTP1;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(32);
        Person p2 = new Person(23);
        Person p3 = new Person(78);
        Container<Person, Integer> container1 = new Container<>();
        container1.addEl(p1);
        container1.addEl(p2);
        container1.addEl(p3);
        Person clone = container1.cloneElementAtIndex(1);
        container1.aggregateAllElements();

        Car c1 = new Car(120,"NISSAN");
        Car c2 = new Car(130,"BMW");
        Car c3 = new Car(100,"JEEP");

        Container<Car,String> container2 = new Container<>();
        container2.addEl(c1);
        container2.addEl(c2);
        container2.addEl(c3);
        container2.aggregateAllElements();

    }
}
