/**
 * Main class implementation. Housing all main methods for application.
 * Testing commit...
 * 
 * @author Joshua Giles
 */
package BudgetPackage;

import ListPackage.LinkedList;
import java.util.*;

/**
 * Main class for the budgeting application.
 */
public class BudgetApp {
    public static void main(String[] args) {
        // Creation of LinkedList, scanner, and the input response.
        LinkedList list = new LinkedList();
        Scanner scan = new Scanner(System.in);
        String answer = "yes";
        
        // Creates the initial budget from input.
        System.out.print("Hello, what is your budget?: ");
        int budget = scan.nextInt();
        int removed = budget;
        scan.nextLine();

        // Loops until the user is done adding expenses.
        while (answer.equals("yes")) {
            System.out.print("Would you like to enter a new expense?: ");
            answer = scan.nextLine().toLowerCase();

            // Checks if the user wants to add more expenses and does so.
            if (answer.equals("yes")) {
                System.out.print("Please enter the name of the expense, followed by the cost: ");
                String name = scan.next();
                int data = scan.nextInt();
                scan.nextLine();
                addExpenses(list, name, data);
                removed -= data;
            }
            // Allows the user to list the expeses if they want.
            else {
                System.out.print("Would you like to list all expenses?: ");
                String print = scan.nextLine().toLowerCase();

                if (print.equals("yes"))
                    printExpenses(list, budget, removed);
                else
                    System.out.println("Maybe next time.");
            }
        }
        scan.close();
    }

    /**
     * Adds new expenses given the name and data.
     * 
     * @param list The LinkedList being used by the user.
     * @param name The name of the new expense.
     * @param data The data attached to the new expense.
     */
    public static void addExpenses(LinkedList list, String name, int data) {
        list.add(name, data);
    }

    /**
     * Prints out all expenses in a list with the total budget at the top.
     * 
     * @param list The LinkedList being used by the user.
     * @param budget The input total budget of the user.
     */
    public static void printExpenses(LinkedList list, int budget, int removed) {
        System.out.println("Total budget: " + budget);
        list.printExpenses();
        System.out.println("Current amount: " + removed);
        if (removed <= 0)
            System.out.println("Oops, maybe you should be making better financial choices or just make more money...");
    }

}
