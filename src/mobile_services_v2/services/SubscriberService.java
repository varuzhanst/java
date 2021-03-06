package mobile_services_v2.services;

import mobile_services_v2.models.subscribers.PremierSubscriber;
import mobile_services_v2.models.subscribers.StandardSubscriber;
import mobile_services_v2.models.subscribers.Subscriber;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SubscriberService {
    /**
     * returning a new Subscriber based on User input
     * @return
     */
    public static Subscriber subscriberRegistration() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name : ");
        String firstName = scanner.next();
        System.out.print("Last Name : ");
        String lastName = scanner.next();
        System.out.print("Middle Name : ");
        String middleName = scanner.next();
        System.out.print("Male or Female? / M or F : ");
        char gender = scanner.next().charAt(0);
        System.out.print("Date of birth (DD.MM.YYYY) : ");
        String dob_plain = scanner.next();
        System.out.print("Passport : ");
        String passport = scanner.next();
        System.out.print("Standard or premier? / S or P : ");
        char type = scanner.next().charAt(0);
        if (type == 'P' || type == 'p') {
            return new PremierSubscriber(firstName, lastName, middleName, dob_plain, passport, gender);
        } else return new StandardSubscriber(firstName, lastName, middleName, dob_plain, passport, gender);

    }

    /**
     * Extracting subscriber and writing in the file
     * @param subscriber
     */
    public static void subscriberAddition(Subscriber subscriber) {
        try {
            FileService.writeSubscriber(subscriber);
            System.out.println("The subscriber is registered.\n");
        } catch (IOException e) {
            System.out.println("Error -> File not found");
        }
    }

    /**
     * Looking for a subscriber by passport and showing information if one is found
     * @param passport
     */
    public static void subscriberSearch(String passport) {
        List<String> allSubscribers;
        try {
            boolean isFound = false;
            allSubscribers = FileService.readSubscribersAll();
            for (int i = 0; i < allSubscribers.size(); i++) {
                String[] subscriber = allSubscribers.get(i).split(",");
                if (subscriber[5].equals(passport)) {
                    System.out.println("\nSubscriber found!\n");
                    showAllInfo(getSubscriberFromText(allSubscribers.get(i)));
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("No subscriber found! Passport = " + passport);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * removing subscriber from a file if no SIM is registered under the passport
     * @param passport
     */
    public static void removeSubscriber(String passport) {
        List<String> allSubscribers;
        if (SIMService.isSIMFound(passport)) {
            System.out.println("Existing SIM found. Can't perform the action!");
            return;
        }
        try {
            boolean isFound = false;
            allSubscribers = FileService.readSubscribersAll();
            for (int i = 0; i < allSubscribers.size(); i++) {
                String[] subscriber = allSubscribers.get(i).split(",");
                if (subscriber[5].equals(passport)) {
                    isFound = true;
                    System.out.println("\nSubscriber found!\n");
                    showAllInfo(getSubscriberFromText(allSubscribers.get(i)));
                    System.out.println("\nDo you want to remove the subscriber?");
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Y / N:");
                    char choice = scanner.next().charAt(0);
                    if (choice == 'Y' || choice == 'y') {
                        FileService.clearSubscribers();
                        for (int j = 0; j < allSubscribers.size(); j++) {
                            subscriber = allSubscribers.get(j).split(",");
                            if (!subscriber[5].equals(passport)) {
                                FileService.writeSubscriber(getSubscriberFromText(allSubscribers.get(j)));
                            }
                        }
                    } else {
                        System.out.println("Action is terminated!");
                        continue;
                    }
                    break;
                }
            }
            if (!isFound) {
                System.out.println("No subscriber found! Passport = " + passport);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * extracting subscriber and showing information
     * @param subscriber
     */
    public static void showAllInfo(Subscriber subscriber) {
        System.out.println("==========================");
        System.out.println("First name : " + subscriber.getFirstName());
        System.out.println("Last name : " + subscriber.getLastName());
        System.out.println("Middle name : " + subscriber.getMiddleName());
        System.out.println("Birthday : " + subscriber.getBirthday());
        System.out.println("Gender : " + subscriber.getGender());
        System.out.println("Passport : " + subscriber.getPassport());
        System.out.print("Subscriber type : " );
        if(subscriber instanceof StandardSubscriber) System.out.println("Standard");
        else if(subscriber instanceof PremierSubscriber)  System.out.println("Premier");
        System.out.println("==========================");
    }

    /**
     * returning a new subscriber based on provided String
     * @param subscriber
     * @return
     */
    private static Subscriber getSubscriberFromText(String subscriber) {
        String[] subscriber_split = subscriber.split(",");
        if (subscriber_split[6].equals("Premier"))
            return new PremierSubscriber(subscriber_split[0], subscriber_split[1], subscriber_split[2], subscriber_split[3], subscriber_split[5], subscriber_split[4].charAt(0));
        else
            return new StandardSubscriber(subscriber_split[0], subscriber_split[1], subscriber_split[2], subscriber_split[3], subscriber_split[5], subscriber_split[4].charAt(0));
    }

    /**
     * looking for a subscriber and returning true in case one id found
     * @param passport
     * @return
     */
    public static boolean isSubscriberFound(String passport) {
        List<String> allSubscribers;
        try {
            allSubscribers = FileService.readSubscribersAll();
            for (int i = 0; i < allSubscribers.size(); i++) {
                String[] subscriber = allSubscribers.get(i).split(",");
                if (subscriber[5].equals(passport)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("No subscriber found! Passport = " + passport);
        return false;

    }

    /**
     * Getting first and last name by provided passport
     * @param passport
     * @return
     */
    public static String getNameByPassport(String passport) {
        List<String> allSubscribers;
        try {
            allSubscribers = FileService.readSubscribersAll();
            for (int i = 0; i < allSubscribers.size(); i++) {
                String[] subscriber = allSubscribers.get(i).split(",");
                if (subscriber[5].equals(passport)) {
                    return subscriber[0] + " " + subscriber[1];
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "undefined";
    }
}
