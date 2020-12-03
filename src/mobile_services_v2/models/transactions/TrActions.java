package mobile_services_v2.models.transactions;

public interface TrActions {
    void deposit(double amount, String MSISDN) throws Exception;
    void useBalance(double duration, String MSISDN ) throws Exception;
}
