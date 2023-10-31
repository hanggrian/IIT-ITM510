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

import java.io.Serializable;
import java.util.Objects;

/**
 * Data class that represents a movie.
 */
public class Movie implements Serializable {
  public static final int MIN_YEAR = 1900;
  public static final int MAX_YEAR = 2100;
  public static final int MIN_RUNTIME = 1;
  public static final int MAX_RUNTIME = 6000; // 100 hours

  private String title;
  private String director;
  private int year;
  private String genre;
  private int runtime;

  /**
   * Single constructor with all the properties. The error messages provided here will be displayed
   * in an alert.
   *
   * @param title    movie name, cannot be empty.
   * @param director staff name, cannot be empty.
   * @param year     release time from 1900 to 2100.
   * @param genre    film category, cannot be empty.
   * @param runtime  duration in minutes from 1 to 6000.
   */
  public Movie(String title, String director, int year, String genre, int runtime) {
    if (requireNonNull(title).isEmpty()) {
      throw new IllegalArgumentException("Title is empty.");
    }
    if (requireNonNull(director).isEmpty()) {
      throw new IllegalArgumentException("Director is empty.");
    }
    if (year < MIN_YEAR || year > MAX_YEAR) {
      throw new IllegalArgumentException(
          String.format("Year must be between %d and %d.", MIN_YEAR, MAX_YEAR));
    }
    if (requireNonNull(genre).isEmpty()) {
      throw new IllegalArgumentException("Genre is empty.");
    }
    if (runtime < MIN_RUNTIME || runtime > MAX_RUNTIME) {
      throw new IllegalArgumentException(
          String.format("Runtime must be between %d and %d.", MIN_RUNTIME, MAX_RUNTIME));
    }
    this.title = title;
    this.director = director;
    this.year = year;
    this.genre = genre;
    this.runtime = runtime;
  }

  /**
   * @return movie name, never empty.
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title movie name, cannot be empty.
   */
  public void setTitle(String title) {
    if (requireNonNull(title).isEmpty()) {
      throw new IllegalArgumentException("Title is empty.");
    }
    this.title = title;
  }

  /**
   * @return staff name, never empty.
   */
  public String getDirector() {
    return director;
  }

  /**
   * @param director staff name, cannot be empty.
   */
  public void setDirector(String director) {
    if (requireNonNull(director).isEmpty()) {
      throw new IllegalArgumentException("Director is empty.");
    }
    this.director = director;
  }

  /**
   * @return release time.
   */
  public int getYear() {
    return year;
  }

  /**
   * @param year release time within range.
   */
  public void setYear(int year) {
    if (year < MIN_YEAR || year > MAX_YEAR) {
      throw new IllegalArgumentException(
          String.format("Year must be between %d and %d.", MIN_YEAR, MAX_YEAR));
    }
    this.year = year;
  }

  /**
   * @return film category, never empty.
   */
  public String getGenre() {
    return genre;
  }

  /**
   * @param genre film category, cannot be empty.
   */
  public void setGenre(String genre) {
    if (requireNonNull(genre).isEmpty()) {
      throw new IllegalArgumentException("Genre is empty.");
    }
    this.genre = genre;
  }

  /**
   * @return duration in minutes.
   */
  public int getRuntime() {
    return runtime;
  }

  /**
   * @param runtime duration in minutes within range.
   */
  public void setRuntime(int runtime) {
    if (runtime < MIN_RUNTIME || runtime > MAX_RUNTIME) {
      throw new IllegalArgumentException(
          String.format("Runtime must be between %d and %d.", MIN_RUNTIME, MAX_RUNTIME));
    }
    this.runtime = runtime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(title, movie.title)
        && Objects.equals(director, movie.director)
        && Objects.equals(genre, movie.genre)
        && year == movie.year
        && runtime == movie.runtime;
  }

  @Override
  public String toString() {
    return String.format("%s by %s at %s, %s, %d mins", title, director, year, genre, runtime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, director, year, genre, runtime);
  }
}
