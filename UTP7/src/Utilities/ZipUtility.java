package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtility {

    private ZipFile zipFile;

    public List<ZipEntry> searchZip(String filePath, String searchParam) {

        Predicate<ZipEntry> hasName = zipEntry -> zipEntry.getName().contains(searchParam);

        List<ZipEntry> result =  new ArrayList<>();
        try {

            zipFile = new ZipFile(filePath);

             result = zipFile.stream()
                     .sequential()          //parallel()
                     .filter(hasName)
                     .collect(Collectors.toList());
        }catch (IOException e){
            System.out.println("Error opening archive. Check the provided path or file accessibility");
        }finally {
            try {
                zipFile.close();
            }catch (IOException e){
                System.out.println("Error closing an archive.");
            }
        }
        return result;
    }

    public List<ZipEntry> searchZipByFileContent(String filePath, String searchParam) {

        List<ZipEntry> result =  new ArrayList<>();

        try {

            zipFile = new ZipFile(filePath);

            result = zipFile.stream()
                    .parallel()          //sequential()
                    .filter(zipEntry -> {
                        String found = null;
                        if (zipEntry.isDirectory())
                            return false;
                        try {
                            InputStream is = zipFile.getInputStream(zipEntry);
                            Scanner scanner = new Scanner(is);
                            found = scanner.findWithinHorizon(searchParam, (int) zipEntry.getSize());
                        } catch (IOException e) {
                            System.out.println("Couldn't get an input stream.");
                        }
                        return found != null;
                    })
                    .collect(Collectors.toList());
        }catch (IOException e){
            System.out.println("Error opening archive. Check the provided path or file accessibility");
        }finally {
            try {
                zipFile.close();
            }catch (IOException e){
                System.out.println("Error closing an archive.");
            }
        }
        return result;
    }
}
