package Day5.MobileServices.model.Transaction;

public class TransactionInternet extends TransactionBlank {
    private double volumeMB;



    public double getVolumeMB() {
        return volumeMB;
    }

    public void setVolumeMB(double volumeMB) {
        if(volumeMB>0)
        this.volumeMB = volumeMB;
    }

    public TransactionInternet(double MB) {
        super(MB*15);
        setVolumeMB(MB);
    }

    public void showInfoAll(){
        System.out.println("Internet transaction");
        System.out.println("Volume: " + getVolumeMB()+"MB");
        System.out.println("Price per MB:" + 15);
        System.out.println("Amount: " + getAmount());
    }


}
