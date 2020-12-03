package mobile_services_v2.models.transactions;

import mobile_services_v2.services.SIMService;

public abstract class Transaction implements TrActions{
    @Override
    public void deposit(double amount, String MSISDN) throws Exception {
        SIMService.changeBalanceByMsisdn(MSISDN,amount);
    }
}
