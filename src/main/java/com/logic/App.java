package com.logic;
import com.logic.dao.EntryDao;
import com.logic.model.Entry;
import com.logic.service.EntryService;
import java.math.BigInteger;
import java.util.*;

public class App extends Fibonacci {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            EntryDao ed = new EntryDao();
            EntryService es = new EntryService();

            try {

                int choice;

                do {
                    System.out.println("Algorithim menu\n");
                    System.out.print("1.) Generate Fibonacci Array \n");
                    System.out.print("2.) New number set\n");
                    System.out.print("3.) Exit\n");
                    System.out.print("\nEnter Your Menu Choice: ");

                    while (!scan.hasNextInt()) {
                        scan.nextLine();
                    }
                    choice = scan.nextInt();

                    switch (choice) {

                        case 1: {
                            if (ed.read() == 1)
                                ed.delete();
                            dict.clear();
                            ed.create();

                            System.out.println("Please enter a Value");
                            int testinput = scan.nextInt();

                            printFebonachiRecursion(testinput);

                            if (dict.size()>=50) {
                                List<BigInteger> printArray = new ArrayList<>();
                                for(int i= 0; i <=50; i++) {
                                    printArray.add(dict.get(i));
                                }
                                System.out.print(">Generated Value: " + dict.get(dict.size() - 1) + "<");
                                System.out.println(printArray + ".....");
                                System.out.println("connecting....check DB" + "\n");
                            } if (dict.size()<50 && dict.size()>2) {
                                System.out.println(">Generated Value: " + dict.get(dict.size() - 1) + "< ");
                                System.out.println(dict);
                                System.out.println("connecting....check DB" + "\n");
                            }

                            int i;
                            for (i = 1; i <= (dict.size() - 1); i++) {
                                Entry a = new Entry(dict.get(i));
                                es.insertExample(a);
                            }
                            break;
                        }

                        case 2:

                            System.out.print("last Generated Result: ");
                            if (dict.isEmpty()) {
                                System.out.println("empty Array");
                            } else {
                                System.out.println(dict.get(dict.size() - 1));
                            }
                            System.out.println("making a new table");
                            System.out.println("press any number to confirm");
                            int confirmClear = scan.nextInt();

                            ed.delete();
                            ed.create();

                            System.out.println("ready for new data");
                            break;

                        case 3:
                            System.out.println("Exiting Program...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(choice + " is not a valid Menu Option! Please Select Another.");
                    }
                } while (choice != 3);
            } catch (InputMismatchException e) {
                System.out.println("enter integers");
            }
        }
    }
}

