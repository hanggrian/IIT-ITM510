////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 29/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A recursive CLI app that manages movie library using MVC design    //
// pattern.                                                           //
////////////////////////////////////////////////////////////////////////

import java.util.List;

/**
 * A view model that prints menu and navigation in standard output stream. It can also receive
 * user input by typing in the command line interface.
 */
public class MovieView {
  private final RecursiveScanner scanner = new RecursiveScanner();

  /**
   * Show main menu interface.
   *
   * @return 1 to 6.
   */
  public int displayMenu() {
    System.out.println("Menu:\n"
        + "1 - Reset movies\n"
        + "2 - Create a movie\n"
        + "3 - Read (navigate movies)\n"
        + "4 - Update a movie\n"
        + "5 - Delete a movie\n"
        + "6 - Exit\n");
    int action = scanner.scanInt("What would you do?", 1, 6);
    System.out.println();
    return action;
  }

  /**
   * Show movie navigation mode.
   *
   * @param movies all items.
   * @param index display item index.
   * @return N, P, or Q.
   */
  public char displayNavigation(List<Movie> movies, int index) {
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
    return scanner.scanChar("Where to go, in N/P/Q?", 'N', 'P', 'Q');
  }

  /**
   * Print all movies in short form string.
   *
   * @param movies all items.
   */
  public void displayMovies(List<Movie> movies) {
    for (int i = 0; i < movies.size(); i++) {
      System.out.printf("%d. %s%n", i + 1, movies.get(i));
    }
    System.out.println();
  }

  /**
   * Ask user a sequence of prompts to create a new movie instance.
   */
  public Movie requestMovie() {
    return new Movie(
        scanner.scan("(1/5) What is the movie title?"),
        scanner.scan("(2/5) Who is the director?"),
        scanner.scanInt("(3/5) When was it released?", Movie.MIN_YEAR, Movie.MAX_YEAR),
        scanner.scan("(4/5) What is the genre?"),
        scanner.scanInt("(5/5) How long is the duration, in minutes?",
            Movie.MIN_RUNTIME, Movie.MAX_RUNTIME
        )
    );
  }

  /**
   * Ask user for a valid index in the existing movies.
   *
   * @param movies all items.
   */
  public int requestIndex(List<Movie> movies) {
    return scanner.scanInt("Select the movie number:", 1, movies.size()) - 1;
  }
}
