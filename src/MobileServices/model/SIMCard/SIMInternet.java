package MobileServices.model.SIMCard;

import MobileServices.model.Subscriber.StandardSubscriber;

public class SIMInternet extends SIMBlank{

    public SIMInternet(String iccid, String msisdn, StandardSubscriber standardSubscriber) {
        super(iccid+"1", msisdn,standardSubscriber);
    }

    @Override
    public void showSIMInfo() {

        super.showSIMInfo();
        System.out.println("SIM type: Internet");
    }
}
