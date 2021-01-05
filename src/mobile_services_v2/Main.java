package mobile_services_v2;

import mobile_services_v2.models.User;
import mobile_services_v2.models.simcards.SIMBlank;
import mobile_services_v2.models.subscribers.Subscriber;
import mobile_services_v2.services.FileService;
import mobile_services_v2.services.SIMService;
import mobile_services_v2.services.SubscriberService;
import mobile_services_v2.usermanagment.MD5;
import mobile_services_v2.usermanagment.UserFileService;
import mobile_services_v2.usermanagment.UserService;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringJoiner;


public class Main {
    public static void main(String[] args) {
        User loggedInUser = null;
        Scanner scanner = new Scanner(System.in);
        do {
            {
                int choice = -1;
                System.out.println("1. Login");
                System.out.println("2. Registration");
                System.out.println("0. Exit");
                System.out.print(">>");
                String possibleChoice = scanner.next();
                if (Character.isDigit(possibleChoice.charAt(0)))
                    choice = Integer.parseInt(String.valueOf(possibleChoice.charAt(0)));

                switch (choice) {
                    case 1: {
                        String username, password;
                        do {

                            System.out.print("Username (or -1 to exit) : ");
                            username = scanner.next();
                            if (username.equals("-1")) break;
                            System.out.print("Password : ");
                            password = scanner.next();
                            loggedInUser = UserService.loginByUsernamePassword(username, MD5.getMd5(password));
                            if (loggedInUser != null) {
                                UserService.welcomeMessage(loggedInUser);
                            } else System.out.println("Wrong username and/or password");
                        } while (loggedInUser == null);

                        break;
                    }
                    case 2: {
                        User registeredUser;
                        String fullName, username, email, password;
                        do {
                            System.out.print("Full name (-1 to exit): ");
                            scanner.nextLine();
                            fullName = scanner.nextLine();
                            if (fullName.equals("-1")) break;
                            System.out.print("Username : ");
                            username = scanner.next();
                            System.out.print("Email : ");
                            email = scanner.next();
                            System.out.print("Password : ");
                            password = scanner.next();
                            registeredUser = UserService.newUserRegistration(fullName, username, email, password);
                            if (registeredUser != null) {
                                System.out.println("Congratulations! Now you can log in.");
                                StringJoiner userInfo = new StringJoiner(",");
                                userInfo.add(registeredUser.getFull_name());
                                userInfo.add(registeredUser.getUsername());
                                userInfo.add(registeredUser.getEmail());
                                userInfo.add(registeredUser.getPassword());
                                try {
                                    UserFileService.write("\n" + userInfo.toString());
                                } catch (Exception e) {
                                    System.out.println("Write operation failure.");
                                }
                            }
                        } while (registeredUser == null);
                        break;
                    }
                    case 0: {
                        System.out.println("Session is terminated");
                        return;
                    }
                    default: {
                        System.out.println("Invalid selection");
                        break;
                    }
                }

            }
        } while (loggedInUser == null);

        boolean isActive = true;
        int selection = -1;
        while (isActive) {
            System.out.println("\nActions with : ");
            System.out.println("1.Subscribers");
            System.out.println("2.SIM cards");
            System.out.println("0.Exit");
            System.out.print(">>");
            String possibleChoice = scanner.next();
            if (Character.isDigit(possibleChoice.charAt(0)))
                selection = Integer.parseInt(String.valueOf(possibleChoice.charAt(0)));
            switch (selection) {
                case 1: {
                    System.out.println("\nSubscribers");
                    System.out.println("1.Registration");
                    System.out.println("2.Search");
                    System.out.println("3.Remove");
                    System.out.println("0.Back");
                    System.out.print(">>");
                    possibleChoice = scanner.next();
                    if (Character.isDigit(possibleChoice.charAt(0)))
                        selection = Integer.parseInt(String.valueOf(possibleChoice.charAt(0)));
                    switch (selection) {
                        case 1: {
                            Subscriber subscriber = SubscriberService.subscriberRegistration();
                            System.out.println("\nDo you want to register a new subscriber with the following information?");
                            SubscriberService.showAllInfo(subscriber);
                            System.out.print("Y / N:");
                            char choice = scanner.next().charAt(0);
                            if (choice == 'Y' || choice == 'y') {
                                SubscriberService.subscriberAddition(subscriber);
                            } else {
                                System.out.println("Registration terminated!");
                                continue;
                            }
                            continue;
                        }
                        case 2: {
                            System.out.println("\nSearching");
                            System.out.print("Passport : ");
                            SubscriberService.subscriberSearch(scanner.next());
                            continue;
                        }
                        case 3: {
                            System.out.println("\nSearching");
                            System.out.print("Passport : ");
                            SubscriberService.removeSubscriber(scanner.next());
                            continue;
                        }
                        case 0: {
                            continue;

                        }
                        default: {
                            System.out.println("Invalid input\n");
                            continue;
                        }

                    }

                }

                case 2: {
                    System.out.println("\nSIM");
                    System.out.println("1.Registration");
                    System.out.println("2.View & perform transactions");
                    System.out.println("3.Search by passport");
                    System.out.println("4.SIM termination");
                    System.out.println("0.Back");
                    System.out.print(">>");
                    possibleChoice = scanner.next();
                    if (Character.isDigit(possibleChoice.charAt(0)))
                        selection = Integer.parseInt(String.valueOf(possibleChoice.charAt(0)));
                    switch (selection) {
                        case 1: {
                            System.out.println("\nSearching");
                            String passport;
                            do {
                                System.out.print("Passport (or exit): ");
                                passport = scanner.next();
                                if (passport.equals("exit")) break;
                            } while (!SubscriberService.isSubscriberFound(passport));
                            if (passport.equals("exit")) continue;
                            System.out.println();
                            SubscriberService.subscriberSearch(passport);
                            SIMBlank simBlank = SIMService.SIMregistration(passport);
                            System.out.println("\nDo you want to register a new SIM card with the following information?");
                            SIMService.showSIMinfo(simBlank);
                            System.out.print("Y / N:");
                            char choice = scanner.next().charAt(0);
                            if (choice == 'Y' || choice == 'y') {
                                try {
                                    FileService.writeSIM(simBlank);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Registration is terminated!");
                                continue;
                            }

                            System.out.println("The SIM card is registered.\n");
                            continue;
                        }
                        case 2: {
                            System.out.println("Looking for existing MSISDN");
                            System.out.print("MSISDN (8 digits): ");
                            SIMService.simSearchByMsisdn(scanner.next());
                            continue;

                        }
                        case 3: {
                            System.out.println("Looking for MSISDNs by passport");
                            System.out.print("Passport : ");
                            SIMService.simSearchByPassport(scanner.next());
                            continue;

                        }
                        case 4: {
                            System.out.println("\nTerminate SIM");
                            System.out.print("MSISDN : ");
                            SIMService.removeMSISDN(scanner.next());
                            continue;

                        }
                        case 0: {
                            continue;
                        }
                        default: {
                            System.out.println("Invalid input\n");
                            continue;
                        }
                    }
                }
                case 0: {
                    isActive = false;
                    continue;
                }
                default: {
                    System.out.println("Invalid input\n");

                }
            }

        }
    }
}
