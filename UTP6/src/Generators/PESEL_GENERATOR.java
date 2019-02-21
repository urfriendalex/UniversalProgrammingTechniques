package Generators;

import java.time.LocalDate;
import java.util.Random;

public class PESEL_GENERATOR {

    private static final Random RANDOM = new Random();

    public static String generate_PESEL(LocalDate birthDate) {

        String year = getLast2DigitsOfYear(birthDate);
        String month = get2DigitsMonth(birthDate);
        String day = get2digitsDay(birthDate);
        String id_and_sex = String.format("%04d", RANDOM.nextInt(1000));
        String PESEL = year + month + day + id_and_sex;
        PESEL = PESEL + controlDigit(PESEL);

        return PESEL;

    }


    private static final int ZERO = (int) '0';

    public static int controlDigit(String PESEL) {
        int A = PESEL.charAt(0) - ZERO;
        int B = PESEL.charAt(1) - ZERO;
        int C = PESEL.charAt(2) - ZERO;
        int D = PESEL.charAt(3) - ZERO;
        int E = PESEL.charAt(4) - ZERO;
        int F = PESEL.charAt(5) - ZERO;
        int G = PESEL.charAt(6) - ZERO;
        int H = PESEL.charAt(7) - ZERO;
        int I = PESEL.charAt(8) - ZERO;
        int J = PESEL.charAt(9) - ZERO;

        int sum = A*1 + B*3 + C*7 + D*9 + E*1 + F*3 + G*7 + H*9 + I*1 + J*3;
        int mod = sum % 10;
        int Q = 10 - mod;
        if (mod == 0)
            Q = 0;
        else
        if (mod == 5)
            Q = 5;
        return Q;
    }

    public static String getLast2DigitsOfYear(LocalDate birthDate) {
        return (birthDate.getYear() + "").substring(2);
    }

    public static String get2DigitsMonth(LocalDate birthDate) {
        int moth2digits = birthDate.getMonthValue();
        if (birthDate.getYear() > 2000 && birthDate.getYear() < 2999) {
            moth2digits = birthDate.getMonthValue() + 20;
            return String.format("%02d", moth2digits);
        } else return String.format("%02d", moth2digits);
    }

    public static String get2digitsDay(LocalDate birthDate) {
        return String.format("%02d", birthDate.getDayOfMonth());
    }
}
