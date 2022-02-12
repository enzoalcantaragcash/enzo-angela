package com.company;

import java.util.Date;

public class MoneyTransfer extends Transaction{

    private String recipient;

    public MoneyTransfer(String store_id, String transaction_id, String account_id, int amount, Date timestamp, String recipient) {
        super(store_id, transaction_id, account_id, amount, timestamp);
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
