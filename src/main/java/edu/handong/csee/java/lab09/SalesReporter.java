package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private Salesman[] team;
	private int numOfSalesman;
	
	public static void main(String[] args) {
		SalesReporter myReporter = new SalesReporter();
		myReporter.getData();
		myReporter.calculateAverageSales();
		myReporter.highestSales();
		myReporter.printOutResults();
	}
	
	public SalesReporter() {
		System.out.println("Enter numer of salesman:");
		Scanner myScanner = new Scanner(System.in);
		
		numOfSalesman = myScanner.nextInt();
	}
	
	public void getData() {
		team = new Salesman[numOfSalesman];
		
		for(int i = 0 ; i < numOfSalesman ; i++) {
			Scanner myScanner = new Scanner(System.in);
			
			System.out.println("Enter data for associate number " + (i+1));
			System.out.print("Enter name: ");
			String name = myScanner.nextLine();
			
			System.out.print("Enter sales: $");
			double sales = myScanner.nextDouble();
			
			team[i] = new Salesman();
			team[i].setName(name);
			team[i].setSales(sales);
			
		}
		
	}
	
	public void calculateAverageSales() {
		double sum = 0;
		
		for(int i=0 ; i < team.length ; i++) {
			sum = sum + team[i].getSales();
		}
		
		averageSales = sum/team.length;
	}
	
	public void highestSales() {
		highestSales = team[0].getSales();
		
		for(int i=0 ; i < team.length ; i++) {
			if(((i+1) != team.length) && (team[i].getSales() < team[i+1].getSales())) {
				highestSales = team[i+1].getSales();
			}
		}
		
	}
	
	public void printOutResults() {
		System.out.println("\nAverage: $" + averageSales);
		System.out.println("Highest Sales: $" + highestSales + "\n");
		
		System.out.println("The following had the highest Sales: ");
		for(int i = 0 ; i < team.length ; i++) {
			if(team[i].getSales() == highestSales) {
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $" + team[i].getSales());
				System.out.println("$" + ((team[i].getSales())-(averageSales)) + " above the average.");
			}
		}
		
		System.out.println();
		
		System.out.println("The rest performed as follows: ");
		for(int i = 0 ; i < team.length ; i++) {
			if(team[i].getSales() != highestSales) {
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $" + team[i].getSales());
				if(team[i].getSales() < averageSales) {
					System.out.println("$" + ((averageSales)-(team[i].getSales())) + " below the average.");
				}
				else {
					System.out.println("$" + ((team[i].getSales())-(averageSales)) + " above the average.\n");
				}
			}
		}
		
		
	}

}
