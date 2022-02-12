package com.company;

import java.util.Date;

public class AddAccountCredit extends Transaction{

    private String msisdn;

    public AddAccountCredit(String store_id, String transaction_id, String account_id, int amount, Date timestamp, String msisdn) {
        super(store_id, transaction_id, account_id, amount, timestamp);
        this.msisdn = msisdn;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
