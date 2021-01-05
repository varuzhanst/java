package mobile_services_v2.models.transactions;

public class VoiceTransaction extends Transaction{
    /**
     * The Voice  transaction is performed with price 25 AMD/min
     * @param duration
     * @param MSISDN
     * @throws Exception
     */
    @Override
    public void useBalance(double duration, String MSISDN) throws Exception {
        deposit(-duration * 25 / 60, MSISDN);
    }
}
