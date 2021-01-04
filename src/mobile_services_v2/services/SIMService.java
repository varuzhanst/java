package mobile_services_v2.services;

import mobile_services_v2.models.simcards.SIMBlank;
import mobile_services_v2.models.simcards.SIMInternet;
import mobile_services_v2.models.simcards.SIMVoice;
import mobile_services_v2.models.transactions.InternetTransaction;
import mobile_services_v2.models.transactions.VoiceTransaction;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SIMService {
    public static SIMBlank SIMregistration(String Passport) {
        int type=-1;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("1. Voice\n2. Internet\n>>");
            String possibleChoice = scanner.next();
            if (Character.isDigit(possibleChoice.charAt(0)))
                type = Integer.parseInt(String.valueOf(possibleChoice.charAt(0)));
        } while (type < 0 || type > 2);
        System.out.print("ICCID (8 digits): ");
        String iccid = scanner.next();
        iccid ="8937410"+ iccid + type;
        System.out.print("MSISDN (6 digits): ");
        String msisdn = scanner.next();
        msisdn = "88" + msisdn;
        if (type == 1) return new SIMVoice(msisdn, iccid, Passport, 0);
        else return new SIMInternet(msisdn, iccid, Passport, 0);
    }

    public static void showSIMinfo(SIMBlank simBlank) {
        System.out.println("==========================");
        System.out.println("MSISDN : " + simBlank.getMsisdn());
        System.out.println("ICCID : " + simBlank.getIccid());
        System.out.println("Passport : " + simBlank.getHolderPassport());
        System.out.println("Holder : " + SubscriberService.getNameByPassport(simBlank.getHolderPassport()));
        System.out.println("Balance : " + simBlank.getBalance());
        System.out.println("==========================");
    }

    public static void simSearchByMsisdn(String msisdn) {
        List<String> allSIMs;
        try {
            boolean isFound = false;
            allSIMs = FileService.readSIMsAll();
            for (int i = 0; i < allSIMs.size(); i++) {
                String[] SIM = allSIMs.get(i).split(",");
                if (SIM[1].equals(msisdn)) {
                    showSIMinfo(getSIMBlankFromText(allSIMs.get(i)));
                    isFound = true;
                    if (SIM[4].equals("Voice")) {
                        VoiceTransaction voiceTransaction = new VoiceTransaction();
                        System.out.println("1.Recharge");
                        System.out.println("2.Internet session");
                        System.out.println("3.Call");
                        System.out.println("0.Main menu");
                        System.out.print("Choice : ");
                        Scanner scanner = new Scanner(System.in);
                        int choice = -1;
                        String possibleChoice = scanner.next();
                        if (Character.isDigit(possibleChoice.charAt(0)))
                            choice = Integer.parseInt(String.valueOf(possibleChoice.charAt(0)));
                        switch (choice) {
                            case 1:
                                int amount;
                                do {
                                    System.out.print("Amount : ");
                                    amount = scanner.nextInt();
                                } while (amount <= 0);
                                try {
                                    voiceTransaction.deposit(amount, msisdn);
                                } catch (Exception e) {
                                }
                                System.out.println("Done! New balance = " + getBalanceByMsisdn(msisdn));
                                break;
                            case 2:
                                int KB;
                                do {
                                    System.out.print("KB : ");
                                    KB = scanner.nextInt();
                                } while (KB <= 0);
                                InternetTransaction internetTransaction = new InternetTransaction();
                                try {
                                    internetTransaction.useBalance(KB, msisdn);
                                    System.out.println("Done! New balance = " + getBalanceByMsisdn(msisdn));
                                } catch (Exception e) {
                                    System.out.println("Insufficient balance!");
                                }

                                break;
                            case 3:
                                int seconds;
                                do {
                                    System.out.print("Seconds : ");
                                    seconds = scanner.nextInt();
                                } while (seconds <= 0);
                                try {
                                    voiceTransaction.useBalance(seconds, msisdn);
                                    System.out.println("Done! New balance = " + getBalanceByMsisdn(msisdn));
                                } catch (Exception e) {
                                    System.out.println("Insufficient balance!!");
                                }

                                break;
                            default:
                                System.out.println("Invalid selection");
                                break;
                        }

                    } else {
                        InternetTransaction internetTransaction = new InternetTransaction();
                        System.out.println("1.Recharge");
                        System.out.println("2.Internet session");
                        System.out.println("0.Main menu");
                        System.out.print("Choice : ");
                        Scanner scanner = new Scanner(System.in);
                        int choice = -1;
                        String possibleChoice = scanner.next();
                        if (Character.isDigit(possibleChoice.charAt(0)))
                            choice = Integer.parseInt(String.valueOf(possibleChoice.charAt(0)));
                        switch (choice) {
                            case 1:
                                int amount;
                                do {
                                    System.out.print("Amount : ");
                                    amount = scanner.nextInt();
                                } while (amount <= 0);
                                try {
                                    internetTransaction.deposit(amount, msisdn);
                                } catch (Exception e) {
                                }
                                System.out.println("Done! New balance = " + getBalanceByMsisdn(msisdn));
                                break;
                            case 2:
                                int KB;
                                do {
                                    System.out.print("KB : ");
                                    KB = scanner.nextInt();
                                } while (KB <= 0);
                                try {
                                    internetTransaction.useBalance(KB, msisdn);
                                    System.out.println("Done! New balance = " + getBalanceByMsisdn(msisdn));
                                } catch (Exception e) {
                                    System.out.println("Insufficient balance!");
                                }

                                break;

                            default: {
                                System.out.println("Invalid selection");
                                break;
                            }

                        }
                    }
                    break;
                }
            }
            if (!isFound) {
                System.out.println("No MSISDN found! MSISDN = " + msisdn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SIMBlank getSIMBlankFromText(String SIM) {
        String[] SIM_full = SIM.split(",");
        if (SIM_full[4] .equals("Internet") )
            return new SIMInternet(SIM_full[1], SIM_full[0], SIM_full[2], Double.parseDouble(SIM_full[3]));
        else return new SIMVoice(SIM_full[1], SIM_full[0], SIM_full[2], Double.parseDouble(SIM_full[3]));

    }

    public static void simSearchByPassport(String passport) {
        List<String> allSIMs;
        try {
            boolean isFound = false;
            allSIMs = FileService.readSIMsAll();
            System.out.println("\nSIMs registered for " + passport);
            for (int i = 0; i < allSIMs.size(); i++) {
                String[] SIM = allSIMs.get(i).split(",");
                if (SIM[2].equals(passport)) {
                    System.out.println(SIM[1]);
                    isFound = true;
                }
            }
            if (!isFound) {
                System.out.println("No SIM found!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void removeMSISDN(String MSISDN) {
        List<String> allSIMs;
        try {
            boolean isFound = false;
            allSIMs = FileService.readSIMsAll();
            for (int i = 0; i < allSIMs.size(); i++) {
                String[] SIM = allSIMs.get(i).split(",");
                if (SIM[1].equals(MSISDN)) {
                    isFound = true;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("\nSIM found!\n");
                    showSIMinfo(getSIMBlankFromText(allSIMs.get(i)));
                    System.out.println("\nDo you want to remove the SIM?");
                    System.out.print("Y / N:");
                    char choice = scanner.next().charAt(0);
                    if (choice == 'Y' || choice == 'y') {
                        FileService.clearSIMs();
                        for (int j = 0; j < allSIMs.size(); j++) {
                            SIM = allSIMs.get(j).split(",");
                            if (!SIM[1].equals(MSISDN)) {
                                FileService.writeSIM(getSIMBlankFromText(allSIMs.get(j)));
                            }
                        }
                    } else {
                        System.out.println("Action terminated!");
                        continue;
                    }
                    break;
                }
            }
            if (!isFound) {
                System.out.println("No SIM found! MSISDN = " + MSISDN);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean isSIMFound(String passport) {
        List<String> allSIMs;
        try {
            allSIMs = FileService.readSIMsAll();
            for (int i = 0; i < allSIMs.size(); i++) {
                String[] subscriber = allSIMs.get(i).split(",");
                if (subscriber[2].equals(passport)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static double getBalanceByMsisdn(String msisdn) {
        List<String> allSIMs;
        try {
            allSIMs = FileService.readSIMsAll();
            for (int i = 0; i < allSIMs.size(); i++) {
                String[] SIM = allSIMs.get(i).split(",");
                if (SIM[1].equals(msisdn)) {
                    return getSIMBlankFromText(allSIMs.get(i)).getBalance();

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void changeBalanceByMsisdn(String msisdn, double amount) throws Exception {
        List<String> allSIMs;
        try {
            allSIMs = FileService.readSIMsAll();
            for (int i = 0; i < allSIMs.size(); i++) {
                String[] SIM = allSIMs.get(i).split(",");
                if (SIM[1].equals(msisdn)) {
                    SIM[3] = Double.parseDouble(SIM[3]) + amount + "";
                    if (Double.parseDouble(SIM[3]) < 0) throw new Exception("Insufficient balance!");
                    allSIMs.set(i,SIM[0] + "," + SIM[1] + "," + SIM[2] + "," + SIM[3] + "," + SIM[4]);
                }

            }
            FileService.clearSIMs();
            for (int j = 0; j < allSIMs.size(); j++) {
                FileService.writeSIM(getSIMBlankFromText(allSIMs.get(j)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
