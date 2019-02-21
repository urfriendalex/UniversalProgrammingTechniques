package Test;

import UTP1.Container;
import UTP1.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainerStudentTest {

    private Container container;
    private Student s1 = new Student("Chendler","Bing","s16373");
    private Student s2 = new Student("Joe","Tribiani","s12231");
    @Before
    public void before(){
        container = new Container();
    }
    @Test
    public void get(){
        container.addEl(s1);
        Assert.assertEquals(container.elements().get(0),container.get(0));
    }
    @Test
    public void ensureElementsAddedCorrectly(){
        container.addEl(s1);
        container.addEl(s2);
        Assert.assertEquals(s1,container.get(0));
        Assert.assertEquals(s2,container.get(1));
    }
    @Test
    public void addList(){
        List<Student> listTest = new ArrayList<>();
        listTest.add(s1);
        listTest.add(s2);
        container.addList(listTest);
        Assert.assertEquals(listTest.get(0),container.get(0));
        Assert.assertEquals(listTest.get(1),container.get(1));
    }
    @Test
    public void aggregateAll(){
        String intermidiateResult = "";
        container.addEl(s1);
        container.addEl(s2);
        Assert.assertEquals(s1.surname()+" "+s1.name()+" "+s1.sNum().replaceAll("\\D+","")+"\n"
                        +s2.surname()+" "+s2.name()+" "+s2.sNum().replaceAll("\\D+","")+"\n"
                ,container.aggregateAllElements());
    }
    @Test
    public void cloneAtIn(){
        container.addEl(s1);
        Assert.assertNotSame(container.get(0),container.cloneElementAtIndex(0));
    }
}
