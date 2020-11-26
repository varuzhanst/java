package Day6.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    public static String[] readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }
}
