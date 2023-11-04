////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 12.1 Tip, Tax, and Total                            //
// Date: 02/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Single-window JavaFX app that takes food orders and calculate      //
// their prices at the bottom.                                        //
////////////////////////////////////////////////////////////////////////

package ui;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

/**
 * A simple text dialog with a close button.
 */
public class InfoDialog extends Dialog<Void> {
  public InfoDialog(String title, String content) {
    this(title, content, null);
  }

  public InfoDialog(String title, String content, String expandedContent) {
    setTitle(title);
    setHeaderText(title);
    setContentText(content);
    getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

    if (expandedContent != null) {
      getDialogPane().setExpandableContent(new Label(expandedContent));
    }
  }
}
