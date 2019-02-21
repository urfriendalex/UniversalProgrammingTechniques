package assignment04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;


public final class InputParserTest {
    private File test = new File("input.txt");

    @Test
    public void parse() {

        Assertions.assertEquals(4, InputParser.parse(test).size());
        }
    }