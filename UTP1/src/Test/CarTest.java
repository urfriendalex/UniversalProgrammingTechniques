package Test;

import UTP1.Car;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private static final String model = "Nissan";
    private static final int maxSpeed = 100;

    private Car car;

    @Before
    public void before() {
        car = new Car(maxSpeed,model);
        Assert.assertEquals(maxSpeed, car.maxSpeed());
        Assert.assertEquals(model, car.model());
    }

    @Test
    public void aggregate() {
        String intermidiateResult = car.aggregate(null);
        Assert.assertEquals(model+" max speed: "+String.valueOf(maxSpeed)+"\n", intermidiateResult);
        Car cTest = new Car(150,"BMW");
        Assert.assertEquals((intermidiateResult + cTest.model()+" max speed: "+String.valueOf(cTest.maxSpeed())+"\n" ),(cTest.aggregate(intermidiateResult)));
    }

    @Test
    public void deepClone() {
        Car clone = car.deepClone();
        Assert.assertEquals(car.maxSpeed(), clone.maxSpeed());
        Assert.assertEquals(car.model(), clone.model());
        Assert.assertNotSame(car, clone);
    }
    @Test(expected = Exception.class)
    public void NegativeSpeedException() throws Exception{
               car.changeSpeed(-1);
    }
}
