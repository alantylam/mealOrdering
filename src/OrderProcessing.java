/* Author: Alan Lam
 * Class name: OrderProcessing
 * Description: This class is used to distribute our orders to different restaurants and achieve the best result for our members.
 */

import java.util.ArrayList;

public class OrderProcessing {
	private boolean of;
	private Order order;
	private ArrayList<Restaurant> restaurantList; // List of available restaurants
	private ArrayList<RestaurantOrder> restaurantsOrders; // Used to store our orders for different restaurants
	
	// Initializing variables
	public OrderProcessing(Order o, ArrayList<Restaurant> rList) {
		this.order = o;
		this.restaurantList = rList;
		this.restaurantsOrders = new ArrayList<RestaurantOrder>();
		this.of = false;
	}
	
	// Go through the (Sorted) list of restaurants, and order as much as possible and needed from the highest rating restaurant.
	// Then move on to the next one on the list.
	public void process() {
		// Keep track of remaining orders we need to fulfill.
		int remaining_numOfOrders;
		int remaining_vegetarian = order.vegetarian;
		int remaining_glutenFree = order.glutenFree;
		int remaining_nutFree = order.nutFree;
		int remaining_fishFree = order.fishFree;
		int remaining_others = order.others;
		
		// this for loop will get as much orders as possible from the higher rating restaurants.
		for (int i = 0; i < this.restaurantList.size(); i ++) {
			Restaurant r = this.restaurantList.get(i);
			RestaurantOrder rOrder = new RestaurantOrder(r.name); // Temporarily store restaurant from the list to variable: rOrder.
			
			remaining_numOfOrders = remaining_vegetarian + remaining_glutenFree + remaining_nutFree + remaining_fishFree + remaining_others;
			
			// Check if we need more orders.
			if (remaining_numOfOrders == 0)
				break;
			
			// used for temporarily storage for integer.
			int temp;
			
			// Fulfilling orders for Vegetarian Meals
			if (r.vegetarian > 0 && remaining_vegetarian > 0) {
				if (r.vegetarian > remaining_vegetarian) {
					temp = remaining_vegetarian;
					remaining_vegetarian = 0;
				}
				else {
					temp = r.vegetarian;
					remaining_vegetarian -= r.vegetarian;
				}
				
				rOrder.setVegetarianMeal(temp);
			}
			
			// Fulfilling orders for Gluten-free Meals
			if (r.glutenFree > 0 && remaining_glutenFree > 0) {
				if (r.glutenFree > remaining_glutenFree) {
					temp = remaining_glutenFree;
					remaining_glutenFree = 0;
				}
				else {
					temp = r.glutenFree;
					remaining_glutenFree -= r.glutenFree;
				}
				
				rOrder.setGlutenFreeMeal(temp);
			}
			
			// Fulfilling orders for Nut-free Meals
			if (r.nutFree > 0 && remaining_nutFree > 0) {
				if (r.nutFree > remaining_nutFree) {
					temp = remaining_nutFree;
					remaining_nutFree = 0;
				}
				else {
					temp = r.nutFree;
					remaining_nutFree -= r.nutFree;
				}
				
				rOrder.setNutFreeMeal(temp);
			}
			
			// Fulfilling orders for Fish-free Meals
			if (r.fishFree > 0 && remaining_fishFree > 0) {
				if (r.fishFree > remaining_fishFree) {
					temp = remaining_fishFree;
					remaining_fishFree = 0;
				}
				else {
					temp = r.fishFree;
					remaining_fishFree -= r.fishFree;
				}
				
				rOrder.setFishFreeMeal(temp);
			}
			
			// Fulfilling orders for other Meals
			if (r.others > 0 && remaining_others > 0) {
				if (r.others > remaining_others) {
					temp = remaining_others;
					remaining_others = 0;
				}
				else {
					temp = r.others;
					remaining_others -= r.others;
				}
				
				rOrder.setOtherMeal(temp);
			}
			this.restaurantsOrders.add(rOrder);
		}
		
		remaining_numOfOrders = remaining_vegetarian + remaining_glutenFree + remaining_nutFree + remaining_fishFree + remaining_others;
		if (remaining_numOfOrders == 0) {
			this.of = true;
		}
	}
	
	// Print out orders for different restaurant based off the result we got from the algorithm above
	public void printRestaurantsOrders() {
		System.out.println("\n---Solution---START---\n");
		for (int i = 0; i < this.restaurantsOrders.size(); i++) {
			RestaurantOrder ro = this.restaurantsOrders.get(i);
			
			System.out.print("Order for " + ro.getRestName() + ":\n");
			if (ro.getVegetarianMeal() > 0)
				System.out.print("Vegetrian Meal Order(s) = " + ro.getVegetarianMeal() + "\n");
			
			if (ro.getGlutenFreeMeal() > 0)
				System.out.print("Gluten-Free Meal Order(s) = " + ro.getGlutenFreeMeal() + "\n");
			
			if (ro.getNutFreeMeal() > 0)
				System.out.print("Nut-Free Meal Order(s) = " + ro.getNutFreeMeal() + "\n");
			
			if (ro.getFishFreeMeal() > 0)
				System.out.print("Fish-Free Meal Order(s) = " + ro.getFishFreeMeal() + "\n");
			
			if (ro.getOtherMeal() > 0)
				System.out.print("Other Meal Order(s) = " + ro.getOtherMeal() + "\n");
			
			System.out.println();
		}
		System.out.println("\n---Solution---END---\n");
	}
	
	public boolean orderFulfilled() {
		return of;
	}
}
