package mobile_services_v2.usermanagment;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class UserFileService {
    public static final Path PATH = Paths.get("D:\\IDEA projects\\Picsart\\src\\mobile_services_v2\\database.txt");

    public static ArrayList<String> readAll() throws Exception {
        return (ArrayList<String>)Files.readAllLines(PATH);
    }

    public static void write(String s) throws Exception{
        Files.write(PATH,s.getBytes(), StandardOpenOption.APPEND);
    }
}
