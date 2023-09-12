////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 7.1 ArrayList Operations                            //
// Date: 12/09/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A program that prints total, average, highest and lowest value of  //
// a randomly generated list.                                         //
////////////////////////////////////////////////////////////////////////

package com.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Utility class to perform analytical calculations of integers, in form of list or array.
 */
public class ArrayLists {
  /**
   * Makes sure no instance is created.
   */
  private ArrayLists() {
  }

  /**
   * Returns the total of the values in this array.
   *
   * @param array input array.
   */
  public static int getTotal(int[] array) {
    return getTotal(Arrays.stream(array).boxed().collect(Collectors.toList()));
  }

  /**
   * Returns the total of the values in this list.
   *
   * @param collection input list, cannot be null.
   */
  public static int getTotal(Collection<Integer> collection) {
    Objects.requireNonNull(collection);
    int total = 0;
    for (int element : collection) {
      total += element;
    }
    return total;
  }

  /**
   * Returns the average of the values in this array.
   *
   * @param array input array.
   */
  public static double getAverage(int[] array) {
    return getAverage(Arrays.stream(array).boxed().collect(Collectors.toList()));
  }

  /**
   * Returns the average of the values in this array.
   *
   * @param collection input list, cannot be null.
   */
  public static double getAverage(Collection<Integer> collection) {
    int total = getTotal(collection);
    int size = collection.size();
    return (double) total / size;
  }

  /**
   * Returns the highest value in this array.
   *
   * @param array input array.
   */
  public static int getHighest(int[] array) {
    return getHighest(Arrays.stream(array).boxed().collect(Collectors.toList()));
  }

  /**
   * Returns the highest value in this list.
   *
   * @param collection input list, cannot be null.
   */
  public static int getHighest(Collection<Integer> collection) {
    Objects.requireNonNull(collection);
    int highest = Integer.MIN_VALUE;
    for (int element : collection) {
      highest = Math.max(highest, element);
    }
    return highest;
  }

  /**
   * Returns the lowest value in this array.
   *
   * @param array input array.
   */
  public static int getLowest(int[] array) {
    return getLowest(Arrays.stream(array).boxed().collect(Collectors.toList()));
  }

  /**
   * Returns the lowest value in this list.
   *
   * @param collection input list, cannot be null.
   */
  public static int getLowest(Collection<Integer> collection) {
    Objects.requireNonNull(collection);
    int lowest = Integer.MAX_VALUE;
    for (int element : collection) {
      lowest = Math.min(lowest, element);
    }
    return lowest;
  }
}
