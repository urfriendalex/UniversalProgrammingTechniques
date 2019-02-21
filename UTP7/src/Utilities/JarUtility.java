package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;


public class JarUtility {

    private JarFile jarFile;

    public List<JarEntry> searchJar(String filePath, String searchParam) {

        Predicate<JarEntry> hasName = zipEntry -> zipEntry.getName().contains(searchParam);

        List<JarEntry> result =  new ArrayList<>();
        try {

            jarFile = new JarFile(filePath);

            result = jarFile.stream()
                    .sequential()          //parallel()
                    .filter(hasName)
                    .collect(Collectors.toList());
        }catch (IOException e){
            System.out.println("Error opening archive. Check the provided path or file accessibility");
        }finally {
            try {
                jarFile.close();
            }catch (IOException e){
                System.out.println("Error closing an archive.");
            }
        }
        return result;
    }

    public List<JarEntry> searchJarByFileContent(String filePath, String searchParam) {

        List<JarEntry> result =  new ArrayList<>();

        try {

            jarFile = new JarFile(filePath);

            result = jarFile.stream()
                    .parallel()          //sequential()
                    .filter(jarEntry -> {
                        String found = null;
                        if (jarEntry.isDirectory())
                            return false;
                        try {
                            InputStream is = jarFile.getInputStream(jarEntry);
                            Scanner scanner = new Scanner(is);
                            found = scanner.findWithinHorizon(searchParam, (int) jarEntry.getSize());
                        } catch (IOException e) {
                            System.out.println("Cannot get an input stream.");
                        }
                        return found != null;
                    })
                    .collect(Collectors.toList());
        }catch (IOException e){
            System.out.println("Error opening archive. Check the provided path or file accessibility");
        }finally {
            try {
                jarFile.close();
            }catch (IOException e){
                System.out.println("Error closing an archive.");
            }
        }
        return result;
    }
}

