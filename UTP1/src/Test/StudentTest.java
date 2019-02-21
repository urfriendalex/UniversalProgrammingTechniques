package Test;

import UTP1.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    private static final String name = "Adam";
    private static final String surname = "Tellor";
    private static final String sNum = "s17773";

        private Student student;

        @Before
        public void before() {
            student = new Student(name,surname,sNum);
            Assert.assertEquals(name, student.name());
            Assert.assertEquals(surname, student.surname());
            Assert.assertEquals(sNum, student.sNum());
        }

        @Test
        public void aggregate() {
            String intermidiateResult = student.aggregate(null);
            Assert.assertEquals(surname+" "+name+" "+sNum.replaceAll("\\D+","")+"\n", intermidiateResult);
            Student sTest = new Student("Bob","Malkowic","s17832");
            Assert.assertEquals((intermidiateResult + sTest.surname()+" "+sTest.name()+" "+sTest.sNum().replaceAll("\\D+","")+"\n" ),(sTest.aggregate(intermidiateResult)));
        }

        @Test
        public void deepClone() {
            Student clone = student.deepClone();
            Assert.assertEquals(student.name(), clone.name());
            Assert.assertEquals(student.surname(), clone.surname());
            Assert.assertEquals(student.sNum(), clone.sNum());
            Assert.assertNotSame(student, clone);
        }
    }
