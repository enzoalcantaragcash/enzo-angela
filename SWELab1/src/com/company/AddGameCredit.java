package com.company;

import java.util.Date;

public class AddGameCredit extends Transaction{

    private String company_name;

    public AddGameCredit(String store_id, String transaction_id, String account_id, int amount, Date timestamp, String company_name) {
        super(store_id, transaction_id, account_id, amount, timestamp);
        this.company_name = company_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
