package Test;

import UTP1.Container;
import UTP1.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainerPersonTest {

    private Container container;
    private Person p1 = new Person(23);
    private Person p2 = new Person(45);
    @Before
    public void before(){
        container = new Container();
    }
    @Test
    public void get(){
        container.addEl(p1);
        Assert.assertEquals(container.elements().get(0),container.get(0));
    }
    @Test
    public void ensureElementsAddedCorrectly(){
        container.addEl(p1);
        container.addEl(p2);
        Assert.assertEquals(p1,container.get(0));
        Assert.assertEquals(p2,container.get(1));
    }
    @Test
    public void addList(){
        List<Person> listTest = new ArrayList<>();
        listTest.add(p1);
        listTest.add(p2);
        container.addList(listTest);
        Assert.assertEquals(listTest.get(0),container.get(0));
        Assert.assertEquals(listTest.get(1),container.get(1));
    }
    @Test
    public void aggregateAll(){
        int intermidiateResult = 0;
        container.addEl(p1);
        container.addEl(p2);
        Assert.assertEquals(68,container.aggregateAllElements());
    }
    @Test
    public void cloneAtIn(){
        container.addEl(p1);
        Assert.assertNotSame(container.get(0),container.cloneElementAtIndex(0));
    }
}
