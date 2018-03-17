/* Author: Alan Lam
 * Class name: MealOrder
 * Description: This is the main class for this program. Its feature is to call functions from different classes to complete a best possible
 * 				meal order from available restaurant(s).
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MealOrder {
	public static void main(String[] args) {
		System.out.println();
		ArrayList<String[]> testOrders = new ArrayList<String[]>();
		
		RestaurantInput input = new RestaurantInput(); // read list of available restaurant(s)
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter 0 for \"Test Mode\" or any number for \"User Input Mode\": ");
		int mode = reader.nextInt();
		Order newOrder = new Order(); // create a new order
		
		// Enter test mode if user input is 0
		if (mode == 0) {
			loadTestInputs(testOrders);
			testMode(newOrder, input, testOrders);
		}
		
		// else enter user input mode, which allow user to input their order
		else
			userInputMode(newOrder, input);
		
		reader.close();
		newOrder.reader.close();
	}
	
	// Test mode will load orders from existing OrderList.txt file, then loop through the list and show the ideal solution for each order.
	public static void testMode(Order newOrder, RestaurantInput input, ArrayList<String[]> tOrders) {
		ArrayList<String[]> testInputs = tOrders;
		
		// Loop through the list of test orders
		for (int i = 0; i < testInputs.size(); i++) {
			String[] order = testInputs.get(i);
			newOrder.receivingOrder(Integer.parseInt(order[0]), Integer.parseInt(order[1]), Integer.parseInt(order[2]), Integer.parseInt(order[3]), Integer.parseInt(order[4]));
			newOrder.printOrder(i+1); // print the final order
			
			proceedOrder(newOrder, input.getRestaurantList());
		}
		
		System.out.println("Tests completed!\n");
	}
	
	// User input mode, user can enter his/her input and see the ideal solution for his/her order
	public static void userInputMode(Order newOrder, RestaurantInput input) {
		newOrder.receivingOrder();
		newOrder.printOrder(-2); // print the final order from us
		proceedOrder(newOrder, input.getRestaurantList());
	}
	
	// Process order base on input
	public static void proceedOrder(Order newOrder, ArrayList<Restaurant> rList) {
		OrderProcessing op = new OrderProcessing(newOrder, rList);
		op.process(); // process our final order
		if (op.orderFulfilled())
			op.printRestaurantsOrders(); // print out the solution to our order
		else
			System.out.println("Sorry we are not able to fulfill your orders, please reduce orders!");
	}
	
	// Load test inputs from OrderList.txt, then store in testOrders.
	public static void loadTestInputs(ArrayList<String[]> testOrders) {
		
		try {
			File file = new File("OrderList.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			// ** Parsing and adding restaurants into restaurantList which is the ArrayList that store all restaurants' info.
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(",");
				// ** While parsing through the .txt file, this will also sort restaurants in an ascending order base on their ranking.
				testOrders.add(array);
			}
			bufferedReader.close();
			fileReader.close();
			
		} catch (IOException e) {
			System.out.println("Test user input file does not exist!");
			System.exit(0);
		}
	}
}
