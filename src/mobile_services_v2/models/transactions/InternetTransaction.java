package mobile_services_v2.models.transactions;

public class InternetTransaction extends Transaction {


    @Override
    public void useBalance(double duration, String MSISDN) throws Exception {
        deposit(-duration * 15 / 1024, MSISDN);
    }
}
