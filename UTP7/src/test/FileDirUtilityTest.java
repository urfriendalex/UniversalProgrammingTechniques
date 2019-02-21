package test;

import Utilities.FileDirUtility;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FileDirUtilityTest {

    FileDirUtility fileDirUtility = new FileDirUtility();

    @Test
     void searchDir() throws IOException {
        System.out.println(fileDirUtility.searchDir("/Users/tobeurdeath/Desktop/untitled","main"));
    }

    @Test
    void searchDirByFileContent() throws IOException{
        System.out.println(fileDirUtility.searchDirByFileContent("/Users/tobeurdeath/Desktop/untitled","main"));
    }
}