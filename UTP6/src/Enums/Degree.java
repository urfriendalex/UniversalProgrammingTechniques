package Enums;

import java.util.Random;

public enum  Degree {

    BC("BC"),
    MS("MS"),
    PHD("PHD");

    private final String text;

    Degree(final String te){
        text = te;
    }

    public static Enums.Degree random() {
        Random r = new Random();
        return Enums.Degree.values()[r.nextInt(Enums.Degree.values().length)];
    }
    @Override
    public String toString() {
        return text;
    }
}
