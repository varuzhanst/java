package mobile_services_v2.services;

import mobile_services_v2.models.simcards.SIMBlank;
import mobile_services_v2.models.simcards.SIMInternet;
import mobile_services_v2.models.subscribers.StandardSubscriber;
import mobile_services_v2.models.subscribers.Subscriber;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {
    public static final String SUBSCRIBERS_PATH = "src/mobile_services_v2/Subscribers.txt";
    public static final String SIM_PATH = "src/mobile_services_v2/SimCards.txt";

    public static void writeSubscriber(Subscriber subscriber) throws IOException {
        String allInfo= subscriber.getFirstName() + ","
                + subscriber.getLastName() + ","
                + subscriber.getMiddleName() + ","
                + subscriber.getBirthday()+","
                + subscriber.getGender() + ","
                + subscriber.getPassport();
        if (subscriber instanceof StandardSubscriber)
            allInfo += ",Standard\n";
        else allInfo += ",Premier\n";
        Files.write(Paths.get(SUBSCRIBERS_PATH),allInfo.getBytes(), StandardOpenOption.APPEND);

    }

    public static List<String>  readSubscribersAll() throws IOException {
        return Files.readAllLines(Paths.get(SUBSCRIBERS_PATH));
    }
    public static void clearSubscribers() throws IOException {
        String allInfo="";
        Files.write(Paths.get(SUBSCRIBERS_PATH),allInfo.getBytes());

    }
    public static void writeSIM(SIMBlank simBlank) throws IOException {
        String allInfo= simBlank.getIccid() + ","
                + simBlank.getMsisdn()+","
                + simBlank.getHolderPassport()+","
                + simBlank.getBalance();
        if (simBlank instanceof SIMInternet)
            allInfo += ",Internet\n";
        else allInfo += ",Voice\n";
        Files.write(Paths.get(SIM_PATH),allInfo.getBytes(), StandardOpenOption.APPEND);

    }
    public static List<String> readSIMsAll() throws IOException {
        return Files.readAllLines(Paths.get(SIM_PATH));
    }
    public static void clearSIMs() throws IOException {
        String allInfo="";
        Files.write(Paths.get(SIM_PATH),allInfo.getBytes());

    }

}
