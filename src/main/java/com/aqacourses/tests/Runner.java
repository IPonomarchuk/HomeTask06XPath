package com.aqacourses.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {

    public static void main(String[] args) {

        // Run PriceComparison test
        Result resultOfPriceComparisonTest = JUnitCore.runClasses(PriceComparisonTest.class);

        // Verify result of price comparison test
        if (resultOfPriceComparisonTest.wasSuccessful()) {
            System.out.println("Success!");
        } else {
            // Work with failures
            for (Failure failure : resultOfPriceComparisonTest.getFailures()) {
                System.err.println("Exception - " + failure.getException());
                System.err.println("Trace - " + failure.getTrace());
            }

        }

        // Run SymbolSearch test
        Result resultOfSymbolSearchTest = JUnitCore.runClasses(SymbolSearchTest.class);

        // Verify result of symbol search test
        if (resultOfSymbolSearchTest.wasSuccessful()) {
            System.out.println("Success!");
        } else {
            // Work with failures
            for (Failure failure : resultOfSymbolSearchTest.getFailures()) {
                System.err.println("Exception - " + failure.getException());
                System.err.println("Trace - " + failure.getTrace());
            }

        }

    }

}
