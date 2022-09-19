package com.logic;
import com.logic.service.EntryService;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
public class Fibonacci {
    public static List<BigInteger> dict = new ArrayList<BigInteger>();
    public static List<BigInteger> printFebonachiRecursion(int num) {

        EntryService as = new EntryService();
        if (num == 1) {
            printFebonachiRecursion(0);
            System.out.printf("Term %d: %d%n", num, 1);
            dict.add(BigInteger.ONE);
        } else if (num == 0) {
            System.out.printf("Term %d: %d%n", num, 0);
            dict.add(BigInteger.ZERO);
        } else {
            printFebonachiRecursion(num - 1);
            dict.add(dict.get(num - 2).add(dict.get(num - 1)));
        }
        return dict;
    }
}

