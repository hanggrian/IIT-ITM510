////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 29/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A recursive CLI app that manages movie library using MVC design    //
// pattern.                                                           //
////////////////////////////////////////////////////////////////////////

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * A controller responsible for movie collection CRUD and file read/write operations. Reading a
 * movie is done by navigating forward or backward with a rotating index, that is, the value will
 * reset when out of bounds.
 */
public class MovieController {
  private List<Movie> movieList;
  private int currentIndex;

  /**
   * New instance with empty collection.
   */
  public MovieController() {
    this(new ArrayList<>());
  }

  /**
   * New instance with custom collection.
   *
   * @param movieList starting items.
   */
  public MovieController(List<Movie> movieList) {
    this.movieList = movieList;
    currentIndex = movieList.size() - 1;
  }

  /**
   * Creates a new movie and append it to the collection.
   *
   * @see Movie#Movie
   */
  public void createMovie(String title, String director, int year, String genre, int runtime) {
    movieList.add(new Movie(title, director, year, genre, runtime));
    currentIndex = movieList.size() - 1;
    System.out.println("Added!\n");
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
    System.out.println("Updated!\n");
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
    if (currentIndex > index) {
      currentIndex--;
    } else if (currentIndex == index) {
      if (currentIndex >= movieList.size()) {
        currentIndex = movieList.size() - 1;
      }
    }
    System.out.println("Deleted!\n");
  }

  /**
   * Returns a movie based on current counter.
   */
  public Movie getCurrentMovie() {
    if (movieList.isEmpty()) {
      return null;
    }
    return movieList.get(currentIndex);
  }

  /**
   * Returns the current counter.
   */
  public int getCurrentMovieIndex() {
    return currentIndex;
  }

  /**
   * Increments the counter, or return to initial position when value exceeds.
   */
  public void navigateNext() {
    currentIndex = currentIndex == movieList.size() - 1 ? 0 : currentIndex + 1;
  }

  /**
   * Decrements the counter, or return to final position when value fell through.
   */
  public void navigatePrevious() {
    currentIndex = currentIndex == 0 ? movieList.size() - 1 : currentIndex - 1;
  }

  /**
   * Returns the movie collection as array list.
   */
  public List<Movie> getMovieList() {
    return movieList;
  }

  /**
   * Writes the elements of movie collection into a file.
   *
   * @param filename file name with extension.
   */
  public void saveDataToFile(String filename) {
    try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(filename))) {
      stream.writeObject(movieList);
    } catch (IOException e) {
      System.err.printf("Error saving serializable %s: %s%n", filename, e.getMessage());
    }
  }

  /**
   * Reads a file and insert them into current collection.
   *
   * @param filename file name with extension.
   */
  public void loadDataFromFile(String filename) {
    try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(filename))) {
      Object obj = stream.readObject();
      if (obj instanceof ArrayList) {
        movieList = (List<Movie>) obj;
        currentIndex = movieList.size() - 1;
      }
    } catch (IOException | ClassNotFoundException e) {
      System.err.printf("Error loading serializable %s: %s%n", filename, e.getMessage());
    }
  }
}
