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

import static javafx.scene.input.KeyCode.END;
import static javafx.scene.input.KeyCode.HOME;
import static javafx.scene.input.KeyCode.M;
import static javafx.scene.input.KeyCode.O;
import static javafx.scene.input.KeyCode.PAGE_DOWN;
import static javafx.scene.input.KeyCode.PAGE_UP;
import static javafx.scene.input.KeyCode.Q;
import static javafx.scene.input.KeyCombination.SHORTCUT_DOWN;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCodeCombination;

/**
 * Parent of menus placed at the center of the main window.
 */
public class MainMenuBar extends MenuBar {
  // file
  public final MenuItem import2 = new MenuItem("Import...");
  public final MenuItem quit = new MenuItem("Quit");
  // edit
  public final MenuItem change = new MenuItem("Change");
  public final MenuItem remove = new MenuItem("Remove");
  public final MenuItem clear = new MenuItem("Clear");
  // view
  public final MenuItem previous = new MenuItem("Previous");
  public final MenuItem next = new MenuItem("Next");
  public final MenuItem goToStart = new MenuItem("Go to Start");
  public final MenuItem goToEnd = new MenuItem("Go to End");
  // window
  public final MenuItem minimize = new MenuItem("Minimize");
  public final MenuItem zoom = new MenuItem("Zoom");
  // help
  public final MenuItem about = new MenuItem("About");

  public MainMenuBar() {
    import2.setAccelerator(new KeyCodeCombination(O, SHORTCUT_DOWN));
    quit.setAccelerator(new KeyCodeCombination(Q, SHORTCUT_DOWN));
    previous.setAccelerator(new KeyCodeCombination(PAGE_UP));
    next.setAccelerator(new KeyCodeCombination(PAGE_DOWN));
    goToStart.setAccelerator(new KeyCodeCombination(HOME));
    goToEnd.setAccelerator(new KeyCodeCombination(END));
    minimize.setAccelerator(new KeyCodeCombination(M, SHORTCUT_DOWN));

    getMenus().addAll(
        new Menu("File", null, import2, new SeparatorMenuItem(), quit),
        new Menu("Edit", null, change, new SeparatorMenuItem(), remove, clear),
        new Menu("View", null, previous, next, new SeparatorMenuItem(), goToStart, goToEnd),
        new Menu("Window", null, minimize, zoom),
        new Menu("Help", null, about)
    );
  }
}
