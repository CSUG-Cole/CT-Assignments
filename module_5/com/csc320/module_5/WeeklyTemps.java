package com.csc320.module_5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WeeklyTemps
{
    /* Formater for better printing */
    private static DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    final static Random rand = new Random();
    final static int DAYS_IN_A_WEEK = 7;
    final static int LOW_TEMP = 40;
    final static int HIGH_TEMP = 81;

    public static void main(String[] args) {
        /* Declarations */
        List<String> days = new ArrayList<>();
        List<Double> avgDailyTemps = new ArrayList<>();
        String day;
        Scanner scanner = new Scanner(System.in);

        /* Array initialization */
        generateRandomTemps(avgDailyTemps);
        initDays(days);

        /* Get day of the week from user */
        System.out.print(
            "Please enter a day of the week (Monday, Tuesday, etc.) to get the daily temperature\n" +
            "or 'week' to get the weekly average: "
        );
        day = scanner.next();
        scanner.close();

        /* Branch based on user response */
        if (day.equals("week")) {
            displayWeeklyTemps(days, avgDailyTemps);
        } else {
            displayDailyTemp(day, days, avgDailyTemps);
        }
    }

    private static void displayWeeklyTemps(List<String> days, List<Double> avgDailyTemps) {
        Double weeklyAvgTemp = 0.0;
        for (int i = 0; i < DAYS_IN_A_WEEK; i++) {
            System.out.println(
                "Temperature for " + days.get(i) + " is: " +
                decimalFormat.format(avgDailyTemps.get(i)) + "F"
            );
            weeklyAvgTemp += avgDailyTemps.get(i);
        }
        System.out.println("Average temperature for the week: " +
                           decimalFormat.format(weeklyAvgTemp / DAYS_IN_A_WEEK) + "F");
    }

    private static void displayDailyTemp(String day, List<String> days, List<Double> avgDailyTemps) {
        /* Search for the desired day */
        for (int i = 0; i < DAYS_IN_A_WEEK; i++) {
            if (day.equals(days.get(i))) {
                System.out.println(
                    "The temperature for " + days.get(i) + " is: " +
                    decimalFormat.format(avgDailyTemps.get(i)) + "F"
                );
                return;
            }
        }

        /* Desired day was not found, display error */
        System.out.println("The day you entered is not a know day of the week: '" + day + "'");
    }

    private static void generateRandomTemps(List<Double> temps) {
        /* Generate random daily temperatures */
        for (int i = 0; i < DAYS_IN_A_WEEK; i++) {
            temps.add(rand.nextDouble(LOW_TEMP, HIGH_TEMP));
        }
    }

    private static void initDays(List<String> days) {
        days.clear();
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
    }
}
