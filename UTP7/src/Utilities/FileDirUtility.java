package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileDirUtility {

     public  List<File> searchDir(String dirPath, String searchParam) throws IOException {
         File dir = new File(dirPath);
        if (!dir.isDirectory())
            return null;
        Path startPath = dir.toPath();
        return Files.find(startPath, 1000,
                (path, basicFileAttributes) -> {
            File file = path.toFile();
            return !file.isDirectory() &&
                   file.getName().matches(searchParam+".*");
        })
                .parallel() //.sequential()
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

    public  List<File> searchDirByFileContent(String dirPath, String searchParam) throws IOException{
         File dir = new File(dirPath);
        if (!dir.isDirectory())
            return null;
        Path startPath = dir.toPath();
        return Files.find(startPath, 1000, (path, basicFileAttributes) -> {
            File file = path.toFile();
            return !file.isDirectory() &&
                    hasContent(file,searchParam);
        })
                .parallel() //.sequential()
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

     private static boolean hasContent(File file, String content) {
        try {
            Scanner scanner = new Scanner(file);
            String result = scanner.findWithinHorizon(content, (int) file.length());
            return result != null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
