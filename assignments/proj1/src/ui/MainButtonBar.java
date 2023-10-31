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

import static javafx.scene.control.ButtonBar.ButtonData.LEFT;
import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;
import static javafx.scene.control.ButtonBar.ButtonData.RIGHT;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;

/**
 * Parent of buttons placed at the bottom of the main window.
 */
public class MainButtonBar extends ButtonBar {
  // Navigation
  public final Button previous = new Button("<");
  public final Button next = new Button(">");
  // Default
  public final Button save = new Button("Save");
  // Others
  public final Button create = new Button("New");
  public final Button edit = new Button("Edit");
  public final Button delete = new Button("Delete");

  public MainButtonBar() {
    save.setDefaultButton(true);

    getButtons().addAll(previous, create, edit, delete, save, next);
    setPadding(new Insets(20));
    setButtonData(previous, LEFT);
    setButtonData(save, OK_DONE);
    setButtonData(next, RIGHT);
    setButtonUniformSize(create, false);
    setButtonUniformSize(edit, false);
    setButtonUniformSize(delete, false);
  }
}
