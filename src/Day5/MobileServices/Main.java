package Day5.MobileServices;


import Day5.MobileServices.model.SIMCard.SIMInternet;
import Day5.MobileServices.model.SIMCard.SIMVoice;
import Day5.MobileServices.model.Subscriber.StandardSubscriber;
import Day5.MobileServices.model.Transaction.TransactionInternet;
import Day5.MobileServices.model.Transaction.TransactionVoice;
import Day5.MobileServices.service.SIMService;
import Day5.MobileServices.service.SubscriberRegistrationService;
import Day5.MobileServices.service.TransactionService;

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
        SIMInternet simInternet = null;
        SIMVoice simVoice = null;
        SIMService simService = new SIMService();
        switch (cardType){
            case 1:
                simInternet = simService.SIMRegistrationInternet(standardSubscriber1);
                System.out.println("\nRegistration is done!\n");
                simInternet.addBalance(1000);
                simService.showSIMinfo(simInternet);
                System.out.println("New transaction");

                System.out.print("1. Internet\nChoice : ");
                int trType = scanner.nextInt();
                TransactionService transactionService = new TransactionService();
                switch (trType){
                    case 1:
                        TransactionInternet transactionInternet1 = transactionService.NewTransaction(25.20);
                        System.out.println("New transaction is ready!");
                        transactionService.TransactionInfo(transactionInternet1);
                        transactionService.Perform(simInternet, transactionInternet1);
                        System.out.println(" Balance after transaction : " + simInternet.getBalance());
                        break;
                    default:
                        System.out.println("Invalid type");

                }
                break;
            case 2:
                simVoice = simService.SIMRegistrationVoice(standardSubscriber1);
                System.out.println("\nRegistration is done!\n");
                simVoice.addBalance(1000);
                simService.showSIMinfo(simVoice);
                System.out.println("New transaction");

                System.out.print("1. Internet\n2. Voice\nChoice : ");
                trType = scanner.nextInt();
                transactionService = new TransactionService();
                switch (trType){
                    case 1:
                        TransactionInternet transactionInternet1 = transactionService.NewTransaction(25.20);
                        System.out.println("New transaction is ready!");
                        transactionService.TransactionInfo(transactionInternet1);
                        transactionService.Perform(transactionInternet1, simVoice);
                        System.out.println(" Balance after transaction : " + simVoice.getBalance());
                        break;
                    case 2:
                        TransactionVoice transactionVoice1 = transactionService.NewTransaction(25);
                        System.out.println("New transaction is ready!");
                        transactionService.TransactionInfo(transactionVoice1);
                        transactionService.Perform(transactionVoice1, simVoice);
                        System.out.println(" Balance after transaction : " + simVoice.getBalance());
                        break;
                    default:
                        System.out.println("Invalid type");

                }
                break;
            default:
                System.out.println("Invalid type");

        }








    }
}

