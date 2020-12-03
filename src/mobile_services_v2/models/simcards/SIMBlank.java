package mobile_services_v2.models.simcards;

public abstract class SIMBlank {
    private String msisdn;
    private String iccid;
    private String holderPassport;
    private double balance;

    public SIMBlank(String msisdn, String iccid, String holderPassport, double balance) {
        setBalance(balance);
        setIccid(iccid);
        setMsisdn(msisdn);
        setHolderPassport(holderPassport);
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        if(msisdn.length()==8)
        this.msisdn = msisdn;
        else this.iccid="undefined";
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        if (iccid.length()> 10) this.iccid = iccid;
        else this.iccid = "undefined";
    }

    public String getHolderPassport() {
        return holderPassport;
    }

    public void setHolderPassport(String holderPassports) {
        this.holderPassport = holderPassports;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
