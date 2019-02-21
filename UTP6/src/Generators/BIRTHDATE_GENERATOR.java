package Generators;

import java.time.LocalDate;
import java.util.Random;

public class BIRTHDATE_GENERATOR {
    public static final LocalDate START_DATE =  LocalDate.of(1920,1,1);
    public static final int YEAR_START = START_DATE.getYear();
    public static final int MONTH_START = START_DATE.getMonthValue();
    public static final int DAY_START = START_DATE.getDayOfMonth();

    public static final LocalDate END_DATE =  LocalDate.of(2029,12,31);
    public static final int YEAR_END = END_DATE.getYear();
    public static final Random r = new Random();
    public static LocalDate generate(){
        LocalDate genDate;
        int genYear = YEAR_START + r.nextInt(YEAR_END-YEAR_START);
        int genMonth = MONTH_START + r.nextInt(12-MONTH_START);
        int genDay = DAY_START + r.nextInt(28-DAY_START);
        genDate = LocalDate.of(genYear,genMonth,genDay);
        if (genDate.isAfter(END_DATE))
            genDate = END_DATE;
        return genDate;
    }

}
