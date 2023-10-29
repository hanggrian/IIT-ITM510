////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 29/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A recursive CLI app that manages movie library using MVC design    //
// pattern.                                                           //
////////////////////////////////////////////////////////////////////////

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
   * Single constructor with all the properties.
   *
   * @param title movie name, cannot be empty.
   * @param director staff name, cannot be empty.
   * @param year release time.
   * @param genre film category, cannot be empty.
   * @param runtime duration in minutes.
   */
  public Movie(String title, String director, int year, String genre, int runtime) {
    if (year < MIN_YEAR || runtime < MIN_RUNTIME) {
      throw new IllegalArgumentException();
    }
    this.title = Objects.requireNonNull(title);
    this.director = Objects.requireNonNull(director);
    this.year = year;
    this.genre = Objects.requireNonNull(genre);
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
    this.title = Objects.requireNonNull(title);
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
    this.director = Objects.requireNonNull(director);
  }

  /**
   * @return release time.
   */
  public int getYear() {
    return year;
  }

  /**
   * @param year release time.
   */
  public void setYear(int year) {
    if (year < MIN_YEAR) {
      throw new IllegalArgumentException();
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
    this.genre = Objects.requireNonNull(genre);
  }

  /**
   * @return duration in minutes.
   */
  public int getRuntime() {
    return runtime;
  }

  /**
   * @param runtime duration in minutes.
   */
  public void setRuntime(int runtime) {
    if (runtime < MIN_RUNTIME) {
      throw new IllegalArgumentException("Runtime cannot be 0.");
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
