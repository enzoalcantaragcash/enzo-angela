package com.company;

import java.util.Date;
import java.util.Objects;

public class Bills extends Transaction{

    private String company_name;
    private int Bills_charge;

    public Bills(String store_id, String transaction_id, String account_id, int amount, Date timestamp, String company_name, int bills_charge) {
        super(store_id, transaction_id, account_id, amount, timestamp);
        this.company_name = company_name;
        Bills_charge = bills_charge;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getBills_charge() {
        return Bills_charge;
    }

    public void setBills_charge(int bills_charge) {
        Bills_charge = bills_charge;
    }

}
