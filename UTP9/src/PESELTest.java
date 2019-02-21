import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class PESELTest {

    String PESEL = "08222500694";
    PESEL obj = new PESEL(PESEL);

    @Test
    void PESEL_operations() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class cls = obj.getClass();
        System.out.println("The name of class is " +
                cls.getName());

        System.out.println("The public declared methods of class are :");

        Method[] methods = cls.getDeclaredMethods();

        // Printing method names
        try {
            for (Method method : methods)
                System.out.println(method.getName());
        }finally {
            System.out.println();
        }


        //Checking methods
        System.out.println("Checking those methods...\n");

        Method PASTEL_validator = cls.getDeclaredMethod("PASTEL_validator");

        PASTEL_validator.setAccessible(true);

        System.out.print("PASTEL_validator invoked with: \n\t");
        PASTEL_validator.invoke(obj);


        Method getDate = cls.getDeclaredMethod("getDate");

        getDate.setAccessible(true);

        System.out.print("getDate invoked with: \n\t");
        System.out.println(getDate.invoke(obj));


        Method getSex = cls.getDeclaredMethod("getSex");

        getSex.setAccessible(true);

        System.out.print("getSex invoked with: \n\t");
        System.out.println(getSex.invoke(obj));

    }
}