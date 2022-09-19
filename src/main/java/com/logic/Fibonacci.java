package com.logic;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
public class Fibonacci {
    public static List<BigInteger> dict = new ArrayList<BigInteger>();
    public static List<BigInteger> printFibonacciRecursion(int num) {

        if (num == 1) {
            printFibonacciRecursion(0);
            System.out.printf("Term %d: %d%n", num, 1);
            dict.add(BigInteger.ONE);
        } else if (num == 0) {
            System.out.printf("Term %d: %d%n", num, 0);
            dict.add(BigInteger.ZERO);
        } else {
            printFibonacciRecursion(num - 1);
            dict.add(dict.get(num - 2).add(dict.get(num - 1)));
        }
        return dict;
    }
}

