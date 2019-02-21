package Enums;

import java.util.Random;

public enum Names {

    Name1("Bill"),
    Name2("Jill"),
    Name3("Janice"),
    Name4("Joye"),
    Name5("Ross"),
    Name6("Rachel"),
    Name7("Monica"),
    Name8("Chandler"),
    Name9("Phoebe");

    private final String text;

    Names(final String te){
        text = te;
    }

    public static Enums.Names random() {
        Random r = new Random();
        return Enums.Names.values()[r.nextInt(Enums.Names.values().length)];
    }
    @Override
    public String toString() {
        return text;
    }
}
