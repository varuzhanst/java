package Day4.Classes;

import Day4.Classes.Models.BankAccount;
import Day4.Classes.Models.Customer;
import Day4.Classes.Models.Transaction;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer();
        customer1.setName("Justin");
        customer1.setSurname("Smith");
        customer1.setSSN(1411990101);
        customer1.setB_day(11);
        customer1.setB_month(2);
        customer1.setB_year(1999);
        BankAccount bankAccount_AMD_profile = new BankAccount();
        bankAccount_AMD_profile.setAccNumber(1450000100);
        bankAccount_AMD_profile.setSSN(customer1.getSSN());
        bankAccount_AMD_profile.setCurrency('A');
        System.out.println("Hello, " + customer1.getName() + " " + customer1.getSurname());
        System.out.println("Birthday : " + customer1.getBday());
        System.out.println("SSN : " + customer1.getSSN());
        System.out.println("Main account N " + bankAccount_AMD_profile.getAccNumber());
        System.out.println();
        for(int i = 0;i<5;i++){
            bankAccount_AMD_profile.addBalance(i*100);
            System.out.println("+"+i*100+" >> Balance =" + bankAccount_AMD_profile.getBalance());
        }
        System.out.println();
        for (int i=0;i<5;i++){
            bankAccount_AMD_profile.useBalance(i*110);
            System.out.println("-"+i*110+" >> Balance = " + bankAccount_AMD_profile.getBalance());
        }
        System.out.println();
        Transaction transaction1 = new Transaction();
        transaction1.setTransactionAmount(1000);
        transaction1.setTransactionDirection('-');
        if(transaction1.getTransactionDirection()=='-') {
            bankAccount_AMD_profile.useBalance(transaction1.getTransactionAmount());
        }
        else if (transaction1.getTransactionDirection()=='+') {
            bankAccount_AMD_profile.addBalance(transaction1.getTransactionAmount());
        }
        System.out.println("After 1st transaction, balance = " + bankAccount_AMD_profile.getBalance());

        Transaction transaction2 = new Transaction();
        transaction2.setTransactionAmount(500);
        transaction2.setTransactionDirection('+');
        if(transaction2.getTransactionDirection()=='-') {
            bankAccount_AMD_profile.useBalance(transaction2.getTransactionAmount());
        }
        else if (transaction2.getTransactionDirection()=='+') {
            bankAccount_AMD_profile.addBalance(transaction2.getTransactionAmount());
        }
        System.out.println("After 2nd transaction, balance = " + bankAccount_AMD_profile.getBalance());


    }
}
