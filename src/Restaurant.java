/* Author: Alan Lam
 * Class name: Restaurant
 * Description: This class is used to store information of a restaurant.
 * 				For example, the maximum amount of orders they accept, how many vegetarian meal(s) do they serve and etc.
 */

public class Restaurant {
	public String name;
	public int rating;
	public int maxOrder;
	public int vegetarian;
	public int glutenFree;
	public int nutFree;
	public int fishFree;
	public int others;
	
	// Initialize values for variables.
	public Restaurant(String name, int rating, int maxOrder, int vegetarian, int glutenFree, int nutFree, int fishFree) {
		this.name = name;
		this.rating = rating;
		this.maxOrder = maxOrder;
		this.vegetarian = vegetarian;
		this.glutenFree = glutenFree;
		this.nutFree = nutFree;
		this.fishFree = fishFree;
		
		this.others = this.maxOrder - this.vegetarian - this.glutenFree - this.nutFree - this.fishFree;
	}
	
}
