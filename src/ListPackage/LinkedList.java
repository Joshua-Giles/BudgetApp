/**
 * Implementation of LinkedList class and all necessary functions.
 * 
 * @author Joshua Giles
 */
package ListPackage;

/**
 * Class header for the creation of the LinkedList.
 */
public class LinkedList {

    Node head;

    /**
     * Class structure for creating Nodes for the LinkedList.
     */
    static class Node {
        Node next;
        String name;
        int data;
    
        // Constructor
        public Node(String name, int data) {
            this.name = name;
            this.data = data;
        }
    }

    /**
     * Adds new elements to the list with 2 pieces of data
     * 
     * @param name The name of the expense being added.
     * @param data The cost of the expense.
     */
    public void add(String name, int data) {
        if (head == null) {
            head = new Node (name, data);
            return;
        }
        Node current = head;
        // Checks if there is already an instance of the expense to add onto it without creation of a new Node.
        while (current != null) {
            if (current.name.equals(name)) {
                current.data += data;
                return;
            }
            if (current.next == null)
                break;
            current = current.next;
        }
        current.next = new Node(name, data);
    }

    /**
     * Deletes an element from the list from the given name.
     * 
     * @param name The name of the expense to be removed from the list.
     */
    public void delete(String name) {
        if (head == null)
            return;
        if (head.name.equals(name)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Gets the information of the Node with the given name.
     * 
     * @param name The name of the expense which is being output.
     * @return The name and data of the Node.
     */
    public String get(String name) {
        if (head == null)
            return "Error, no items in list.";

        Node current = head;
        while (current != null) {
            if (current.name.equals(name))
                return current.name + ", " + current.data;
            current = current.next;
        }
        return "Expense not found.";
    }

    /**
     * Prints out the list of all expenses in an orderly format.
     */
    public void printExpenses() {
        if (head == null) {
            System.out.println("No expenses found.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.name + ", " + current.data);
            current = current.next;
        }
    }
}