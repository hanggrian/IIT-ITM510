////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 7.1 ArrayList Operations                            //
// Date: 12/09/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A program that prints total, average, highest and lowest value of  //
// a randomly generated list.                                         //
////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Prints total, average, highest, and lowest of a list of integers.
 */
public class App {
  private static final int LIST_SIZE = 200;
  private static final int LIST_HIGHEST_VALUE = 150;
  private static final int LIST_LOWEST_VALUE = -50;

  public static void main(String[] args) {
    // populate list
    Random random = new Random();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < LIST_SIZE; i++) {
      list.add(random.nextInt(LIST_HIGHEST_VALUE + 1 - LIST_LOWEST_VALUE) + LIST_LOWEST_VALUE);
    }

    // print result
    System.out.printf("Total = %,d%n", ArrayLists.getTotal(list));
    System.out.printf("Average = %.2f%n", ArrayLists.getAverage(list));
    System.out.printf("Highest = %,d%n", ArrayLists.getHighest(list));
    System.out.printf("Lowest = %,d%n", ArrayLists.getLowest(list));
  }
}
