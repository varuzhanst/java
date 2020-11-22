package MobileServices.service;

import MobileServices.model.SIMCard.SIMInternet;
import MobileServices.model.SIMCard.SIMVoice;
import MobileServices.model.Transaction.TransactionController;
import MobileServices.model.Transaction.TransactionInternet;
import MobileServices.model.Transaction.TransactionVoice;

public class TransactionService {
    TransactionController transactionController = new TransactionController();

    public TransactionInternet NewTransaction(double MB){
       return new TransactionInternet(MB);
    }

    public TransactionVoice NewTransaction(int duration){
        return new TransactionVoice(duration);
    }

    public void Perform(SIMInternet simInternet,TransactionInternet transactionInternet){
            transactionController.charge(simInternet, transactionInternet);
    }

    public void Perform(TransactionVoice transactionVoice, SIMVoice simVoice){
            transactionController.charge(simVoice,transactionVoice);
    }

    public void Perform(TransactionInternet transactionInternet, SIMVoice simVoice){
        transactionController.charge(simVoice,transactionInternet);
    }

    public void Perform(int amount, SIMVoice simVoice){
        transactionController.deposit(simVoice, amount);
    }
    public void Perform(int amount, SIMInternet simInternet){
        transactionController.deposit(simInternet, amount);
    }

    public void TransactionInfo(TransactionVoice transactionVoice){
        transactionVoice.showInfoAll();
    }

    public void TransactionInfo(TransactionInternet transactionInternet){
        transactionInternet.showInfoAll();
    }


}
