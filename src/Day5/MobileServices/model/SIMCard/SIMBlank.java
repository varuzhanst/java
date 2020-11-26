package Day5.MobileServices.model.SIMCard;

import Day5.MobileServices.model.Subscriber.StandardSubscriber;

public class SIMBlank {
    private String iccid = "37410";
    private String imsi = "28311";
    private String msisdn = "88000000_undefined";

    public StandardSubscriber getSubscriber() {
        return subscriber;
    }

    private StandardSubscriber subscriber;

    public SIMBlank(String iccid, String msisdn, StandardSubscriber standardSubscriber) {
        setIccid(iccid);
        setImsi();
        setMsisdn(msisdn);
        this.subscriber = standardSubscriber;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        if (iccid.length() == 6)
            this.iccid = this.iccid + iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi() {
        this.imsi = imsi + getIccid();
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        if (msisdn.length() == 8)
            this.msisdn = msisdn;
    }

    public void showSIMInfo() {
        System.out.println("*****\nCustomer info\n*****");
        subscriber.showCustomerInfo();
        System.out.println("*****\nSIM info\n*****");
        System.out.println("ICCID : " + getIccid());
        System.out.println("IMSI : " + getImsi());
        System.out.println("MSISDN : " + getMsisdn());

    }

}
