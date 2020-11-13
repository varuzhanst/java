package Exam.Airport.Model;

public class Plane {
    private String model;
    private String country;
    private int year;
    private int hours;
    private boolean isMilitary;
    private int weight;
    private int wingspan;
    private int topSpeed;
    private int seats;
    private double cost;

    public String getModel() {

        return model;
    }

    public void setModel(String model) {
        if (model.length() > 0) {
            this.model = model;
        }

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.length() > 0)
            this.country = country;
    }


    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        if (year >= 1903 && year <= 2020)
            this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours <= 10000)
            this.hours = hours;
    }

    public boolean isMilitary() {
        return isMilitary;
    }

    public void setMilitary(boolean military) {
        isMilitary = military;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight >= 1000 && weight <= 160000)
            this.weight = weight;
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        if (wingspan >= 10 && wingspan <= 45)
            this.wingspan = wingspan;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        if (topSpeed > 0)
            this.topSpeed = topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats > 0)
            this.seats = seats;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost > 0)
            this.cost = cost;
    }
}
