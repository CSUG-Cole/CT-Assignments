package com.csc320.module_4;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class FiveFloats
{
    /* Formater for better printing */
    private static DecimalFormat dollarFormat = new DecimalFormat("#0.00000");

    public static void main(String[] args) {
        System.out.println("Please enter 5 floating point numbers!");
        processFloats();
        System.exit(0);
    }

    private static void processFloats() {
        float max = java.lang.Float.NEGATIVE_INFINITY;
        float min = java.lang.Float.MAX_VALUE;
        float sum = 0;
        int count = 0;
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            float value = getFloat(scanner);
            if (value > max) max = value; /* Update new max */
            if (value < min) min = value; /* Update new min */
            sum += value; /* Increase sum */
            count++; /* Increment count */

            /* Stop running when user has entered 5 numbers */
            if (count == 5) running = false;
        }

        /* Print info about entered info */
        System.out.println("---- Useful info about input ----");
        System.out.println("Total:                      $" + dollarFormat.format(sum));
        System.out.println("Average:                    $" + dollarFormat.format(sum / 5.0f));
        System.out.println("Maximum:                    $" + dollarFormat.format(max));
        System.out.println("Minimum:                    $" + dollarFormat.format(min));
        System.out.println("Interest on total at 20%:   $" + dollarFormat.format(sum * 0.2));
    }

    private static float getFloat(Scanner scanner) {
        /*
         * getFloat returns the next float entered by a user.
         * If next token is not a float user will be prompted for a proper float
         * until one is entered.
         * If input is exhausted or scanner is closed getFloat will stop execution.
         */

        try {
            return scanner.nextFloat();
        } catch (InputMismatchException error) {
            System.out.println("Warning, please enter a floating point number.");
            scanner.next();
            return getFloat(scanner);
        } catch (NoSuchElementException error) {
            System.out.println("Error, input is exhausted. Exiting.");
        } catch (IllegalStateException error) {
            System.out.println("Error, scanner is closed. Exiting.");
        }

        System.exit(1);

        /* UNREACHABLE */
        return 0f;
    }
}
