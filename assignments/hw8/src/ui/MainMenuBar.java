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

import static javafx.scene.input.KeyCode.M;
import static javafx.scene.input.KeyCode.O;
import static javafx.scene.input.KeyCode.Q;
import static javafx.scene.input.KeyCombination.SHORTCUT_DOWN;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCodeCombination;

/**
 * The main menu bar.
 */
public class MainMenuBar extends MenuBar {
  // file
  public final MenuItem open = new MenuItem("Open...");
  public final MenuItem quit = new MenuItem("Quit");
  // window
  public final MenuItem minimize = new MenuItem("Minimize");
  public final MenuItem zoom = new MenuItem("Zoom");
  // help
  public final MenuItem about = new MenuItem("About");

  public MainMenuBar() {
    open.setAccelerator(new KeyCodeCombination(O, SHORTCUT_DOWN));
    quit.setAccelerator(new KeyCodeCombination(Q, SHORTCUT_DOWN));
    minimize.setAccelerator(new KeyCodeCombination(M, SHORTCUT_DOWN));

    getMenus().addAll(
        new Menu("File", null, open, new SeparatorMenuItem(), quit),
        new Menu("Window", null, minimize, zoom),
        new Menu("Help", null, about)
    );
  }
}
