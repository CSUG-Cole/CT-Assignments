package com.csc320.module_3;

import java.text.DecimalFormat;

public class AverageWithholding
{
    /* Formater for better printing */
    private static DecimalFormat dollarFormat = new DecimalFormat("#0.00");

    public static void main(String[] args) {
        /* Ensure user has passed in some income value. */
        if (args.length != 1) usage();
        double weeklyIncome = 0.0;
        try {
            weeklyIncome = Double.parseDouble(args[0]);
        } catch (NumberFormatException error) {
            System.out.println("Error: WEEKLY_INCOME should be a number, got '" + args[0] + "'");
            usage();
        }
        calculateAverageWithholding(weeklyIncome);
    }

    public static void calculateAverageWithholding(double income) {
        System.out.println("Weekly income: $" + dollarFormat.format(income));
        System.out.print("Weekly average tax withholding: $");
        double taxes = 0.0;
        if (income < 500.0) {
            taxes = income * 0.10; /* taxed at 10% */
        } else if (income < 1500) {
            taxes = income * 0.15; /* taxed at 15% */
        } else if (income < 2500) {
            taxes = income * 0.20; /* taxed at 20% */
        } else {
            taxes = income * 0.30; /* taxed at 30% */
        }
        System.out.println(dollarFormat.format(taxes));
    }

    private static void usage() {
        System.out.print(
            "usage: java com.csc320.module_3.AverageWithholding WEEKLY_INCOME\n" +
            "\n" +
            "Outputs the amount of tax withholding based on WEEKLY_INCOME.\n"
        );
        System.exit(1);
    }
}
