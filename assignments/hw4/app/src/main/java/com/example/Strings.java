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

import java.text.DecimalFormat;

/**
 * String utility class with no instance allowed.
 */
public class Strings {
  private static final DecimalFormat FORMAT_DOLLAR = new DecimalFormat("#.##");

  private Strings() { }

  /**
   * Returns true if input is blank, or true if empty.
   */
  public static boolean isBlank(String s) {
    return s == null || s.trim().isEmpty();
  }

  /**
   * Returns clean version for displaying money.
   */
  public static String dollarize(Object o) {
    String s = FORMAT_DOLLAR.format(o);
    if (!s.contains(".")) {
      return s;
    }
    return s.replaceAll("0*$", "").replaceAll("\\.$", "");
  }
}
