package Day4.Classes.Models;

public class Transaction {
    private char transactionDirection;
    private int transactionAmount;

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionDirection(char transactionDirection) {
        this.transactionDirection = transactionDirection;
    }

    public char getTransactionDirection() {
        return transactionDirection;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }
}
