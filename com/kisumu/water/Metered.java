package com.kisumu.water;

public class Metered extends Client {

    public static final String CLIENT_TYPE = "metered";

    public static final double METER_RENT = 500;
    
    public Metered(double units, String pay_method) {
        super(units, Metered.CLIENT_TYPE, pay_method);
    }

    public double computeBill() {
        double bill = this.unitsAmount();
        
        // Add meter rent
        bill += Metered.METER_RENT;

        bill -= this.computeCommonDiscounts(bill);

        return bill;
    }
}