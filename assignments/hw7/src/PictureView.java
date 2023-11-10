////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: ImageViewer (Generic Linked List)                      //
// Date: 06/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Sliding navigation with a side panel list showing current picture  //
// collection.                                                        //
////////////////////////////////////////////////////////////////////////

import static javafx.beans.binding.Bindings.createBooleanBinding;
import static javafx.beans.binding.Bindings.createStringBinding;
import static javafx.beans.binding.Bindings.equal;
import static javafx.beans.binding.Bindings.isEmpty;
import static javafx.beans.binding.Bindings.or;
import static javafx.beans.binding.Bindings.size;
import static javafx.scene.layout.Priority.ALWAYS;

import java.io.File;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import ui.MainBorderPane;
import ui.MainListView;
import ui.MainMenuBar;

/**
 * All JavaFX controls in the main window, contained in a grid layout.
 */
public class PictureView extends GridPane {
  public final MainMenuBar menus = new MainMenuBar();
  public final MainBorderPane bars = new MainBorderPane();
  public final MainListView list = new MainListView();
  public final ImageView image = new ImageView();

  public PictureView() {
    image.setPreserveRatio(true);

    BorderPane imageParent = new BorderPane(image);
    add(menus, 0, 0, 2, 1);
    add(imageParent, 0, 1);
    add(bars, 0, 2);
    add(list, 1, 1, 1, 2);
    setHgrow(imageParent, ALWAYS);
    setVgrow(imageParent, ALWAYS);
  }

  /**
   * Bind the text and disability properties of all controls. The secondary click listeners are
   * bound to the primary counterpart. However, the primary listeners need to be declared outside
   * this class.
   *
   * @param images obtained from controller.
   * @param index  guaranteed to be in bounds.
   */
  public void bindControls(DLinkedList<File> images, IntegerProperty index) {
    image.fitWidthProperty().bind(widthProperty()
        .subtract(list.widthProperty()));
    image.fitHeightProperty().bind(heightProperty()
        .subtract(menus.heightProperty())
        .subtract(bars.heightProperty()));

    bars.indicator.textProperty().bind(createStringBinding(() -> {
      if (images.isEmpty()) {
        return "No images.";
      }
      return String.format("%d. %s", index.get() + 1, images.get(index.get()));
    }, list.getItems(), index));

    bindMenuToButton(
        menus.previous,
        bars.previous,
        or(isEmpty(list.getItems()),
            equal(index, 0)));
    bindMenuToButton(
        menus.next,
        bars.next,
        or(isEmpty(list.getItems()),
            equal(index, size(list.getItems()).subtract(1))));

    menus.goToStart.disableProperty().bind(bars.previous.disableProperty());
    menus.goToEnd.disableProperty().bind(bars.next.disableProperty());

    bindMenuToMenu(menus.import2, list.import2, createBooleanBinding(() -> false));
    bindMenuToMenu(
        menus.change,
        list.change,
        list.getSelectionModel().selectedItemProperty().isNull());
    bindMenuToMenu(
        menus.remove,
        list.remove,
        list.getSelectionModel().selectedItemProperty().isNull());
    bindMenuToMenu(
        menus.clear,
        list.clear,
        isEmpty(list.getItems()));

    list.import2Placeholder.onActionProperty().bind(list.import2.onActionProperty());
  }

  private void bindMenuToButton(MenuItem menu, Button button, BooleanBinding disabilityBinding) {
    button.disableProperty().bind(disabilityBinding);
    menu.disableProperty().bind(button.disableProperty());
    menu.onActionProperty().bind(button.onActionProperty());
  }

  private void bindMenuToMenu(MenuItem menu1, MenuItem menu2, BooleanBinding disabilityBinding) {
    menu2.disableProperty().bind(disabilityBinding);
    menu1.disableProperty().bind(menu2.disableProperty());
    menu1.onActionProperty().bind(menu2.onActionProperty());
  }

  /**
   * Assign image from a file, or clear if null.
   *
   * @param picture nullable file.
   */
  public void displayPicture(File picture) {
    image.setImage(picture == null ? null : new Image(picture.toURI().toString()));
  }
}
