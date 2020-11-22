package MobileServices.model.SIMCard;

import MobileServices.model.Subscriber.StandardSubscriber;

public class SIMVoice extends SIMBlank{
    public SIMVoice(String iccid, String msisdn, StandardSubscriber standardSubscriber) {
        super(iccid+"2", msisdn, standardSubscriber);
    }
    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }
    public void consBalance(double amount) {
        if (amount<=balance)
            this.balance -= amount;
        else System.out.println("Insufficient money");
    }

    private double balance=0;
    @Override
    public void showSIMInfo() {

        super.showSIMInfo();
        System.out.println("SIM type: Voice");
        System.out.println("Balance : "+getBalance());
    }
}
