package test;

import Generators.BIRTHDATE_GENERATOR;
import Generators.PESEL_GENERATOR;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PESEL_GENERATOR_Test {

    LocalDate date = BIRTHDATE_GENERATOR.generate();

    @Test
    void generate_PESEL() {
        System.out.println(date);
        System.out.println(PESEL_GENERATOR.generate_PESEL(date));

    }
}