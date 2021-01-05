package mobile_services_v2.models.transactions;

public class InternetTransaction extends Transaction {

    /**
     * The Internet transaction is performed with price 15 AMD/MB
     * @param duration
     * @param MSISDN
     * @throws Exception
     */
    @Override
    public void useBalance(double duration, String MSISDN) throws Exception {
        deposit(-duration * 15 / 1024, MSISDN);
    }
}
