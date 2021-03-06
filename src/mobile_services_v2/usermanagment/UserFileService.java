package mobile_services_v2.usermanagment;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class UserFileService {
    public static final Path PATH = Paths.get("src/mobile_services_v2/Database.txt");

    /**
     * reading all lines from the file
     * @return
     * @throws Exception
     */
    public static ArrayList<String> readAll() throws Exception {
        return (ArrayList<String>)Files.readAllLines(PATH);
    }

    /**
     * writing a String in the file
     * @param s
     * @throws Exception
     */
    public static void write(String s) throws Exception{
        Files.write(PATH,s.getBytes(), StandardOpenOption.APPEND);
    }
}
