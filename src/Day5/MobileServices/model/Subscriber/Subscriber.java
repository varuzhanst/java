package Day5.MobileServices.model.Subscriber;

public class Subscriber {
    private String firstname = "undefined";
    private String lastname = "undefined";
    private String passport = "ZZ0000000_undefined";
    private int bday_day = 1;
    private int bday_month = 1;
    private int bday_year = 1901;
    private String reg_address = "undefined";
    private String contact_num = "undefined";

    public Subscriber(String firstname, String lastname, String passport, int bday_day, int bday_month, int bday_year, String reg_address, int contact_num) {
        setBday_day(bday_day);
        setBday_month(bday_month);
        setBday_year(bday_year);
        setContact_num(contact_num);
        setFirstname(firstname);
        setLastname(lastname);
        setPassport(passport);
        setReg_address(reg_address);
    }

    public String getContact_num() {
        return contact_num;
    }

    public void setContact_num(int contact_num) {
        if (contact_num > 10000000 && contact_num <= 99999999)
            this.contact_num = contact_num + "";
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (firstname.length() > 0)
            this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if (lastname.length() > 0)
            this.lastname = lastname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        if (passport.length() > 8)
            this.passport = passport;
    }

    public int getBday_day() {

        return bday_day;
    }

    public void setBday_day(int bday_day) {
        if (bday_day > 0 && bday_day < 31)
            this.bday_day = bday_day;
    }

    public int getBday_month() {
        return bday_month;
    }

    public void setBday_month(int bday_month) {
        if (bday_month > 0 && bday_month < 13)
            this.bday_month = bday_month;
    }

    public int getBday_year() {
        return bday_year;
    }

    public void setBday_year(int bday_year) {
        if (bday_year > 1900 && bday_year <= 2020)
            this.bday_year = bday_year;
    }

    public String getReg_address() {
        return reg_address;
    }

    public void setReg_address(String reg_address) {
        if (reg_address.length() > 0)
            this.reg_address = reg_address;
    }

    public void showCustomerInfo() {
        System.out.println("Full name : " + getFirstname() + " " + getLastname());
        System.out.println("Passport : " + getPassport());
        System.out.printf("Birthday : %d.%d.%d\n", getBday_day(), getBday_month(), getBday_year());
        System.out.println("Contact number : " + getContact_num());
        System.out.println("Registration Address : " + getReg_address());

    }
}
