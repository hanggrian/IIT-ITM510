////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Balanced (grouping) symbols                            //
// Date: 10/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Application that shows whether grouping symbols imported from a    //
// text file are balanced.                                            //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GroupingSymbolsTest {
  @Test
  public void isBalanced() {
    assertFalse(new GroupingSymbols("{{(a(b)[]}}").isBalanced());
    assertFalse(new GroupingSymbols("(a{b)}").isBalanced());
    assertTrue(new GroupingSymbols("()[]{}<>").isBalanced());
    assertTrue(new GroupingSymbols("[{()<>}]").isBalanced());
  }
}
