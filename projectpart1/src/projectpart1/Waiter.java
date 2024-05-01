package projectpart1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Moaz
 */
/**
 * Represents a waiter in a restaurant, inheriting from the Stuff class.
 */
public class Waiter extends Stuff {

    /** The list of orders managed by the waiter. */
    private ArrayList<Order> orders;

    /** Scanner object for user input. */
    Scanner in = new Scanner(System.in);

    /**
     * Allows the waiter to create a new order.
     */
    public void make_order() {
        System.out.println("Enter the number of items you want to order");
        int n = in.nextInt();
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the item you want to order");
            items.add(in.next());
        }
        System.out.println("Enter table number");
        n = in.nextInt();
        Order order = new Order(items, n);
        orders.add(order);
    }

    /**
     * Allows the waiter to modify an existing order by adding or removing items.
     */
    public void modify_order() {
        System.out.println("Enter the order number you want to modify");
        int n = in.nextInt();
        System.out.println("Enter the number of items you want to add");
        int m = in.nextInt();
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the item you want to add");
            items.add(in.next());
        }
        orders.get(n).orderedItems.addAll(items);
        System.out.println("Enter the number of items you want to remove");
        m = in.nextInt();
        items = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the item you want to remove");
            items.add(in.next());
        }
        orders.get(n).orderedItems.removeAll(items);
    }

    /**
     * Allows the waiter to cancel an existing order.
     */
    public void cancel_order() {
        System.out.println("Enter the order number you want to cancel");
        int n = in.nextInt();
        orders.remove(n);
    }

    /**
     * Allows the waiter to add a bill to an existing order.
     */
    public void addbill() {
        System.out.println("Enter the order number you want to add bill to and its customer id");
        int n = in.nextInt();
        int m = in.nextInt();
        Date date = new Date();
        orders.get(n).create_bill(m, date, orders.get(n).orderedItems);
    }

    /**
     * Allows the waiter to delete a bill from an existing order.
     */
    public void deletebill() {
        System.out.println("Enter the order number you want to delete bill from");
        int n = in.nextInt();
        orders.get(n).bill = null;
    }
}