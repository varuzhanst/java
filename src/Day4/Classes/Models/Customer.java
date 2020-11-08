package Day4.Classes.Models;

public class Customer {
    private long SSN;
    private String name;
    private String surname;
    private int b_day;
    private int b_month;
    private int b_year;

    public long getSSN() {
        return SSN;
    }

    public void setSSN(long SSN) {
        if (SSN > 1000000000L && SSN < 9999999999L) {
            this.SSN = SSN;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getB_day() {
        return b_day;
    }

    public void setB_day(int b_day) {
        if (b_day > 0 && b_day < 32) {
            this.b_day = b_day;
        }
    }

    public int getB_month() {
        return b_month;
    }

    public void setB_month(int b_month) {
        if (b_month > 0 && b_month < 13) {
            this.b_month = b_month;
        }
    }

    public int getB_year() {
        return b_year;
    }

    public void setB_year(int b_year) {
        if (b_year > 1900 && b_year < 2021) {
            this.b_year = b_year;
        }

    }

    public String getBday(){
      return this.getB_day() + "." + this.getB_month() + "." + this.getB_year();
    }
}
