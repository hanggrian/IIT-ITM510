////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 29/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A recursive CLI app that manages movie library using MVC design    //
// pattern.                                                           //
////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A self-repeating command-line interface application with MVC design pattern that manages a movie
 * collection. There are 2 files managed by the app:
 *
 * <ol>
 *   <li>movieDb.dat - local storage that loads on start (if exists) and saves on exit.</li>
 *   <li>movieDb.txt - default movies that replaces existing when user choose 1. RESET. </li>
 * </ol>
 */
public class App {
  private static final String FILENAME_TXT = "movieDb.txt";
  private static final String FILENAME_DAT = "movieDb.dat";
  private static final int ACTION_RESET = 1;
  private static final int ACTION_CREATE = 2;
  private static final int ACTION_READ = 3;
  private static final int ACTION_UPDATE = 4;
  private static final int ACTION_DELETE = 5;

  private static MovieController controller;
  private static MovieView view;

  public static void main(String[] args) {
    controller = new MovieController();
    view = new MovieView();

    System.out.println("Welcome to Movie Library!\n");
    if (new File(FILENAME_DAT).exists()) {
      System.out.printf("Old %s found:%n", FILENAME_DAT);
      controller.loadFile(FILENAME_DAT);
      view.displayMovies(controller.asList());
    } else {
      System.out.printf("No old data, use 1. RESET to fetch data from %s.%n%n", FILENAME_TXT);
    }
    start();
  }

  private static void start() {
    int action = view.displayMenu();
    switch (action) {
      case ACTION_RESET:
        controller = new MovieController(loadMovies(FILENAME_TXT));
        System.out.println("Reset!\n");
        break;
      case ACTION_CREATE:
        Movie newMovie = view.requestMovie();
        controller.create(
            newMovie.getTitle(),
            newMovie.getDirector(),
            newMovie.getYear(),
            newMovie.getGenre(),
            newMovie.getRuntime()
        );
        break;
      case ACTION_READ:
      case ACTION_UPDATE:
      case ACTION_DELETE:
        if (controller.asList().isEmpty()) {
          System.out.println("Empty library.\n");
          break;
        }
        if (action == ACTION_READ) {
          char navigation = 0;
          while (navigation != 'Q') {
            navigation = view.displayNavigation(controller.asList(), controller.getIndex());
            if (navigation == 'N') {
              controller.navigateNext();
            } else if (navigation == 'P') {
              controller.navigatePrevious();
            }
          }
          System.out.println();
        } else if (action == ACTION_UPDATE) {
          System.out.println("Updating movies:");
          view.displayMovies(controller.asList());

          int index = view.requestIndex(controller.asList());
          Movie updatedMovie = view.requestMovie();
          controller.update(
              index,
              updatedMovie.getTitle(),
              updatedMovie.getDirector(),
              updatedMovie.getYear(),
              updatedMovie.getGenre(),
              updatedMovie.getRuntime()
          );
        } else {
          System.out.println("Deleting movies:");
          view.displayMovies(controller.asList());

          int index = view.requestIndex(controller.asList());
          controller.delete(index);
        }
        break;
      default:
        controller.saveFile(FILENAME_DAT);
        System.out.printf("%s stored, goodbye!%n", FILENAME_DAT);
        System.exit(0);
        break;
    }
    start();
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
      System.err.printf("Error loading file %s: %s%n", filename, e.getMessage());
    }
    return movieList;
  }
}
