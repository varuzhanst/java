package MobileServices.service;

import MobileServices.model.SIMCard.SIMInternet;
import MobileServices.model.SIMCard.SIMVoice;
import MobileServices.model.Subscriber.StandardSubscriber;

import java.util.Scanner;

public class SIMService {
    public SIMVoice SIMRegistrationVoice(StandardSubscriber standardSubscriber) {
        String iccid;
        String msisdn;
        Scanner scanner = new Scanner(System.in);
        System.out.print("ICCID (xxxxx) : ");
        iccid = scanner.next();
        System.out.print("MSISDN (XXyyyyyy) : ");
        msisdn = scanner.next();
        return new SIMVoice(iccid, msisdn, standardSubscriber);
    }

    public SIMInternet SIMRegistrationInternet(StandardSubscriber standardSubscriber) {
        String iccid;
        String msisdn;
        Scanner scanner = new Scanner(System.in);
        System.out.print("ICCID (xxxxx) : ");
        iccid = scanner.next();
        System.out.print("MSISDN (XXyyyyyy) : ");
        msisdn = scanner.next();
        return new SIMInternet(iccid, msisdn, standardSubscriber);
    }


    public void showSIMinfo(SIMInternet SIM) {
      SIM.showSIMInfo();

    }

    public void showSIMinfo(SIMVoice SIM) {
        SIM.showSIMInfo();
    }
}
