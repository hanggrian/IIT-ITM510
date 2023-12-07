////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 31/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A JavaFX application that manages movie library with MVC design    //
// pattern in the form of sliding navigation window.                  //
////////////////////////////////////////////////////////////////////////

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A controller responsible for movie collection CRUD and file read/write operations. The collection
 * and index properties are replaced by JavaFX API to automatically trigger bindings when items are
 * manipulated.
 */
public class MovieController {
  private final ObservableList<Movie> movieList;
  private final IntegerProperty currentMovieIndex = new SimpleIntegerProperty();

  /**
   * New instance with empty collection.
   */
  public MovieController() {
    this(FXCollections.observableArrayList());
  }

  /**
   * New instance with custom collection.
   *
   * @param movieList starting items.
   */
  public MovieController(ObservableList<Movie> movieList) {
    this.movieList = movieList;
    currentMovieIndex.set(movieList.size() - 1);
  }

  /**
   * Creates a new movie and append it to the collection.
   *
   * @see Movie#Movie
   */
  public void createMovie(String title, String director, int year, String genre, int runtime) {
    movieList.add(new Movie(title, director, year, genre, runtime));
    currentMovieIndex.set(movieList.size() - 1);
  }

  /**
   * Updates an existing movie in the collection.
   *
   * @param index must be in range of collection.
   * @see Movie#Movie
   */
  public void updateMovie(
      int index,
      String title,
      String director,
      int year,
      String genre,
      int runtime
  ) {
    if (index < 0 || index >= movieList.size()) {
      throw new IllegalArgumentException();
    }
    Movie movie = movieList.get(index);
    movie.setTitle(title);
    movie.setDirector(director);
    movie.setYear(year);
    movie.setGenre(genre);
    movie.setRuntime(runtime);
  }

  /**
   * Deletes an existing movie in the collection
   *
   * @param index must be in range of collection.
   */
  public void deleteMovie(int index) {
    if (index < 0 || index >= movieList.size()) {
      throw new IllegalArgumentException();
    }
    movieList.remove(index);
    if (currentMovieIndex.get() > index) {
      currentMovieIndex.set(currentMovieIndex.get() - 1);
    } else if (currentMovieIndex.get() == index) {
      if (currentMovieIndex.get() >= movieList.size()) {
        currentMovieIndex.set(movieList.size() - 1);
      }
    }
  }

  /**
   * Returns a movie based on current counter.
   */
  public Movie getCurrentMovie() {
    if (movieList.isEmpty()) {
      return null;
    }
    return movieList.get(currentMovieIndex.get());
  }

  /**
   * Returns the current counter.
   */
  public IntegerProperty getCurrentMovieIndex() {
    return currentMovieIndex;
  }

  /**
   * Set counter to particular value.
   *
   * @param index must be valid index within collection.
   */
  public void setCurrentMovieIndex(int index) {
    if (index < 0 || index >= movieList.size()) {
      throw new IllegalArgumentException();
    }
    currentMovieIndex.set(index);
  }

  /**
   * Increments the counter, or do nothing when out of bounds.
   */
  public void navigateNext() {
    if (currentMovieIndex.get() < movieList.size() - 1) {
      currentMovieIndex.set(currentMovieIndex.get() + 1);
    }
  }

  /**
   * Decrements the counter, or do nothing when out of bounds.
   */
  public void navigatePrevious() {
    if (currentMovieIndex.get() > 0) {
      currentMovieIndex.set(currentMovieIndex.get() - 1);
    }
  }

  /**
   * Returns the movie collection as array list.
   */
  public ObservableList<Movie> getMovieList() {
    return movieList;
  }

  /**
   * Replace all items of the movie collection.
   *
   * @param movieList cannot be null.
   */
  public void setMovieList(List<Movie> movieList) {
    this.movieList.setAll(requireNonNull(movieList));
    currentMovieIndex.set(movieList.size() - 1);
  }

  /**
   * Writes the elements of movie collection into a file. The saved file is plain Java list because
   * JavaFX doesn't support serialization.
   *
   * @param file a .dat file.
   */
  public void saveDataToFile(File file) {
    try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
      stream.writeObject(new ArrayList<>(movieList));
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Error saving serializable %s: %s%n", file.getName(), e.getMessage()));
    }
  }

  /**
   * Reads a file and insert them into current collection. The loaded file is plain Java list
   * because JavaFX doesn't support serialization.
   *
   * @param file a .dat file.
   */
  public void loadDataFromFile(File file) {
    try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
      Object obj = stream.readObject();
      if (obj instanceof ArrayList) {
        movieList.setAll((List<Movie>) obj);
        currentMovieIndex.set(movieList.size() - 1);
      }
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(
          String.format("Error loading serializable %s: %s%n", file.getName(), e.getMessage()));
    }
  }
}
