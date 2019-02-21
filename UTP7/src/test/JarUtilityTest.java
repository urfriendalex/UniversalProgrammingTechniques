package test;

import Utilities.JarUtility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.jar.JarFile;

import static org.junit.jupiter.api.Assertions.*;

class JarUtilityTest {

    JarUtility jarUtility = new JarUtility();

    @Test
    void searchJar() {
        System.out.println(jarUtility.searchJar("/Users/tobeurdeath/Desktop/untitled/prog/PJC_Projects.zip","main"));
    }

    @Test
    void searchJarByFileContent() {
        System.out.println(jarUtility.searchJarByFileContent("/Users/tobeurdeath/Desktop/untitled/prog/PJC_Projects.zip","main"));
    }
}