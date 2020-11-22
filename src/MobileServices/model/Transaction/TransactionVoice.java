package MobileServices.model.Transaction;


public class TransactionVoice extends TransactionBlank {
    private int durationSec;

    public TransactionVoice(int durationSec) {
        super( (double)durationSec/60*15);
        setDurationSec(durationSec);
    }

    public int getDurationSec() {
        return durationSec;
    }

    public void setDurationSec(int durationSec) {
        if (durationSec>0)
        this.durationSec = durationSec;
    }

    public void showInfoAll(){
        System.out.println("Voice transaction");
        System.out.println("Duration: " + getDurationSec()+"sec");
        System.out.println("Price per min:" + 15);
        System.out.println("Amount: " + getAmount());
    }
}
