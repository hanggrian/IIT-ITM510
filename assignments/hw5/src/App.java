////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library                                          //
// Date: 09/16/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A self-repeating CLI application that manages movie library.       //
////////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Command-line interface application with the ability to create, read, update, and delete movies.
 * This application will recurse itself indefinitely unless user choose exits (or forcibly exits).
 */
public class App {
  private static final String FILENAME = "movieDb.txt";

  private static ScannerWrapper scanner;
  private static List<Movie> movies;

  public static void main(String[] args) {
    scanner = new ScannerWrapper();
    movies = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] data = line.split("\t");
        if (data.length != 5) {
          continue;
        }
        movies.add(new Movie(
            data[0],
            data[1],
            Integer.parseInt(data[2]),
            data[3],
            Integer.parseInt(data[4])
        ));
      }
    } catch (IOException e) {
      System.err.println("Error loading data from the file: " + e.getMessage());
    }

    System.out.println("Welcome to Movie Library!\n");
    start();
  }

  /**
   * Main function that repeats itself.
   */
  private static void start() {
    System.out.println("Menu:\n"
        + "1 - Create a movie\n"
        + "2 - Read (navigate movies)\n"
        + "3 - Update a movie\n"
        + "4 - Delete a movie\n"
        + "5 - Exit\n");
    int input = scanner.readInt("What would you do?", 1, 5);

    System.out.println();
    switch (input) {
      case 1:
        create();
        break;
      case 2:
        read();
        break;
      case 3:
        update();
        break;
      case 4:
        delete();
        break;
      default:
        exit();
        break;
    }
    start();
  }

  /**
   * Create a new movie specifying all its properties. Always append to beginning on the list.
   */
  private static void create() {
    movies.add(0, new Movie(
        scanner.read("(1/5) What is the movie title?"),
        scanner.read("(2/5) Who is the director?"),
        scanner.readInt("(3/5) When was it released?", Movie.MIN_YEAR, Movie.MAX_YEAR),
        scanner.read("(4/5) What is the genre?"),
        scanner.readInt("(5/5) How long is the duration, in minutes?",
            Movie.MIN_RUNTIME, Movie.MAX_RUNTIME)
    ));
    System.out.println("Added!\n");
  }

  /**
   * List movies by their full properties and navigate forward or backward. Only quits when
   * explicitly triggered.
   */
  private static void read() {
    // stop if empty
    if (movies.isEmpty()) {
      System.out.println("Empty library.\n");
      return;
    }

    // navigate through list
    char input = 0;
    int index = 0;
    while (input != 'Q') {
      Movie movie = movies.get(index);
      System.out.printf("Movie #%d / %d%n"
              + "- title = %s%n"
              + "- director = %s%n"
              + "- year = %d%n"
              + "- genre = %s%n"
              + "- runtime = %d%n",
          index + 1,
          movies.size(),
          movie.getTitle(),
          movie.getDirector(),
          movie.getYear(),
          movie.getGenre(),
          movie.getRuntime()
      );
      input = scanner.readChar("Where to go, in N/P/Q?", 'N', 'P', 'Q');
      if (input == 'N') {
        index = index == movies.size() - 1 ? 0 : index + 1;
      } else if (input == 'P') {
        index = index == 0 ? movies.size() - 1 : index - 1;
      }
    }
    System.out.println();
  }

  /**
   * Update a single property of a movie, selected by its index number. To update more than one
   * property, the user would have to trigger update option multiple times.
   */
  private static void update() {
    // stop if empty
    if (movies.isEmpty()) {
      System.out.println("Empty library.\n");
      return;
    }

    // ask for movie
    System.out.println("Updating movies:");
    listMovies();
    int input = scanner.readInt("Which movie to update?", 1, movies.size());
    Movie movie = movies.get(input - 1);

    // ask for property
    System.out.println("1 - Title\n"
        + "2 - Director name\n"
        + "3 - Release date\n"
        + "4 - Genre\n"
        + "5 - Runtime");
    switch (scanner.readInt("What to update?", 1, 5)) {
      case 1:
        movie.setTitle(scanner.read("What is the movie title?"));
        break;
      case 2:
        movie.setDirector(scanner.read("Who is the director?"));
        break;
      case 3:
        movie.setYear(scanner.readInt("When was it released?", Movie.MIN_YEAR, Movie.MAX_YEAR));
        break;
      case 4:
        movie.setGenre(scanner.read("What is the genre?"));
        break;
      default:
        movie.setRuntime(scanner.readInt("How long is the duration, in minutes?",
            Movie.MIN_RUNTIME, Movie.MAX_RUNTIME));
        break;
    }
    System.out.println("Updated!\n");
  }

  /**
   * Ask a permission to remove a movie, selected by its index number.
   */
  private static void delete() {
    // stop if empty
    if (movies.isEmpty()) {
      System.out.println("Empty library.\n");
      return;
    }

    // ask for movie
    System.out.println("Deleting movies:");
    listMovies();
    int input = scanner.readInt("Which movie to delete?", 1, movies.size());

    // ask for confirmation
    char confirm = scanner.readChar("Are you sure, in Y/N?", 'Y', 'N');
    if (confirm == 'y' || confirm == 'Y') {
      movies.remove(input - 1);
      System.out.println("Deleted!\n");
    } else {
      System.out.println("Canceled.\n");
    }
  }

  /**
   * Quits application deliberately, instead of forcibly.
   */
  private static void exit() {
    System.out.println("Goodbye!");
    System.exit(0);
  }

  /**
   * Lists all movies by their index number and full display name.
   */
  private static void listMovies() {
    for (int i = 0; i < movies.size(); i++) {
      System.out.printf("%d. %s%n", i + 1, movies.get(i));
    }
    System.out.println();
  }
}
