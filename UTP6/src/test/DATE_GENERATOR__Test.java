package test;

import Generators.DATE_GENERATOR;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DATE_GENERATOR__Test {

    @Test
    void generate() {
        DATE_GENERATOR generator =  new DATE_GENERATOR(LocalDate.of(1900,1,1),
                LocalDate.of(2029,1,1));
        System.out.println(generator.generate());
    }
}