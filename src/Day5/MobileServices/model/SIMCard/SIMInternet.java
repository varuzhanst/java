package Day5.MobileServices.model.SIMCard;

import Day5.MobileServices.model.Subscriber.StandardSubscriber;

public class SIMInternet extends SIMBlank{
    public int getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }
    public void consBalance(double amount) {
        if (amount>=balance)
        this.balance -= amount;
        else System.out.println("Insufficient money");
    }

    private int balance=0;

    public SIMInternet(String iccid, String msisdn, StandardSubscriber standardSubscriber) {
        super(iccid+"1", msisdn,standardSubscriber);
    }

    @Override
    public void showSIMInfo() {

        super.showSIMInfo();
        System.out.println("SIM type: Internet");
        System.out.println("Balance : "+getBalance());
    }
}
