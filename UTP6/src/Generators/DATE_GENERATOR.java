package Generators;

import java.time.LocalDate;
import java.util.Random;

public class DATE_GENERATOR {
    public  Random random;
    public int min;
    public int max;

    public DATE_GENERATOR(LocalDate START_DATE, LocalDate END_DATE){
        min = (int) START_DATE.toEpochDay();
        max = (int) END_DATE.toEpochDay();
        random = new Random();
    }
    public  LocalDate generate(){
        long genLong = min + random.nextInt(max-min+1);
        LocalDate genDate = LocalDate.ofEpochDay(genLong);
        return genDate;
    }
}
