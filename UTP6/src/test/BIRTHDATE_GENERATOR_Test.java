package test;

import Generators.BIRTHDATE_GENERATOR;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BIRTHDATE_GENERATOR_Test {
    LocalDate date;
    @Test
    public void generate() {
        date = BIRTHDATE_GENERATOR.generate();
        System.out.println(date.toString());
    }
}