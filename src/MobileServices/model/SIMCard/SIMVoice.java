package MobileServices.model.SIMCard;

import MobileServices.model.Subscriber.StandardSubscriber;

public class SIMVoice extends SIMBlank{
    public SIMVoice(String iccid, String msisdn, StandardSubscriber standardSubscriber) {
        super(iccid+"2", msisdn, standardSubscriber);
    }

    @Override
    public void showSIMInfo() {

        super.showSIMInfo();
        System.out.println("SIM type: Voice");
    }
}
