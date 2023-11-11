////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Balanced (grouping) symbols                            //
// Date: 10/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Application that shows whether grouping symbols imported from a    //
// text file are balanced.                                            //
////////////////////////////////////////////////////////////////////////

import static javafx.scene.control.Alert.AlertType.INFORMATION;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * A JavaFX application that shows whether grouping symbols are balanced with a side panel showing
 * step-by-step progress.
 */
public class App extends Application {
  private static final String TITLE = "Grouping Symbols Instructor";

  private FileChooser chooser;
  private SymbolsView view;
  private ObjectProperty<GroupingSymbols> currentSymbols;

  public static void main(String[] args) {
    launch(App.class, args);
  }

  @Override
  public void init() {
    chooser = new FileChooser();
    chooser.setTitle(TITLE);
    chooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.TXT"));

    view = new SymbolsView();
    currentSymbols = new SimpleObjectProperty<>();
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle(TITLE);
    stage.setWidth(500);
    stage.setMinWidth(500);
    stage.setHeight(400);
    stage.setMinHeight(400);
    stage.setScene(new Scene(view));
    stage.show();

    view.bindControls(currentSymbols);

    view.menus.quit.setOnAction(event -> Platform.exit());
    view.menus.minimize.setOnAction(event -> stage.setIconified(true));
    view.menus.zoom.setOnAction(event -> stage.setMaximized(true));
    view.menus.about.setOnAction(event ->
        new Alert(INFORMATION,
            "A JavaFX app that shows whether grouping symbols are balanced with a side panel"
                + "showing step-by-step progress.")
            .showAndWait());

    view.menus.open.setOnAction(event -> {
      File file = chooser.showOpenDialog(stage);
      if (file != null) {
        currentSymbols.set(new GroupingSymbols(loadTextFile(file)));
      }
    });
  }

  private static String loadTextFile(File file) {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Error loading file %s: %s%n", file.getName(), e.getMessage())
      );
    }
    return sb.toString();
  }
}
