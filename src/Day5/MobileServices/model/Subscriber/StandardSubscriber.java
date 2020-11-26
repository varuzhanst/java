package Day5.MobileServices.model.Subscriber;

public class StandardSubscriber extends Subscriber {
    String subs_id;

    public String getSubs_id() {
        return subs_id;
    }

    public void setSubs_id() {
        this.subs_id = super.getBday_year()+super.getPassport().substring(2);
    }

    public StandardSubscriber(String firstname, String lastname, String passport, int bday_day, int bday_month, int bday_year, String reg_address, int contact_num) {
        super(firstname, lastname, passport, bday_day, bday_month, bday_year, reg_address, contact_num);
        setSubs_id();
    }

    @Override
    public void showCustomerInfo() {
        System.out.println("ID : " + getSubs_id());
        super.showCustomerInfo();
    }
}
