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

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.Alert.AlertType.INFORMATION;
import static javafx.scene.control.ButtonType.OK;

import javafx.scene.control.Alert;

/**
 * Utility class to display simple dialogs.
 */
public final class Alerts {
  private Alerts() {
  }

  /**
   * Show information dialog.
   *
   * @param text label content.
   */
  public static void info(String text) {
    new Alert(INFORMATION, text).showAndWait();
  }

  /**
   * Show error dialog.
   *
   * @param text label content.
   */
  public static void error(String text) {
    new Alert(ERROR, text).showAndWait();
  }

  /**
   * Show confirmation dialog.
   *
   * @param text   label content.
   * @param action listener when user selects OK.
   */
  public static void confirm(String text, Runnable action) {
    new Alert(CONFIRMATION, text).showAndWait().ifPresent(buttonType -> {
      if (buttonType == OK && action != null) {
        action.run();
      }
    });
  }
}
