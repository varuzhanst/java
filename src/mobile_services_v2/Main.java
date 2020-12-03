package mobile_services_v2;

import mobile_services_v2.models.simcards.SIMBlank;
import mobile_services_v2.models.subscribers.Subscriber;
import mobile_services_v2.services.FileService;
import mobile_services_v2.services.SIMService;
import mobile_services_v2.services.SubscriberService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isActive = true;
        int selection;
        Scanner scanner = new Scanner(System.in);
        while (isActive) {
            System.out.println("\nActions with : ");
            System.out.println("1.Subscribers");
            System.out.println("2.SIM cards");
            System.out.println("0.Exit");
            System.out.print("Choice:");

            selection = scanner.nextInt();
            switch (selection) {
                case 1: {
                    System.out.println("\nSubscribers");
                    System.out.println("1.Registration");
                    System.out.println("2.Search");
                    System.out.println("3.Remove");
                    System.out.println("0.Back");
                    System.out.print("Choice:");
                    selection = scanner.nextInt();
                    switch (selection) {
                        case 1: {
                            Subscriber subscriber = SubscriberService.subscriberRegisteration();
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

                            System.out.println("The subscriber is registered.\n");
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
                    System.out.print("Choice:");
                    selection = scanner.nextInt();
                    switch (selection) {
                        case 1: {
                            System.out.println("\nSearching");
                            String passport;
                            do {System.out.print("Passport (or exit): ");
                               passport = scanner.next();
                               if (passport.equals("exit")) break;
                            }while(!SubscriberService.isSubscriberFound(passport));
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
                                System.out.println("Registration terminated!");
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
                            System.out.println("Terminate SIM");
                            System.out.print("MSISDN : ");
                            SIMService.removeSubscriber(scanner.next());
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
                    continue;
                }
            }

        }
    }
}
