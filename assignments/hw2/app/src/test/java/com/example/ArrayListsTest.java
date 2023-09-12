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

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class ArrayListsTest {
  @Test
  public void getTotal() {
    assertThat(ArrayLists.getTotal(new int[]{})).isEqualTo(0);
    assertThat(ArrayLists.getTotal(new int[]{1, 2, 3})).isEqualTo(6);
  }

  @Test
  public void getAverage() {
    assertThat(ArrayLists.getAverage(new int[]{})).isEqualTo(Double.NaN);
    assertThat(ArrayLists.getAverage(new int[]{1, 2, 3})).isEqualTo(2);
  }

  @Test
  public void getHighest() {
    assertThat(ArrayLists.getHighest(new int[]{})).isEqualTo(Integer.MIN_VALUE);
    assertThat(ArrayLists.getHighest(new int[]{1, 2, 3})).isEqualTo(3);
  }

  @Test
  public void getLowest() {
    assertThat(ArrayLists.getLowest(new int[]{})).isEqualTo(Integer.MAX_VALUE);
    assertThat(ArrayLists.getLowest(new int[]{1, 2, 3})).isEqualTo(1);
  }
}
