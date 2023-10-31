////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 31/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A JavaFX application that manages movie library with MVC design    //
// pattern in the form of sliding navigation window.                  //
////////////////////////////////////////////////////////////////////////

import static javafx.beans.binding.Bindings.and;
import static javafx.beans.binding.Bindings.createObjectBinding;
import static javafx.beans.binding.Bindings.equal;
import static javafx.beans.binding.Bindings.isEmpty;
import static javafx.beans.binding.Bindings.notEqual;
import static javafx.beans.binding.Bindings.or;
import static javafx.beans.binding.Bindings.size;
import static javafx.beans.binding.Bindings.when;
import static javafx.geometry.Pos.CENTER;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import ui.MainButtonBar;
import ui.MainGridPane;
import ui.MainMenuBar;

/**
 * All JavaFX controls in the main window, contained in a vertical layout.
 */
public class MovieView extends VBox {
  public final ObjectProperty<State> currentState = new SimpleObjectProperty<>(State.READ);

  public Label indicator = new Label();
  public MainMenuBar menus = new MainMenuBar();
  public MainGridPane texts = new MainGridPane();
  public MainButtonBar buttons = new MainButtonBar();

  public MovieView() {
    indicator.setPadding(new Insets(5));
    indicator.setAlignment(Pos.CENTER);
    indicator.setTextAlignment(TextAlignment.CENTER);

    getChildren().addAll(menus, indicator, texts, buttons);
    setAlignment(CENTER);
  }

  /**
   * Bind the properties of control such as disability, text, and text color. The menu item click
   * listener is bound to the button counterpart. However, the button click listener need to be
   * declared outside this class.
   *
   * @param movies obtained from controller.
   * @param index  guaranteed to be in bounds.
   */
  public void bindControls(ObservableList<Movie> movies, IntegerProperty index) {
    indicator.textProperty().bind(createObjectBinding(() -> movies.isEmpty()
        ? "Empty"
        : String.format("#%d / %d", index.get() + 1, movies.size()), movies, index));

    for (TextField txt : texts.getTextFields()) {
      txt.disableProperty().bind(
          or(equal(currentState, State.READ),
              equal(currentState, State.DELETE)));
    }

    menus.resetAll.disableProperty().bind(notEqual(currentState, State.READ));

    bindMenuToButton(
        menus.previous,
        buttons.previous,
        or(isEmpty(movies),
            equal(index, 0)));
    bindMenuToButton(
        menus.next,
        buttons.next,
        or(isEmpty(movies),
            equal(index, size(movies).subtract(1))));

    menus.goToStart.disableProperty().bind(buttons.previous.disableProperty());
    menus.goToEnd.disableProperty().bind(buttons.next.disableProperty());

    bindMenuToButtonWithState(
        menus.create,
        buttons.create,
        and(notEqual(currentState, State.READ),
            notEqual(currentState, State.CREATE)),
        State.CREATE,
        "New",
        "Cancel New");
    bindMenuToButtonWithState(
        menus.edit,
        buttons.edit,
        or(isEmpty(movies),
            and(notEqual(currentState, State.READ),
                notEqual(currentState, State.UPDATE))),
        State.UPDATE,
        "Edit",
        "Cancel Edit");
    bindMenuToButtonWithState(
        menus.delete,
        buttons.delete,
        or(isEmpty(movies),
            and(notEqual(currentState, State.READ),
                notEqual(currentState, State.DELETE))),
        State.DELETE,
        "Delete",
        "Yes, Delete");
    bindMenuToButton(
        menus.save,
        buttons.save,
        and(notEqual(currentState, State.CREATE),
            notEqual(currentState, State.UPDATE)));
  }

  private void bindMenuToButton(MenuItem menu, Button button, BooleanBinding disabilityBinding) {
    button.disableProperty().bind(disabilityBinding);
    menu.disableProperty().bind(button.disableProperty());
    menu.onActionProperty().bind(button.onActionProperty());
  }

  private void bindMenuToButtonWithState(
      MenuItem menu,
      Button button,
      BooleanBinding disabilityBinding,
      State targetState,
      String textDefault,
      String textCancel
  ) {
    button.textFillProperty().bind(
        when(equal(currentState, targetState))
            .then(RED)
            .otherwise(BLACK));
    button.textProperty().bind(
        when(equal(currentState, targetState))
            .then(textCancel)
            .otherwise(textDefault));
    menu.textProperty().bind(button.textProperty());
    button.disableProperty().bind(disabilityBinding);
    menu.disableProperty().bind(button.disabledProperty());
    menu.onActionProperty().bind(button.onActionProperty());
  }

  /**
   * Assign text values from a movie, or clear all if null.
   *
   * @param movie nullable movie.
   */
  public void displayMovie(Movie movie) {
    if (movie == null) {
      for (TextField txt : texts.getTextFields()) {
        txt.clear();
      }
      return;
    }
    texts.title.setText(movie.getTitle());
    texts.director.setText(movie.getDirector());
    texts.year.setText(String.valueOf(movie.getYear()));
    texts.genre.setText(movie.getGenre());
    texts.runtime.setText(String.valueOf(movie.getRuntime()));
  }

  /**
   * Returns a new movie instance based on text values.
   */
  public Movie getMovieInfo() {
    return new Movie(
        texts.title.getText(),
        texts.director.getText(),
        texts.year.getValue(),
        texts.genre.getText(),
        texts.runtime.getValue()
    );
  }
}
