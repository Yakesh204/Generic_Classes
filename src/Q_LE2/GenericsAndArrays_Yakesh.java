//Name: Yakesh Umachandran
//Student Number: 251303571
//Description: Use generic classes to organize data

package Q_LE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenericsAndArrays_Yakesh {
    public static void main(String[] args) {
        myHeader(1);//calling header
        int option;
        Scanner scanner = new Scanner(System.in);
        //creating arrays with keys and values
        ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2, 2));
        ArrayList<String> strArray = new ArrayList<>(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));
        //creating array of Pair type of class
        Pair<Integer, String>[] pairArray = new Pair[intArray.size()];
//Initializing pair classes with parameters
        for (int i = 0; i < intArray.size(); i++) {
            pairArray[i] = new Pair(intArray.get(i), strArray.get(i));
        }

        while (true) {//while loop to see if user wants to continue
            while (true) {//while loop to make sure user input is good
                try {//exception make sure user input is in range and is a integer
                    System.out.print("\nEnter Academic Year (2, 3 or 4): ");
                    option = scanner.nextInt();
                    if (option > 4 || option < 2) {
                        throw new RuntimeException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Error: input must be a string\n");
                    scanner.nextLine();
                } catch (RuntimeException e) {
                    System.out.print("Error: Input must be between 2 and 4\n");
                    scanner.nextLine();
                }
            }//temp array to holder values corresponding to option
            ArrayList<String> holder = new ArrayList<>();
            for (int i = 0; i < intArray.size(); i++) {
                if (pairArray[i].getKey() == option) {
                    holder.add(pairArray[i].getValue());
                }
            }
//print info out info and see if user wants to continue
            System.out.printf("Found %d leader(s) from year %d.\n" +
                    "Here is the list:\n" + holder +"\n",holder.size(),option);
            System.out.printf("Do you wish to continue? (Press y to continue or any other key to terminate): ");
            scanner.nextLine();
            if (scanner.nextLine().equals("y")) {

            } else {
                break;
            }
        }
        myFooter(1);//calling my footer
    }

    public static void myHeader(int q) {//method printing out header
        System.out.printf("=========================================================== \n" +
                "Lab Exercise 2-Q%d \n" +
                "Prepared By: Yakesh Umachandran\n" +
                "Student Number: 251303571\n" +
                "Goal of this Exercise: Use generic classes to organize data\n" +
                "===========================================================\n" +
                "This program prints the names of the student leaders from year 2, 3 and 4.\n" +
                "To see the list of the students from a specific year enter an integer between 2 and 4 when\n" +
                "prompted.\n", q);
    }

    public static void myFooter(int q) {//method printing out footer
        System.out.printf("=========================================================== \n" +
                "Completion of Lab Exercise 2-Q%d is successful!\n" +
                "Signing off - Yakesh\n" +
                "===========================================================\n", q);
    }
}
