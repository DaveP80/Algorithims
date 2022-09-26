package com.logic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static List<BigInteger> dict = new ArrayList<BigInteger>();

    public static List<BigInteger> printFibonacciRecursion(int num) {

        if (num == 1) {
            printFibonacciRecursion(0);
            System.out.format("Term %d: %d%n", num, 1);
            dict.add(BigInteger.ONE);
        } else if (num == 0) {
            System.out.format("Term %d: %d%n", num, 0);
            dict.add(BigInteger.ZERO);
        } else {
            printFibonacciRecursion(num - 1);
            dict.add(dict.get(num - 2).add(dict.get(num - 1)));
        }
        return dict;
    }

    public static BigInteger mean(List<BigInteger> dict) {
        BigInteger total = BigInteger.valueOf(0);
        BigInteger size = BigInteger.valueOf(dict.size());

        for (BigInteger bigInteger : dict) {
            BigInteger a
                    = new BigInteger(String.valueOf(bigInteger));

            total = total.add(a);

        }
        return total.divide(size);
    }

    public static BigInteger standardDeviation(List<BigInteger> dict) {
        BigInteger init = mean(dict);
        BigInteger temp = BigInteger.valueOf(0);
        BigInteger sq;

        for (BigInteger bigInteger : dict) {
            temp = temp.add((bigInteger.subtract(init)).pow(2));
        }

        sq = temp.divide(BigInteger.valueOf(dict.size()));
        return sq.sqrt();
    }
}

