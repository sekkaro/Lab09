// package name
package edu.handong.csee.java.lab09;

// imports Scanner class to get user inputs
import java.util.Scanner;
//imports ArrayList class to use arraylist methods and use an dynamic array that doesnt have limited predefined size
import java.util.ArrayList;
/**
 * This is a SalesReporter class that prints out sales of salesman.
 * <p>
 * This class has methods: getData(),calculateAverageSales(),highestSales() and printOutResults()
 * that calculates the given data of sales and print out the results like maximum sales as a 
 * report.
 * @author Jun Seob Lee
 *
 */
// SalesReporter class
public class SalesReporter {
	// private class variables declared
	private double highestSales; // double variable to store highestSales
	private double averageSales; // double variable to store value of average of sales
	ArrayList<Salesman> team; // ArrayList of Salesman class called team that stores salesman instance as index and have each of its method

	/**
	 * This is the main method.
	 * <p>
	 * This method just calls different methods from the instances created in an order 
	 * and the actual calculations and results are given from the other methods.
	 * @param args user input that can be passed through
	 */
	// main method
	public static void main(String[] args) {
		// instance of the class SalesReporter
		SalesReporter myReporter = new SalesReporter(); // instance created using 'new' operator

		//various methods from instance in order 
		myReporter.getData(); // gets data from the user of the name and sales of salesmen
		myReporter.calculateAverageSales(); // calculates average from the sales
		myReporter.highestSales(); // calculates the highest one from all sales
		myReporter.printOutResults(); // prints out the report
	}

	/**
	 * This is a empty constructor of SalesReporter class.
	 * <p>
	 * This constructor basically asks the user to enter the number of salesman
	 * to get the size of arraylist team when the instance of the class is created.
	 */
	// SalesReporter constructor
	public SalesReporter() {
	}

	/**
	 * This is the getData() method that reads the detailed information of each salesman
	 * from the user.
	 * <p>
	 * This method guides the user to enter name and sales of each salesman and adds each of them 
	 * to the arraylist of salesman instances called team.
	 */
	// getData() method
	public void getData() {
		// defines the datatype of team arraylist to be of Salesman class
		team = new ArrayList<Salesman>(); // creates a instance of ArrayList of type Salesman class as team
		int i = 0; // initializes to value of i as 0

		Scanner check = new Scanner(System.in); // defines scanner to check if the user wants to keep reading
		// while loop to repeat until user types no and read salesmen as index of team 
		while(true){

			System.out.println("Enter data for associate number " + (i+1)); // guides the user what Salesman number it is
			System.out.print("Enter name: "); // guides the user to enter the name of salesman

			Scanner myScanner = new Scanner(System.in); // defines scanner instance to use it to read user inputs

			String name = myScanner.nextLine(); // reads the line as input which in turn stores it to a string name

			System.out.print("Enter sales: $"); // guides the user to enter the sales of salesman
			double sales = myScanner.nextDouble(); // reads the double value which in turn stores it to a variable called sales

			Salesman mySalesman = new Salesman(); // while running the loop over each of the index of array, let each index be an instance of the Salesman class
			mySalesman.setName(name); // uses setter method to set name for that particular team array element
			mySalesman.setSales(sales); // uses setter method to set sales for that particular team array element
			team.add(mySalesman); // uses .add() method of arraylist team to keeping adding salesman instance to its index and this increases the size of team
			i++; // increments variable i to keep check of how many salesman have been added

			System.out.print("Do you want to add data for more salesman? "); // guides the user if they want to keep adding more salesmen
			String test = check.nextLine(); // reads the user input as a line 

			// if the user types no (uses equalsIgnorecas3() method from string class to check without the cases)
			if(test.equalsIgnoreCase("no")) {
				break; // then get out of the loop and stop reading the input from user
			}
		}

	}

	/**
	 * This is the calculateAverageSales() method.
	 * <p>
	 * Like the name says, this method calculates the average of the sales from each 
	 * of the element of the team arraylist that are instances of the Salesman class.
	 */
	// calculateAverageSales() method
	public void calculateAverageSales() {
		double sum = 0; // initializes the sum as 0

		// for loop to cover every element of the team arraylist
		for(int i=0 ; i < team.size() ; i++) {
			sum = sum + team.get(i).getSales(); // adds all the sales by using getter method where each elements of team array are instances of Salesman class
		}

		averageSales = sum/team.size(); // calculates the average by dividing the calculated sum with the length of the team array and stores it to the variable defined in the class 
	}

	/**
	 * This is the highestSales() method.
	 * <p>
	 * This method calculates the maximum sales from all of the Salesman instances created.
	 */
	// highestSales() method
	public void highestSales() {
		highestSales = team.get(0).getSales(); // first sets the highestSales to be of the first element

		// uses for loop to get into each index of the team arraylist
		for(int i=0 ; i < team.size() ; i++) {
			// if the i+1(next element) does not give over bound exception and the current element's sales was less than the next element's sales, 
			if(((i+1) != team.size()) && (team.get(i).getSales() < team.get(i+1).getSales())) {
				highestSales = team.get(i+1).getSales(); // make the next element as the highest Sales
			}
		}

	}

	/**
	 * This is the printOutResults() method.
	 * <p>
	 * This basically puts all the calculated values together in order and 
	 * shows it like a sales report.
	 */
	// prints out the final report
	public void printOutResults() {
		System.out.println("\nAverage: $" + averageSales); // prints out the average sales that was calculated from method
		System.out.println("Highest Sales: $" + highestSales + "\n"); // print out the highest sales that was calculated from method

		System.out.println("The following had the highest Sales: "); // shows the details of the Salesman who had the highest sales
		// Since we dont know the index who had the highest Sales we run a for loop to check the whole arraylist
		for(int i = 0 ; i < team.size() ; i++) {
			// if the sale of the element of a particular index at that point was equal to the value of highest sales stored,
			if(team.get(i).getSales() == highestSales) {
				System.out.println("Name: " + team.get(i).getName()); // print out its name
				System.out.println("Sales: $" + team.get(i).getSales()); // and its sales
				System.out.println("$" + ((team.get(i).getSales())-(averageSales)) + " above the average."); // and show how much the Salesman had it above average
			}
		}

		System.out.println(); // prints out a \n to make it more nice and neat 

		System.out.println("The rest performed as follows: "); // now it shows how the rest of the elements except for the ones with highest Sale.
		// runs a for loop to check the whole arraylist
		for(int i = 0 ; i < team.size() ; i++) {
			// checks if the sales of that particular element is not the same as highest sales by using getter method
			if(team.get(i).getSales() != highestSales) {
				System.out.println("Name: " + team.get(i).getName()); // print out that Salesman's name
				System.out.println("Sales: $" + team.get(i).getSales()); // their sales
				// checks if the Sales of that Salesman element is below or above average
				if(team.get(i).getSales() < averageSales) {
					System.out.println("$" + ((averageSales)-(team.get(i).getSales())) + " below the average.\n"); // prints this message if the sale of the Salesman is below the average
				} // or else
				else {
					System.out.println("$" + ((team.get(i).getSales())-(averageSales)) + " above the average.\n"); // prints this message if the sale of the Salesman is above the average
				}
			}
		}


	}

}
