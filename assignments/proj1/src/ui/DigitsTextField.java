////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 31/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A JavaFX application that manages movie library with MVC design    //
// pattern in the form of sliding navigation window.                  //
////////////////////////////////////////////////////////////////////////

package ui;

import javafx.scene.control.TextField;

/**
 * A text field that limits value to non-decimal numeric input. Taken from
 * <a url="https://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx">StackOverflow</a>.
 */
public class DigitsTextField extends TextField {
  public DigitsTextField() {
    textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d*")) {
        setText(newValue.replaceAll("[^\\d]", ""));
      }
    });
  }

  /**
   * Returns parsed integer from the text.
   *
   * @return a number, or 0 if text is empty.
   */
  public int getValue() {
    if (getText().trim().isEmpty()) {
      return 0;
    }
    return Integer.valueOf(getText());
  }
}
