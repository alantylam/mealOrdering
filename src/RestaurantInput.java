/* Author: Alan Lam
 * Class name: RestaurantInput
 * Description: This class is used to read information of a .txt format text file, which has list of restaurants.
 * 				Also, it will store each restaurant's info in an Array List.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RestaurantInput {
	
	// Used to store all restaurant from text file
	private ArrayList<Restaurant> restaurantList;
	
	public RestaurantInput() {
		restaurantList = new ArrayList<Restaurant>();
		
		try {
			File file = new File("RestaurantList.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			// Parsing and adding restaurants into restaurantList which is the ArrayList that store all restaurants' info.
			while ((line = bufferedReader.readLine()) != null) {
				boolean added = false;
				String[] array = line.split(",");
				
				// While parsing through the .txt file, this will also sort restaurants in an ascending order base on their ranking.
				for (int i = 0; i < this.restaurantList.size(); i++) {
					Restaurant r = this.restaurantList.get(i);
					if (Integer.parseInt(array[1]) >= r.rating && !added) {
						this.restaurantList.add(i, new Restaurant(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]), Integer.parseInt(array[5]), Integer.parseInt(array[6])));
						added = true;
						break;
					}
				}
				if (!added) {
					this.restaurantList.add(new Restaurant(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]), Integer.parseInt(array[5]), Integer.parseInt(array[6])));
				}
			}
			
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			System.out.println("File does not exist!");
			System.exit(0);
		}
		
		printRestaurantList();
	}
	
	// Print out the existing list of restaurants
	public void printRestaurantList() {
		for (int i = 0; i < this.restaurantList.size(); i++) {
			Restaurant r = this.restaurantList.get(i);
			
			System.out.println("Restaurant Name: " + r.name);
			System.out.println("Restaurant's rating: " + r.rating + "/5");
			System.out.println("Maximum limit of orders: " + r.maxOrder);
			System.out.println("Number of available vegetarian meal(s): " + r.vegetarian);
			System.out.println("Number of available gluten-free meal(s): " + r.glutenFree);
			System.out.println("Number of available nut-free meal(s): " + r.nutFree);
			System.out.println("Number of available fish-free meal(s): " + r.fishFree);
			System.out.println("Number of other available meal(s): " + r.others + "\n");
		}
	}
	
	// return the restaurant list in ArrayList type
	public ArrayList<Restaurant> getRestaurantList() {
		return this.restaurantList;
	}
}
