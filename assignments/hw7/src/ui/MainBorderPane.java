////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: ImageViewer (Generic Linked List)                      //
// Date: 06/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Sliding navigation with a side panel list showing current picture  //
// collection.                                                        //
////////////////////////////////////////////////////////////////////////

package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Parent of buttons placed at the bottom of the main window, and also a text indicator.
 */
public class MainBorderPane extends BorderPane {
  public final Button previous = new Button("Previous");
  public final Button next = new Button("Next");
  public final Label indicator = new Label();

  public MainBorderPane() {
    indicator.setPadding(new Insets(0, 10, 0, 10));

    setPadding(new Insets(20));
    setLeft(previous);
    setRight(next);
    setCenter(indicator);
  }
}
