package MobileServices.service;



import MobileServices.model.Subscriber.StandardSubscriber;

import java.util.Scanner;

public class SubscriberRegistrationService {
    public StandardSubscriber new_standard_subscriber() {
        String firstname;
        String lastname;
        String passport;
        int bday_day;
        int bday_month;
        int bday_year;
        String reg_address;
        int contact_num;

        Scanner scanner = new Scanner(System.in);
        System.out.print("First name : ");
        firstname = scanner.next();
        System.out.print("Last name : ");
        lastname = scanner.next();
        System.out.print("Passport (LL1234567) : ");
        passport = scanner.next();
        System.out.print("Birthday year : ");
        bday_year = scanner.nextInt();
        System.out.print("Birthday month : ");
        bday_month = scanner.nextInt();
        System.out.print("Birthday day : ");
        bday_day = scanner.nextInt();
        System.out.print("Contact number (YYXXXXXX) : ");
        contact_num = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Registration address : ");
        reg_address = scanner.nextLine();

        return new StandardSubscriber(firstname, lastname, passport, bday_day, bday_month, bday_year, reg_address, contact_num);


    }



}
