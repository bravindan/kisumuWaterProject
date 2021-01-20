package com.kisumu.water;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner( System.in );

        System.out.println("Available clients");
        System.out.println("\t 1. Metered");
        System.out.println("\t 2. Unmetered");
        System.out.println("\t 3. Industry");
        System.out.println("Enter client type: ");

        int client_type = input.nextInt();

        double units = 0;

        if( client_type != 3 ) {
            System.out.println("Enter units used: ");
            units = input.nextDouble();
        }

        System.out.println("Available pay methods");
        System.out.println("\t 1. Cash");
        System.out.println("\t 2. Electronic");

        int pay_method = input.nextInt();
        String pay_method_s;
        switch(pay_method) {
            case 1: {
                pay_method_s = "cash";
                break;
            }
            case 2: {
                pay_method_s = "electronic";
                break;
            }
            default: {
                input.close();
                throw new Exception("Invalid pay method");
            }
        }

        input.close();

        double bill = 0;

        switch(client_type) {
            case 1: {
                Metered client = new Metered(units, pay_method_s);
                bill = client.computeBill();
                break;
            }
            case 2: {
                Unmetered client = new Unmetered(units, pay_method_s);
                bill = client.computeBill();
                break;
            }
            case 3: {
                Industry client = new Industry(pay_method_s);
                bill = client.computeBill();
                break;
            }
        }

        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("Your payable amount is: KES " + df.format(bill) );
    }
}