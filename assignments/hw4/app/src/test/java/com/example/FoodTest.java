////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 12.1 Tip, Tax, and Total                            //
// Date: 02/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Single-window JavaFX app that takes food orders and calculate      //
// their prices at the bottom.                                        //
////////////////////////////////////////////////////////////////////////

package com.example;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class FoodTest {
  @Test
  public void constructor() {
    assertThrows(IllegalArgumentException.class, () -> new Food(null, 0));
    assertThrows(IllegalArgumentException.class, () -> new Food("", 0));
  }
}
