/* Author: Alan Lam
 * Class name: RestaurantOrder
 * Description: This class is used to store our order for each restaurant.
 * 				For example, how many vegetarian meal(s) we are ordering from this restaurant and etc.
 */

public class RestaurantOrder {
	private String restaurantName;
	private int vegetarianMeal;
	private int glutenFreeMeal;
	private int nutFreeMeal;
	private int fishFreeMeal;
	private int otherMeal;
	
	// Initialize values for each type of meal
	public RestaurantOrder(String name) {
		this.restaurantName = name;
		this.vegetarianMeal = 0;
		this.glutenFreeMeal = 0;
		this.nutFreeMeal = 0;
		this.fishFreeMeal = 0;
		this.otherMeal = 0;
	}
	
	// Setter for different type of meals
	public void setVegetarianMeal(int v) {
		this.vegetarianMeal = v;
	}
	
	public void setGlutenFreeMeal(int g) {
		this.glutenFreeMeal = g;
	}
	
	public void setNutFreeMeal(int n) {
		this.nutFreeMeal = n;
	}
	
	public void setFishFreeMeal(int f) {
		this.fishFreeMeal = f;
	}
	
	public void setOtherMeal(int o) {
		this.otherMeal = o;
	}
	
	// return Restaurant's name
	public String getRestName() {
		return this.restaurantName;
	}
	
	// Getter for different type of meals
	public int getVegetarianMeal() {
		return this.vegetarianMeal;
	}
	
	public int getGlutenFreeMeal() {
		return this.glutenFreeMeal;
	}
	
	public int getNutFreeMeal() {
		return this.nutFreeMeal;
	}
	
	public int getFishFreeMeal() {
		return this.fishFreeMeal;
	}
	
	public int getOtherMeal() {
		return this.otherMeal;
	}
}
