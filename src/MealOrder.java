/* Author: Alan Lam
 * Class name: MealOrder
 * Description: This is the main class for this program. Its feature is to call functions from different classes to complete a best possible
 * 				meal order from available restaurant(s).
 */

public class MealOrder {
	public static void main(String[] args) {
		RestaurantInput input = new RestaurantInput(); // read list of available restaurant(s)
		Order newOrder = new Order(); // create a new order
		newOrder.printOrder(1); // print the final order from us
		
		OrderProcessing op = new OrderProcessing(newOrder, input.getRestaurantList());
		op.process(); // process our final order
		if (op.orderFulfilled())
			op.printRestaurantsOrders(); // print out the solution to our order
		else
			System.out.println("Sorry we are not able to fulfill your orders, please reduce orders!");
	}
}
