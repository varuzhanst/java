package MobileServices.model.Transaction;

import Day4.Classes.Models.Transaction;
import MobileServices.model.SIMCard.SIMInternet;
import MobileServices.model.SIMCard.SIMVoice;

public class TransactionController implements Transactions {


    @Override
    public void charge(SIMInternet simInternet, TransactionInternet transactionInternet) {
        simInternet.consBalance(transactionInternet.getAmount());
    }

    @Override
    public void charge(SIMVoice simVoice, TransactionVoice transactionVoice) {
        simVoice.consBalance(transactionVoice.getAmount());
    }

    @Override
    public void charge(SIMVoice simVoice, TransactionInternet transactionInternet) {
        simVoice.consBalance(transactionInternet.getAmount());
    }

    @Override
    public void deposit(SIMInternet simInternet, int amount) {
        simInternet.addBalance(amount);
    }

    @Override
    public void deposit(SIMVoice simVoice, int amount) {
        simVoice.addBalance(amount);
    }
}
