package com.kisumu.water;

public class Unmetered extends Client {

    public static final String CLIENT_TYPE = "unmetered";

    public Unmetered(double units, String pay_method) {
        super(units, Unmetered.CLIENT_TYPE, pay_method);
    }

    public double computeBill() {
        double bill = this.unitsAmount();

        bill -= this.computeCommonDiscounts(bill);

        return bill;
    }
}
