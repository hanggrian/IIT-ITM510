////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 31/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A JavaFX application that manages movie library with MVC design    //
// pattern in the form of sliding navigation window.                  //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

public class MovieControllerTest {
  @Test
  public void crudOperations() {
    MovieController controller = new MovieController();

    controller.createMovie("Barbie", "Greta Grewig", 2023, "Comedy", 114);
    assertEquals(0, controller.getCurrentMovieIndex().get());

    assertThrows(
        IllegalArgumentException.class,
        () -> controller.updateMovie(1, "Barbie & Ken", "Greta Grewig", 2023, "Comedy", 114)
    );
    controller.updateMovie(0, "Barbie & Ken", "Greta Grewig", 2023, "Comedy", 114);
    assertEquals("Barbie & Ken", controller.getCurrentMovie().getTitle());

    assertThrows(IllegalArgumentException.class, () -> controller.deleteMovie(1));
    controller.deleteMovie(0);
    assertTrue(controller.getMovieList().isEmpty());
  }

  @Test
  public void edgingIndex() {
    ObservableList<Movie> movieList = FXCollections.observableArrayList();
    movieList.add(null);
    movieList.add(null);

    MovieController controller = new MovieController(movieList);
    assertEquals(1, controller.getCurrentMovieIndex().get());
    controller.navigateNext();
    assertEquals(1, controller.getCurrentMovieIndex().get());
    controller.navigatePrevious();
    assertEquals(0, controller.getCurrentMovieIndex().get());
    controller.navigatePrevious();
    assertEquals(0, controller.getCurrentMovieIndex().get());
  }
}
