package com.company;

import java.util.Date;

public class Transaction {

    protected String store_id;
    protected String transaction_id;
    protected String account_id;
    protected int amount;
    protected Date timestamp;

    public Transaction(String store_id, String transaction_id, String account_id, int amount, Date timestamp) {
        this.store_id = store_id;
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() { //automatically prints a certain format containing all variables within this object
        return "Store ID: " + store_id+ ", Transaction ID: " + transaction_id
                + ", Account ID: " + account_id + ", Amount: " + amount + ", Timestamp: " + timestamp;

    }
}
