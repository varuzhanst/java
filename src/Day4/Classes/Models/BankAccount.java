package Day4.Classes.Models;

public class BankAccount {
    private int Balance = 0;
    private char currency;
    private int accNumber;
    private long SSN;

    public int getBalance() {
        return Balance;
    }

    public void addBalance(int balance) {
        this.Balance += balance;
    }

    public void useBalance(int balance) {
        if (this.Balance > balance) {
            this.Balance -= balance;
        }
        else System.out.println("Insufficient balance for transaction. Amount = " + balance + " Balance = " + this.getBalance());
    }

    public char getCurrency() {
        return currency;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public long getSSN() {
        return SSN;
    }

    public void setSSN(long SSN) {
        this.SSN = SSN;
    }
}
