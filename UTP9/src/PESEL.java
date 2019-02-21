import java.time.LocalDate;

public class PESEL {

    static String PESEL;

     PESEL(String PESEL){
        this.PESEL=PESEL;
    }

    private static final int ZERO = (int) '0';

    private static int controlDigitCalculator() {
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

    private boolean PASTEL_validator() {
        if (PESEL.length() == 11 || !PESEL.isEmpty()) {
            if (PESEL.charAt(10) - ZERO == controlDigitCalculator()) {
                System.out.println("PESEL is valid");
                return true;
            }
            System.out.println("PESEL's control Digit doesnt match 11th digit in provided PESEL");
            return false;
        }
        System.out.println("PESEL is too long or was not even provided.");
        return false;
    }

    private LocalDate getDate() {

        //day
        int E = PESEL.charAt(4) - ZERO;
        int F = PESEL.charAt(5) - ZERO;
        //month
        int C = PESEL.charAt(2) - ZERO;
        int D = PESEL.charAt(3) - ZERO;
        //year
        int A = PESEL.charAt(0) - ZERO;
        int B = PESEL.charAt(1) - ZERO;


        int yearFromPesel = A * 10 + B;
        int monthFromPesel = C * 10 + D;
        int dayFromPesel = E * 10 + F;

        if (monthFromPesel - 80 <= 12 && monthFromPesel - 80 >= 1) {
            yearFromPesel = 1800 + yearFromPesel;
            monthFromPesel = monthFromPesel - 80;
        } else if (monthFromPesel - 20 <= 12 && monthFromPesel - 20 >= 1) {
            yearFromPesel = 2000 + yearFromPesel;
            monthFromPesel = monthFromPesel - 20;
        } else if (monthFromPesel - 40 <= 12 && monthFromPesel - 40 >= 1) {
            yearFromPesel = 2100 + yearFromPesel;
            monthFromPesel = monthFromPesel - 40;
        } else if (monthFromPesel - 60 <= 12 && monthFromPesel - 60 >= 1) {
            yearFromPesel = 2200 + yearFromPesel;
            monthFromPesel = monthFromPesel - 60;
        } else {
            yearFromPesel = 1900 + yearFromPesel;
        }
        return LocalDate.of(yearFromPesel, monthFromPesel, dayFromPesel);
    }

    private Sex getSex() {

        int sexDigit = PESEL.charAt(9) - ZERO;

        if (sexDigit % 2 == 0)
           return  Sex.male;
        else
           return  Sex.female;
    }
}
