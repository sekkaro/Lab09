// package name
package edu.handong.csee.java.lab09;

/**
 * This is the Salesman class.
 * <p>
 * This class has setter and getter methods for two of its variables,
 * one for name and other for the sales of the salesman.
 * @author Jun Seob Lee
 *
 */
// Salesman class
public class Salesman {
	private String name; // name of Salesman
	private double sales; // sales of Salesman
	
	/**
	 * This is the getter method for name.
	 * <p>
	 * This getter method basically lets the user to 'get' the name of the Salesman.
	 * @return string variable that is the name of the Salesman
	 */
	//getter method for name
	public String getName() {
		return name; // returns the name
	}
	
	/**
	 * This is the setter method for name.
	 * <p>
	 * This setter method basically lets the user to 'set' the value of name of the Salesman.
	 * @param name a string variable that stores the name of the Salesman
	 */
	//setter method for name
	public void setName(String name) {
		this.name = name; // sets passed parameter as name
	}
	
	/**
	 * This is the getter method for sales.
	 * <p>
	 * This getter method basically lets the user to 'get' the sales of the Salesman.
	 * @return double variable that stores sale of the Salesman
	 */
	//getter method for sales
	public double getSales() {
		return sales; // returns value of sales
	}
	
	/**
	 * This is the setter method for sales.
	 * <p>
	 * This setter method basically lets the user to 'set' the value of the sale of the Salesman.
	 * @param sales a double variable that stores the sales of the Salesman
	 */
	//setter method for sales
	public void setSales(double sales) {
		this.sales = sales; //sets passed parameter as sales
	}
	
}
