////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

package ui;

import static javafx.beans.binding.Bindings.when;
import static javafx.scene.input.KeyCode.C;
import static javafx.scene.input.KeyCode.END;
import static javafx.scene.input.KeyCode.HOME;
import static javafx.scene.input.KeyCode.M;
import static javafx.scene.input.KeyCode.N;
import static javafx.scene.input.KeyCode.PAGE_DOWN;
import static javafx.scene.input.KeyCode.PAGE_UP;
import static javafx.scene.input.KeyCode.Q;
import static javafx.scene.input.KeyCode.R;
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
  public final MenuItem quit = new MenuItem("Quit");
  public final MenuItem resetAll = new MenuItem("Reset All");
  // edit
  public final MenuItem randomize = new MenuItem("Randomize");
  public final MenuItem create = new MenuItem("New");
  public final MenuItem edit = new MenuItem("Edit");
  public final MenuItem delete = new MenuItem("Delete");
  public final MenuItem save = new MenuItem("Save");
  // view
  public final MenuItem previous = new MenuItem("Previous");
  public final MenuItem next = new MenuItem("Next");
  public final MenuItem goToStart = new MenuItem("Go to Start");
  public final MenuItem goToEnd = new MenuItem("Go to End");
  // window
  public final MenuItem minimize = new MenuItem("Minimize");
  // help
  public final MenuItem about = new MenuItem("About");

  public MainMenuBar() {
    quit.setAccelerator(new KeyCodeCombination(Q, SHORTCUT_DOWN));
    randomize.setAccelerator(new KeyCodeCombination(R, SHORTCUT_DOWN));
    create.acceleratorProperty().bind(
        when(create.textProperty().isEqualTo("New"))
            .then(new KeyCodeCombination(N, SHORTCUT_DOWN))
            .otherwise(new KeyCodeCombination(C, SHORTCUT_DOWN))
    );
    previous.setAccelerator(new KeyCodeCombination(PAGE_UP));
    next.setAccelerator(new KeyCodeCombination(PAGE_DOWN));
    goToStart.setAccelerator(new KeyCodeCombination(HOME));
    goToEnd.setAccelerator(new KeyCodeCombination(END));
    minimize.setAccelerator(new KeyCodeCombination(M, SHORTCUT_DOWN));

    getMenus().addAll(
        new Menu("File", null, resetAll, new SeparatorMenuItem(), quit),
        new Menu(
            "Edit",
            null,
            randomize,
            new SeparatorMenuItem(),
            create,
            edit,
            delete,
            save
        ),
        new Menu("View", null, previous, next, new SeparatorMenuItem(), goToStart, goToEnd),
        new Menu("Window", null, minimize),
        new Menu("Help", null, about)
    );
  }
}
