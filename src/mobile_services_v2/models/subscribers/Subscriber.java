package mobile_services_v2.models.subscribers;

public abstract class Subscriber {

    private char gender;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthday;
    private String passport;


    public Subscriber(String firstName, String lastName, String middleName, String birthday, String passport, char gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
        setGender(gender);
        setBirthday(birthday);
        setPassport(passport);

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length()>0)
        this.firstName = firstName;
        else  this.firstName ="undefined";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length()>0)
            this.lastName = lastName;
        else  this.lastName ="undefined";

    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        if(middleName.length()>0)
            this.middleName = middleName;
        else  this.middleName ="undefined";

    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if(birthday.length()==10)
            this.birthday = birthday;
        else  this.birthday ="undefined";

    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        if(passport.length()==9)
            this.passport = passport;
        else  this.passport ="undefined";
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {

        if(gender=='m'||gender=='f'||gender=='M'||gender=='F')
            this.gender = gender;
        else  this.gender ='*';
    }
}
