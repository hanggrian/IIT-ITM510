////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Balanced (grouping) symbols                            //
// Date: 10/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Application that shows whether grouping symbols imported from a    //
// text file are balanced.                                            //
////////////////////////////////////////////////////////////////////////

package ui;

import static java.lang.Double.MAX_VALUE;

import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;

/**
 * Main panel showing output messages.
 */
public class MainTextPane extends TitledPane {
  public final TextArea area = new TextArea();

  public MainTextPane() {
    area.setEditable(false);
    area.setPromptText("Waiting for input file.");

    setMaxHeight(MAX_VALUE);
    setCollapsible(false);
    setText("Messages");
    setContent(area);
  }
}
