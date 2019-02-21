package test;

import Utilities.FileDirUtility;
import Utilities.ZipUtility;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ZipUtilityTest {

    ZipUtility zipUtility = new ZipUtility();

    @Test
        void searchZip() {

            System.out.println(zipUtility.searchZip("/Users/tobeurdeath/Desktop/untitled/prog/PJC_Projects.zip","main"));
        }
    @Test
    void searchZipbyFileCont() {
        System.out.println(zipUtility.searchZipByFileContent("/Users/tobeurdeath/Desktop/untitled/prog/PJC_Projects.zip","main"));
    }
}