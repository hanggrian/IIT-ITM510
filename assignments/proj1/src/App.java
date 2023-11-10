////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 31/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A JavaFX application that manages movie library with MVC design    //
// pattern in the form of sliding navigation window.                  //
////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ui.Alerts;

/**
 * A movie library sliding navigation window application. Data is not automatically loaded on
 * application start and saved upon exit. Instead, user would have to manually save or load a custom
 * file.
 */
public class App extends Application {
  private static final String TITLE = "Movie Library";
  private static final String FILENAME_TXT = "movieDb.txt";
  private static final String FILENAME_DAT = "movieDb.dat";

  private FileChooser chooser;
  private MovieView view;
  private MovieController controller;
  private Movie lastMovie; // when user cancel, text fields will revert back to this value

  public static void main(String[] args) {
    launch(App.class, args);
  }

  @Override
  public void init() {
    chooser = new FileChooser();
    chooser.setTitle(TITLE);
    chooser.setInitialFileName(FILENAME_DAT);
    chooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Binary Files", "*.dat", "*.DAT"));

    view = new MovieView();
    controller = new MovieController();
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle(TITLE);
    stage.setMinWidth(600);
    stage.setMinHeight(300);
    stage.setScene(new Scene(view));
    stage.setResizable(false);
    stage.show();

    view.bindControls(controller.getMovieList(), controller.getCurrentMovieIndex());

    view.menus.quit.setOnAction(event -> Platform.exit());
    view.menus.minimize.setOnAction(event -> stage.setIconified(true));

    view.menus.saveFile.setOnAction(event -> {
      File file = chooser.showSaveDialog(stage);
      if (file != null) {
        controller.saveDataToFile(file);
      }
    });
    view.menus.loadFile.setOnAction(event -> {
      File file = chooser.showOpenDialog(stage);
      if (file != null) {
        try {
          controller.loadDataFromFile(file);
          view.displayMovie(controller.getCurrentMovie());
        } catch (Exception e) {
          Alerts.error(e.getMessage());
        }
      }
    });

    view.menus.resetAll.setOnAction(event ->
        Alerts.confirm(String.format("Reset movies back to %s?", FILENAME_TXT), () -> {
          try {
            controller.setMovieList(loadMovies(FILENAME_TXT));
            view.displayMovie(controller.getCurrentMovie());
          } catch (Exception e) {
            Alerts.error(e.getMessage());
          }
        })
    );
    view.buttons.create.setOnAction(event -> {
      switch (view.currentState.get()) {
        case CREATE:
          view.currentState.set(State.READ);
          view.displayMovie(controller.getCurrentMovie());
          break;
        case READ:
          view.currentState.set(State.CREATE);
          view.displayMovie(null);
          view.texts.title.requestFocus();
          break;
      }
    });
    view.buttons.edit.setOnAction(event -> {
      switch (view.currentState.get()) {
        case UPDATE:
          view.currentState.set(State.READ);
          view.displayMovie(lastMovie);
          lastMovie = null;
          break;
        case READ:
          view.currentState.set(State.UPDATE);
          view.texts.title.requestFocus();
          lastMovie = view.getMovieInfo();
          break;
      }
    });
    view.buttons.save.setOnAction(event -> {
      try {
        switch (view.currentState.get()) {
          case CREATE:
            controller.createMovie(
                view.texts.title.getText(),
                view.texts.director.getText(),
                view.texts.year.getValue(),
                view.texts.genre.getText(),
                view.texts.runtime.getValue()
            );
            break;
          case UPDATE:
            controller.updateMovie(
                controller.getCurrentMovieIndex().get(),
                view.texts.title.getText(),
                view.texts.director.getText(),
                view.texts.year.getValue(),
                view.texts.genre.getText(),
                view.texts.runtime.getValue()
            );
            break;
        }
        view.currentState.set(State.READ);
      } catch (Exception e) {
        Alerts.error(e.getMessage());
      }
    });
    view.buttons.delete.setOnAction(event -> {
      switch (view.currentState.get()) {
        case DELETE:
          controller.deleteMovie(controller.getCurrentMovieIndex().get());
          view.currentState.set(State.READ);
          view.displayMovie(controller.getCurrentMovie());
          break;
        case READ:
          view.currentState.set(State.DELETE);
          break;
      }
    });

    view.buttons.previous.setOnAction(event -> {
      controller.navigatePrevious();
      view.currentState.set(State.READ);
      view.displayMovie(controller.getCurrentMovie());
    });
    view.buttons.next.setOnAction(event -> {
      controller.navigateNext();
      view.currentState.set(State.READ);
      view.displayMovie(controller.getCurrentMovie());
    });
    view.menus.goToStart.setOnAction(event -> {
      controller.setCurrentMovieIndex(0);
      view.currentState.set(State.READ);
      view.displayMovie(controller.getCurrentMovie());
    });
    view.menus.goToEnd.setOnAction(event -> {
      controller.setCurrentMovieIndex(controller.getMovieList().size() - 1);
      view.currentState.set(State.READ);
      view.displayMovie(controller.getCurrentMovie());
    });

    view.menus.about.setOnAction(event ->
        Alerts.info("JavaFX GUI that manages movie library with MVC design pattern.")
    );
  }

  private static List<Movie> loadMovies(String filename) {
    List<Movie> movieList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split("\t"); // Assuming tab-delimited file
        if (data.length == 5) {
          String title = data[0];
          String director = data[1];
          int year = Integer.parseInt(data[2]);
          String genre = data[3];
          int runtime = Integer.parseInt(data[4]);
          Movie movie = new Movie(title, director, year, genre, runtime);
          movieList.add(movie);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Error loading file %s: %s%n", filename, e.getMessage())
      );
    }
    return movieList;
  }
}
