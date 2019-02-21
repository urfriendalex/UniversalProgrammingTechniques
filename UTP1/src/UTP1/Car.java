package UTP1;

public class Car implements IAggregable<Car, String>, IDeeplyCloneable<Car> {
    private int maxSpeed;
    private String model;

    public Car() { }

    public Car(int maxspeed,String model)  {
        this.maxSpeed = maxspeed;
        this.model = model;
    }

    public int maxSpeed() {
        return maxSpeed;
    }
    public String model() { return model; }
    public void changeSpeed(int newSpeed) throws Exception {
        if (newSpeed >= 0){
            maxSpeed = newSpeed;
        }
        else {
            throw new Exception("Speed cannot be negative");
        }
    }
    @Override
    public String aggregate(String intermediateResult) {
        if  (intermediateResult == null) {
           return model+" max speed: "+String.valueOf(maxSpeed)+"\n";
        }
        else
        return  intermediateResult+model+" max speed: "+String.valueOf(maxSpeed)+"\n";
    }

    public Car deepClone() {
        Car clone = new Car();
        clone.maxSpeed = maxSpeed;
        clone.model = model;
        return clone;
    }
}
