/* Author: Alan Lam
 * Class name: Order
 * Description: This class is used to store information of our order.
 * 				For example, how many vegetarian meal(s) we are going to order and etc.
 */

import java.util.Scanner;

public class Order {
	public int numOfOrders;
	public int vegetarian;
	public int glutenFree;
	public int nutFree;
	public int fishFree;
	public int others;
	
	public Scanner reader = new Scanner(System.in);
	
	// Gather order from user
	public void receivingOrder() {
		
		System.out.print("\n---Processing Order---\nPlease enter number of meals needed: ");
		this.numOfOrders = reader.nextInt();
		
		// Collecting Dietary Restrictions data (such as vegetarian, gluten free, nut free, and fish free) 
		System.out.print("\nPlease enter number of member(s) who has/have dietary restriction - vegetarian: ");
		this.vegetarian = reader.nextInt();
		
		System.out.print("\nPlease enter number of member(s) who has/have dietary restriction - gluten-free: ");
		this.glutenFree = reader.nextInt();
		
		System.out.print("\nPlease enter number of member(s) who has/have dietary restriction - nut-free: ");
		this.nutFree = reader.nextInt();
		
		System.out.print("\nPlease enter number of member(s) who has/have dietary restriction - fish-free: ");
		this.fishFree = reader.nextInt();
		
		this.others = this.numOfOrders - this.vegetarian - this.glutenFree - this.nutFree - this.fishFree;

		// Confirm order with user
		confirmation();
	}
	
	// Same as method above, except it is strictly used for test mode.
	public void receivingOrder(int nO, int v, int g, int n, int f) {
		this.numOfOrders = nO;
		
		// Collecting Dietary Restrictions data (such as vegetarian, gluten free, nut free, and fish free) 
		this.vegetarian = v;
		this.glutenFree = g;
		this.nutFree = n;
		this.fishFree = f;
		this.others = this.numOfOrders - this.vegetarian - this.glutenFree - this.nutFree - this.fishFree;
	}
	
	// This method is used to confirm, cancel or edit order depends on user's input
	private void confirmation() {
		printOrder(-1);
		System.out.print("Enter Y to confirm, E to edit order, N to cancel order and exit program: ");
		
		String input = reader.next();
		if (input.equals("Y") || input.equals("y")) {
			System.out.println("Order Confirmed!");
		}
		
		else if (input.equals("E") || input.equals("e")) { // recurse back to receivingOrder() to collect order again
			receivingOrder();
		}
		
		else if (input.equals("N") || input.equals("n")) { // Order Cancelled, program exit.
			System.out.println("Exiting program!");
			System.exit(0);
		} else {
			System.out.println("Invalid input, please try again!"); // Ask user to retry entry for available options.
			confirmation();
		}
	}
	
	// This method will print out the detail of the our order before or after our confirmation
	public void printOrder(int mode) {
		// 0 is before we confirm our order, any # is after we confirm.
		if (mode == -1) {
			System.out.print("\nOrder Confirmation:");
		}
		else if (mode == -2) {
			System.out.print("\nOrder's Detail:");
		}
		else {
			System.out.print("\nOrder-" + mode + "'s Detail:");
		}
		System.out.print("\nTotal # of meals = " + this.numOfOrders + "\n# of Vegetarian Meal(s) = " + this.vegetarian + "\n# of Gluten-Free Meal(s) = " + this.glutenFree + "\n# of Nut-Free Meal(s) = " + this.nutFree + "\n# of Fish-Free Meal(s) = " + this.fishFree + "\n# of Other Meal(s) = " + this.others + "\n" );
	}
}
