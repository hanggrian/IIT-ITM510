////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: ImageViewer (Generic Linked List)                      //
// Date: 06/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Sliding navigation with a side panel list showing current picture  //
// collection.                                                        //
////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ui.Alerts;

/**
 * A picture viewer with a side panel in a form of single window application. There are 2
 * collections maintained by this application:
 *
 * <ol>
 *  <li>DLinkedList - a custom list implementation for main navigation.</li>
 *  <li>ObservableList - standard JavaFX list for side panel.</li>
 * </ol>
 */
public class App extends Application {
  private static final String TITLE = "Picture Viewer";

  private FileChooser chooser;
  private PictureView view;
  private PictureController controller;

  public static void main(String[] args) {
    launch(App.class, args);
  }

  @Override
  public void init() {
    chooser = new FileChooser();
    chooser.setTitle(TITLE);
    chooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.PNG", "*.jpg", "*.JPG"));

    view = new PictureView();
    controller = new PictureController();
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle(TITLE);
    stage.setMinWidth(600);
    stage.setMinHeight(400);
    stage.setScene(new Scene(view));
    stage.show();

    view.bindControls(controller.fileList, controller.currentFileIndex);

    view.menus.quit.setOnAction(event -> Platform.exit());
    view.menus.minimize.setOnAction(event -> stage.setIconified(true));
    view.menus.zoom.setOnAction(event -> stage.setMaximized(true));
    view.menus.about.setOnAction(event ->
        Alerts.info("A simple JavaFX picture viewer with a side panel."));

    view.list.import2.setOnAction(event -> {
      List<File> files = chooser.showOpenMultipleDialog(stage);
      if (files == null) {
        return;
      }
      if (files.stream().anyMatch(file -> view.list.getItems().contains(file))) {
        Alerts.error("One or more files are already on the list.");
        return;
      }
      controller.createPictures(files);
      view.list.getItems().addAll(files);
      view.displayPicture(controller.getCurrentPicture());
    });
    view.list.change.setOnAction(event -> {
      File file = chooser.showOpenDialog(stage);
      if (file == null) {
        return;
      }
      if (view.list.getItems().contains(file)) {
        Alerts.error("File is already on the list.");
        return;
      }
      int index = view.list.getSelectionModel().getSelectedIndex();
      controller.updatePicture(index, file);
      view.list.getItems().set(index, file);
      if (index == controller.currentFileIndex.get()) {
        view.displayPicture(controller.getCurrentPicture());
      }
    });
    view.list.remove.setOnAction(event -> {
      File file = view.list.getSelectionModel().getSelectedItem();
      controller.deletePicture(view.list.getSelectionModel().getSelectedIndex());
      view.list.getItems().remove(file);
      view.displayPicture(controller.getCurrentPicture());
    });
    view.list.clear.setOnAction(event -> Alerts.confirm("Are you sure?", () -> {
      controller.clearPictures();
      view.list.getItems().clear();
      view.displayPicture(controller.getCurrentPicture());
    }));

    view.bars.previous.setOnAction(event -> {
      controller.navigatePrevious();
      view.displayPicture(controller.getCurrentPicture());
      view.list.getSelectionModel().clearSelection();
    });
    view.bars.next.setOnAction(event -> {
      controller.navigateNext();
      view.displayPicture(controller.getCurrentPicture());
      view.list.getSelectionModel().clearSelection();
    });
    view.menus.goToStart.setOnAction(event -> {
      controller.currentFileIndex.set(0);
      view.displayPicture(controller.getCurrentPicture());
      view.list.getSelectionModel().clearSelection();
    });
    view.menus.goToEnd.setOnAction(event -> {
      controller.currentFileIndex.set(controller.fileList.size() - 1);
      view.displayPicture(controller.getCurrentPicture());
      view.list.getSelectionModel().clearSelection();
    });
  }
}
