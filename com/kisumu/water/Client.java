package com.kisumu.water;

public class Client {
    public double usedUnits = 0;
    public String client_type;
    public String pay_method;

    public Client(double units, String client_type, String pay_method) {
        if( units < 0 ) {
            units = Math.abs(units);
        }

        this.usedUnits = units;
        this.client_type = client_type;
        this.pay_method = pay_method;
    }

    public void setClientType( String client_type ) {
        this.client_type = client_type;
    }

    public void setPayMethod( String pay_method ) {
        this.pay_method = pay_method;
    }

    public double unitsAmount() {
        double bill = 0;
        double unit_rate = 30;

        if( this.usedUnits < 150 ) {
            unit_rate = 33;
        }

        // Add units bill
        bill += this.usedUnits * unit_rate;

        return bill;
    }

    public double computeCommonDiscounts(double bill) {

        double discount = 0;

        if( this.client_type == Metered.CLIENT_TYPE ) {
            // Allowing 10% discount from principal amount
            discount += bill * 0.1;
        } else if( this.client_type == Unmetered.CLIENT_TYPE ) {

        } else if( this.client_type == Industry.CLIENT_TYPE ) {

            // Allowing fixed 9% discount
            discount += bill * 0.09;
        }

        bill -= discount;

        if( this.usedUnits > 100 ) {
            discount += bill * 0.08;
        }

        bill -= discount;

        if( this.pay_method == "electronic" ) {
            discount += bill * 0.05;
        }

        return discount;
    }
}
