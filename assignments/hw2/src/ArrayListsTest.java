////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 7.1 ArrayList Operations                            //
// Date: 12/09/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A program that prints total, average, highest and lowest value of  //
// a randomly generated list.                                         //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayListsTest {
  @Test
  public void getTotal() {
    assertEquals(0, ArrayLists.getTotal(new int[]{}));
    assertEquals(6, ArrayLists.getTotal(new int[]{1, 2, 3}));
  }

  @Test
  public void getAverage() {
    assertEquals(Double.NaN, ArrayLists.getAverage(new int[]{}), 0);
    assertEquals(2, ArrayLists.getAverage(new int[]{1, 2, 3}), 0);
  }

  @Test
  public void getHighest() {
    assertEquals(Integer.MIN_VALUE, ArrayLists.getHighest(new int[]{}));
    assertEquals(3, ArrayLists.getHighest(new int[]{1, 2, 3}));
  }

  @Test
  public void getLowest() {
    assertEquals(Integer.MAX_VALUE, ArrayLists.getLowest(new int[]{}));
    assertEquals(1, ArrayLists.getLowest(new int[]{1, 2, 3}));
  }
}
