////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Balanced (grouping) symbols                            //
// Date: 10/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Application that shows whether grouping symbols imported from a    //
// text file are balanced.                                            //
////////////////////////////////////////////////////////////////////////

import static javafx.beans.binding.Bindings.createObjectBinding;
import static javafx.beans.binding.Bindings.createStringBinding;
import static javafx.collections.FXCollections.emptyObservableList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.scene.layout.Priority.ALWAYS;

import javafx.beans.property.ObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ui.MainListPane;
import ui.MainMenuBar;
import ui.MainTextPane;

/**
 * Root layout that will be placed in a window.
 */
public class SymbolsView extends VBox {
  public final MainMenuBar menus = new MainMenuBar();
  public final MainTextPane text = new MainTextPane();
  public final MainListPane info = new MainListPane();

  public SymbolsView() {
    HBox parent = new HBox();
    parent.setPadding(new Insets(20));
    parent.setSpacing(20);
    parent.getChildren().addAll(text, info);

    getChildren().addAll(menus, parent);
    HBox.setHgrow(text, ALWAYS);
    setVgrow(parent, ALWAYS);
  }

  /**
   * Bind all controls to the given property.
   */
  public void bindControls(ObjectProperty<GroupingSymbols> currentSymbols) {
    text.area.textProperty().bind(createStringBinding(() -> {
      GroupingSymbols symbols = currentSymbols.get();
      if (symbols == null) {
        return "";
      }
      return symbols.toString();
    }, currentSymbols));
    info.list.itemsProperty().bind(createObjectBinding(() -> {
      GroupingSymbols symbols = currentSymbols.get();
      if (symbols == null) {
        return emptyObservableList();
      }
      return observableArrayList(symbols.stackSteps);
    }, currentSymbols));

    info.placeholder.onActionProperty().bind(menus.open.onActionProperty());
  }
}
