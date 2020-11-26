package Day5.MobileServices.model.Transaction;

import Day5.MobileServices.model.SIMCard.SIMInternet;
import Day5.MobileServices.model.SIMCard.SIMVoice;

public interface Transactions {
    void charge(SIMInternet simInternet, TransactionInternet transactionInternet);
    void charge(SIMVoice simVoice, TransactionVoice transactionVoice);
    void charge(SIMVoice simVoice, TransactionInternet transactionInternet);
    void deposit(SIMInternet simInternet,int amount);
    void deposit(SIMVoice simVoice,int amount);

}
