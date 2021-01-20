package com.kisumu.water;

public class Industry extends Metered {
    public static final double UNITS_USED = 2500;
    public static final String CLIENT_TYPE = "industry";

    public Industry(String pay_method) {
        super(Industry.UNITS_USED, "");
        this.setClientType(Industry.CLIENT_TYPE);
        this.setPayMethod(pay_method);
    }
}
