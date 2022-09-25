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

    public static BigInteger mean (ArrayList<BigInteger> dict) {
        BigInteger total = BigInteger.valueOf(0);
        BigInteger size = BigInteger.valueOf(dict.size());

        for (int i = 2; i < dict.size(); i++) {

            if (i % 2 == 0) {

                BigInteger a
                        = new BigInteger(String.valueOf(dict.get(i)));
//            BigInteger currentNum = dict.get(i);
                BigInteger b
                        = new BigInteger(String.valueOf(dict.get(i + 1)));

                total = total.add(a.add(b));
            }

        }return total.divide(size);
    }

//        public double standardDeviation (ArrayList < BigInteger > dict) {
//
//            // Step 1:
//            double mean = mean(dict);
//            double temp = 0;
//
//            for (int i = 0; i < dict.size(); i++) {
//                BigInteger val = dict.get(i);
//
//                // Step 2:
//                double squrDiffToMean = Math.pow(val - mean, 2);
//
//                // Step 3:
//                temp += squrDiffToMean;
//            }
//
//            // Step 4:
//            double meanOfDiffs = (double) temp / (double) (dict.size());
//
//            // Step 5:
//            return Math.sqrt(meanOfDiffs);
//        }
    }

