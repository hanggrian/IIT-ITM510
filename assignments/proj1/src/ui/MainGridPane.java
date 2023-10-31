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

import static javafx.geometry.Pos.TOP_CENTER;
import static javafx.scene.layout.Priority.ALWAYS;

import java.util.Arrays;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Parent of text fields placed at the center of the main window.
 */
public class MainGridPane extends GridPane {
  public final TextField title = new TextField();
  public final TextField director = new TextField();
  public final DigitsTextField year = new DigitsTextField();
  public final TextField genre = new TextField();
  public final DigitsTextField runtime = new DigitsTextField();

  private int index = 0;

  public MainGridPane() {
    year.setMaxWidth(100);
    runtime.setMaxWidth(70);

    append("Title", title);
    append("Director", director);
    append("Year", year);
    append("Genre(s)", genre);
    append("Runtime", runtime);

    setAlignment(TOP_CENTER);
    setPadding(new Insets(5, 50, 5, 50));
    setHgap(10);
    setVgap(10);
    setHgrow(title, ALWAYS);
  }

  /**
   * Returns all text fields.
   */
  public List<TextField> getTextFields() {
    return Arrays.asList(title, director, year, genre, runtime);
  }

  private void append(String labelText, TextField field) {
    add(new Label(labelText + ":"), 0, index);
    add(field, 1, index++);
  }
}
