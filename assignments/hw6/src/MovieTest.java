////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 29/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A recursive CLI app that manages movie library using MVC design    //
// pattern.                                                           //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class MovieTest {
  @Test
  public void constructor() {
    assertThrows(NullPointerException.class, () -> new Movie(null, null, 1900, null, 1));
    assertThrows(
        IllegalArgumentException.class,
        () -> new Movie("Hello", "World", 1899, "Something", 0)
    );
  }
}
