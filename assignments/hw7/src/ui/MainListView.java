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

import static javafx.scene.control.SelectionMode.SINGLE;

import java.io.File;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

/**
 * Side panel that displays picture collection. Add or remove items using menu bar or context menu.
 */
public class MainListView extends ListView<File> {
  // context
  public final MenuItem import2 = new MenuItem("Import...");
  public final MenuItem change = new MenuItem("Change");
  public final MenuItem remove = new MenuItem("Remove");
  public final MenuItem clear = new MenuItem("Clear");
  // placeholder
  public final Hyperlink placeholder = new Hyperlink("Import...");

  public MainListView() {
    setContextMenu(new ContextMenu(import2, change, new SeparatorMenuItem(), remove, clear));
    setPlaceholder(placeholder);
    setMinWidth(200);
    setMaxWidth(200);
    getSelectionModel().setSelectionMode(SINGLE);
    setCellFactory(param -> new FileListCell());
  }

  private class FileListCell extends ListCell<File> {
    @Override
    protected void updateItem(File item, boolean empty) {
      super.updateItem(item, empty);
      if (item == null) {
        setGraphic(null);
        setText(null);
        return;
      }
      setGraphic(new Label(String.format("%d.", getItems().indexOf(item) + 1)));
      setText(item.getName());
    }
  }
}
