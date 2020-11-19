package MobileServices;


import MobileServices.model.SIMCard.SIMInternet;
import MobileServices.model.SIMCard.SIMVoice;
import MobileServices.model.Subscriber.StandardSubscriber;
import MobileServices.service.SIMService;
import MobileServices.service.SubscriberRegistrationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to MOBILE SERVICES registration form\n*****");
        System.out.println("Subscriber registration");
        SubscriberRegistrationService subscriberRegistrationService = new SubscriberRegistrationService();
        StandardSubscriber standardSubscriber1 = subscriberRegistrationService.new_standard_subscriber();
        System.out.println("\n*****\nSIM registration");
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Internet SIM\n2. Voice SIM\nChoice : ");
        int cardType = scanner.nextInt();
        SIMService simService = new SIMService();
        switch (cardType){
            case 1:
                SIMInternet simInternet = simService.SIMRegistrationInternet(standardSubscriber1);
                System.out.println("\nRegistration is done!\n");
                simService.showSIMinfo(simInternet);
                break;
            case 2:
                SIMVoice simVoice = simService.SIMRegistrationVoice(standardSubscriber1);
                System.out.println("\nRegistration is done!\n");
                simService.showSIMinfo(simVoice);
                break;
            default:
                System.out.println("Invalid type");

        }




    }
}

