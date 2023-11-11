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

import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;

/**
 * Side panel that shows the list of stack steps.
 */
public class MainListPane extends TitledPane {
  public final ListView<String> list = new ListView<>();
  public final Hyperlink placeholder = new Hyperlink("Open...");

  public MainListPane() {
    list.setMinWidth(150);
    list.setMaxWidth(150);
    list.setPlaceholder(placeholder);

    setMaxHeight(MAX_VALUE);
    setCollapsible(false);
    setText("Stacks");
    setContent(list);
  }
}
