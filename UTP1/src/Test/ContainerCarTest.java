package Test;

import UTP1.Car;
import UTP1.Container;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainerCarTest {

    private Container container;
    private Car c1 = new Car(100,"Nissan");
    private Car c2 = new Car(150,"BMW");
    @Before
    public void before(){
        container = new Container();
    }
    @Test
    public void get(){
        container.addEl(c1);
        Assert.assertEquals(container.elements().get(0),container.get(0));
    }
    @Test
    public void ensureElementsAddedCorrectly(){
        container.addEl(c1);
        container.addEl(c2);
        Assert.assertEquals(c1,container.get(0));
        Assert.assertEquals(c2,container.get(1));
    }
    @Test
    public void addList(){
        List<Car> listTest = new ArrayList<>();
        listTest.add(c1);
        listTest.add(c2);
        container.addList(listTest);
        Assert.assertEquals(listTest.get(0),container.get(0));
        Assert.assertEquals(listTest.get(1),container.get(1));
    }
    @Test
    public void aggregateAll(){
        String intermidiateResult = "";
        container.addEl(c1);
        container.addEl(c2);
        Assert.assertEquals(c1.model()+" max speed: "+String.valueOf(c1.maxSpeed())+"\n"
                        +c2.model()+" max speed: "+String.valueOf(c2.maxSpeed())+"\n"
                ,container.aggregateAllElements());
    }
    @Test
    public void cloneAtIn(){
        container.addEl(c1);
        Assert.assertNotSame(container.get(0),container.cloneElementAtIndex(0));
    }

}
