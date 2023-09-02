package com.example;

/**
 * Prints employees in standard output stream, triggered by {@code ./gradle run}.
 */
public class App {
  public static void main(String[] args) {
    Employee susan = new Employee("Susan Meyers", 8647765, "IT", "Sr Programmer/Analyst");
    Employee ahmad = new Employee("Ahmad Karim", 5424130, "Purchasing", "Manager");
    Employee alfonso = new Employee("Alfonso Kirkpatrick", 1243452, "Sales", "Vice President");

    System.out.println("Employees:");
    System.out.println("1. " + susan);
    System.out.println("2. " + ahmad);
    System.out.println("3. " + alfonso);
  }
}
