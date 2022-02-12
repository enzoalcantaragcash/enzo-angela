package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionProcessing{


    final private static Logger logger = Logger.getLogger(TransactionProcessing.class.getName());

    private static ArrayList<Transaction> transactionlist = new ArrayList<>();


    public static void main(String[] args) {
        Date date = new Date();
        Date date1 = new Date(1000);
        System.out.println(date1);
        System.out.println(date1);
        init();
        printAllTransactions(); //call function to print all transactions
        printSpecificTransactions(TransactionTypes.BUYLOAD); //call function to print specific transactions

        //testing compare bills if it works
        compareBills(new Bills("JOL", TransactionTypes.BILLSPAYMENT.name(), "Gcash", 1231, date1, "Gela", 500),
                new Bills("JOL", TransactionTypes.BILLSPAYMENT.name(), "Gcash", 1231, date1, "Gela", 500));
        compareBills(new Bills("JOL", TransactionTypes.BILLSPAYMENT.name(), "Gcash", 1231, date, "Gela", 500),
                new Bills("MCD", TransactionTypes.BILLSPAYMENT.name(), "Gcash", 1231, date, "Gela", 500));

    }

    public static void init () {
        //Add 5 Money Transfer objects in the Transaction ArrayList
        Date date = new Date();
        MoneyTransfer moneyTransfer = new MoneyTransfer("KFC",TransactionTypes.MONEYTRANSFER.name(), "Source", 100, date, "Jerome");
        MoneyTransfer moneyTransfer1 = new MoneyTransfer("JOL",TransactionTypes.MONEYTRANSFER.name(), "There", 200, date, "Jackson");
        MoneyTransfer moneyTransfer2 = new MoneyTransfer("MCD",TransactionTypes.MONEYTRANSFER.name(), "Here", 300, date, "Justin");
        MoneyTransfer moneyTransfer3 = new MoneyTransfer("MAX",TransactionTypes.MONEYTRANSFER.name(), "Where", 400, date, "Jego");
        MoneyTransfer moneyTransfer4 = new MoneyTransfer("CHO",TransactionTypes.MONEYTRANSFER.name(), "Everywhere", 500, date, "Jian");
        transactionlist.add(moneyTransfer);
        transactionlist.add(moneyTransfer1);
        transactionlist.add(moneyTransfer2);
        transactionlist.add(moneyTransfer3);
        transactionlist.add(moneyTransfer4);

        //Add 3 Bills Payment objects in the Transaction ArrayList
        Bills bills = new Bills("JOL", TransactionTypes.BILLSPAYMENT.name(), "Gcash", 1231, date, "Gela", 500);
        Bills bills1 = new Bills("GCA", TransactionTypes.BILLSPAYMENT.name(), "coinsPH", 4213, date, "Gian", 50000);
        Bills bills2 = new Bills("COI", TransactionTypes.BILLSPAYMENT.name(), "jollibee", 131, date, "Golang", 5000);
        transactionlist.add(bills);
        transactionlist.add(bills1);
        transactionlist.add(bills2);

        //Add 5 Buy Load objects in the Transaction ArrayList
        BuyLoad buyLoad = new BuyLoad("GLOBE", TransactionTypes.BUYLOAD.name(), "Globe1", 200, date, "09131233213");
        BuyLoad buyLoad1= new BuyLoad("TM", TransactionTypes.BUYLOAD.name(), "TM1", 240, date, "09133332221111");
        BuyLoad buyLoad2 = new BuyLoad("SMART", TransactionTypes.BUYLOAD.name(), "Smart1", 410, date, "09134444444");
        BuyLoad buyLoad3 = new BuyLoad("TNT", TransactionTypes.BUYLOAD.name(), "TNT1", 10, date, "09135555555");
        BuyLoad buyLoad4 = new BuyLoad("GLOBE", TransactionTypes.BUYLOAD.name(), "Globe2", 2120, date, "091366454432");
        transactionlist.add(buyLoad);
        transactionlist.add(buyLoad1);
        transactionlist.add(buyLoad2);
        transactionlist.add(buyLoad3);
        transactionlist.add(buyLoad4);

        //Add 2 Add Account Credits objects in the Transaction ArrayList
        AddAccountCredit addAccountCredit = new AddAccountCredit("BPI", TransactionTypes.ADDACCOUNTCREDITS.name(), "BPI ni Mac", 20410, date, "09123131231");
        AddAccountCredit addAccountCredit2 = new AddAccountCredit("GCASH", TransactionTypes.ADDACCOUNTCREDITS.name(), "BPI ni Enzo", 20310, date, "0912311231");
        transactionlist.add(addAccountCredit);
        transactionlist.add(addAccountCredit2);

        //Add 5 Add Game Credits objects in the Transaction ArrayList
        AddGameCredit addGameCredit = new AddGameCredit("Garena", TransactionTypes.ADDGAMECREDITS.name(), "superman123", 3200, date, "idkmehn");
        AddGameCredit addGameCredit1 = new AddGameCredit("LOL", TransactionTypes.ADDGAMECREDITS.name(), "batman123", 9840, date, "idk");
        AddGameCredit addGameCredit2 = new AddGameCredit("Valorant", TransactionTypes.ADDGAMECREDITS.name(), "wonderwoman123", 4310, date, "filler");
        AddGameCredit addGameCredit3 = new AddGameCredit("Dota", TransactionTypes.ADDGAMECREDITS.name(), "wenkwonkman123", 1300, date, "lagay");
        AddGameCredit addGameCredit4 = new AddGameCredit("Steam", TransactionTypes.ADDGAMECREDITS.name(), "portaman123", 32130, date, "lang");
        transactionlist.add(addGameCredit);
        transactionlist.add(addGameCredit1);
        transactionlist.add(addGameCredit2);
        transactionlist.add(addGameCredit3);
        transactionlist.add(addGameCredit4);

    }

    private static void printAllTransactions() {
        //this for loop goes through all the transaction objects within transaction list
        for (Transaction toprint : transactionlist) {
            logger.log(Level.INFO, "Store ID: " + toprint.getStore_id()+ ", Transaction ID: " + toprint.getTransaction_id()
             + ", Account ID: " + toprint.getAccount_id() + ", Amount: " + toprint.getAmount() + ", Timestamp: " + toprint.getTimestamp());
        }
    }

    private static void printSpecificTransactions(TransactionTypes tocheck) {

        //this for loop goes through all the transaction objects within transaction list
        for (Transaction toprint : transactionlist) {
            if (toprint.getTransaction_id().equals(tocheck.name())) { //the only difference is that it checks whether
                logger.log(Level.INFO, toprint.toString());         //the transaction type matches. if yes, it prints

            }
        }
    }

    public static void compareBills (Bills a, Bills b) { //function to compare two different bills
        if( (a.getTransaction_id().equals(b.getTransaction_id())) && a.getBills_charge()==b.getBills_charge() &&
        a.getCompany_name().equals(b.getCompany_name()) && a.getAmount() == b.getAmount()
        && a.getTimestamp().equals(b.getTimestamp()) && a.getAccount_id().equals(b.getAccount_id())
        && a.getStore_id().equals(b.getStore_id())) {                   //the if statement is long because you cannot compare objects directly
            logger.log(Level.INFO, "Bills compared are the same"); //you must go through all the contained variables and
        }                                                                //compare each other
        else {
            logger.log(Level.INFO, "Bills compared are NOT the same");
        }
    }
}
