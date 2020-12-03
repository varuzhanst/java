package mobile_services_v2.models.transactions;

public class VoiceTransaction extends Transaction{

    @Override
    public void useBalance(double duration, String MSISDN) throws Exception {
        deposit(-duration * 25 / 60, MSISDN);
    }
}
