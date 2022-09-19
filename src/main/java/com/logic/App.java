package com.logic;
import com.logic.dao.EntryDao;
import com.logic.model.Entry;
import com.logic.service.EntryService;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.*;

public class App extends Fibonacci {
    static Scanner scan = new Scanner(System.in);
    static NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            EntryDao ed = new EntryDao();
            EntryService es = new EntryService();

            try {
                int choice;

                do {
                    System.out.println("Algorithim menu (q to exit)\n");
                    System.out.print("1.) Generate Fibonacci Array \n");
                    System.out.print("2.) New number set\n");
                    System.out.print("3.) Clear stored sequence\n");
                    System.out.print("4.) Exit\n");
                    System.out.print("\nEnter Your Menu Choice: ");

                    if (scan.hasNext("q")) {
                        System.out.println("Exiting Program...");
                        System.exit(0);
                    }

                    while (!scan.hasNextInt()) {
                        scan.nextLine();
                    }
                    choice = scan.nextInt();

                    switch (choice) {
                        //every time case 1 is selected, fibonacci table is cleared
                        case 1:
                            if (ed.read() == 1)
                                ed.delete();
                            dict.clear();
                            ed.create();

                            System.out.println("Please enter a Value.");
                            if (scan.hasNext("q")) {
                                System.out.println("Exiting Program...");
                                System.exit(0);
                            }
                            int testinput = scan.nextInt();

                            if (testinput == 0 || testinput == 1) {
                                System.out.println("Base Cases 0 1");
                                System.out.println("           1 1");
                                break;
                            }

                            printFibonacciRecursion(testinput);

                            int i;
                            if (dict.size() >= 50) {
                                List<BigInteger> printArray = new ArrayList<>();
                                for (i = 0; i <= 50; i++) {
                                    printArray.add(dict.get(i));
                                }
                                if (dict.size() > 150) {

                                    String str = formatter.format(dict.get(dict.size() - 1));
                                    System.out.print(">Generated Value: " + str + "<");
                                    System.out.println(printArray + ".....");
                                    System.out.println("connecting....check DB" + "\n");

                                }

                                if (dict.size() <= 150 && dict.size() >= 50) {
                                    System.out.print(">Generated Value: " + dict.get(dict.size() - 1) + "<");
                                    System.out.println(printArray + ".....");
                                    System.out.println("connecting....check DB" + "\n");
                                }
                            }
                            if (dict.size() < 50 && dict.size() > 2) {
                                System.out.println(">Generated Value: " + dict.get(dict.size() - 1) + "< ");
                                System.out.println(dict);
                                System.out.println("connecting....check DB" + "\n");
                            }
                            for (i = 1; i <= (dict.size() - 1); i++) {
                                Entry a = new Entry(dict.get(i));
                                es.insertExample(a);
                            }
                            break;

                        case 2:
                            //will persist current Array to table store_sequence
                            //initiate new fibonacci generator
                            System.out.print("last Generated Result: ");
                            if (dict.isEmpty()) {
                                System.out.println("empty Array");
                                break;
                            }

                            if (dict.size() > 2) {

                                if (dict.size() > 150) {

                                    System.out.println(formatter.format(dict.get(dict.size() - 1)));
                                }

                                if (dict.size() <= 150) {
                                    System.out.println(dict.get(dict.size() - 1));
                                }

                                System.out.println("would you like to persist this sequence? (1)yes (2)no");

                                int thisInput = scan.nextInt();
                                if (thisInput < 1 || thisInput > 2) {

                                    System.out.println("enter 1(yes) or 2(no)");
                                    thisInput = scan.nextInt();
                                    if (thisInput < 1 || thisInput > 2) {
                                        break;
                                    }
                                }
                                if (thisInput == 2) {
                                    System.out.println("making a new table");

                                    ed.delete();
                                    ed.create();
                                    System.out.println("ready for new data");
                                    break;
                                }
                                if (ed.readStorage() == 1) {
                                    System.out.println("storage table already full");
                                    break;
                                }

                                int j;

                                for (j = 1; j <= (dict.size() - 1); j++) {
                                    Entry b = new Entry(dict.get(j));
                                    ed.storeValues(b);
                                }
                                System.out.println("sequence stored!");
                                break;
                            }

                        case 3:
                            System.out.println("press any number to delete storage data, (q) to quit");
                            if (scan.hasNext("q")) {
                                System.out.println("Exiting Program...");
                                System.exit(0);
                            }

                            scan.nextInt();
                            if (ed.readStorage() == 1)
                                ed.deleteStorage();
                            if (ed.readStorage() == -1)
                                ed.deleteStorage();
                            if (ed.createStorage() == -1)
                                System.out.println("storage cleared!" + "\n");

                            break;

                        case 4:
                            System.out.println("Exiting Program...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(choice + " is not a valid Menu Option! Please Select Another.");
                    }
                }
                while (true);
            } catch (InputMismatchException e) {
                System.out.println("enter integers");
            }
        }
    }
}


