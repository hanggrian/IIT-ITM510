# Homework 5

- Multi-layered recursions:
  - Main menu &mdash; runs endlessly unless explicitly stopped.
  - User prompts &mdash; ensures every input is valid.

## Screenshots

<img width="640" src="https://github.com/hanggrian/IIT-ITM510/raw/assets/assignments/hw5/screenshot1.png"><br><small>Screenshot 1 &mdash; Creating a movie</small>

<img width="640" src="https://github.com/hanggrian/IIT-ITM510/raw/assets/assignments/hw5/screenshot2.png"><br><small>Screenshot 2 &mdash; Navigating movies</small>

<img width="640" src="https://github.com/hanggrian/IIT-ITM510/raw/assets/assignments/hw5/screenshot3.png"><br><small>Screenshot 3 &mdash; Updating a movie</small>

<img width="640" src="https://github.com/hanggrian/IIT-ITM510/raw/assets/assignments/hw5/screenshot4.png"><br><small>Screenshot 4 &mdash; Deleting a movie</small>

<img width="640" src="https://github.com/hanggrian/IIT-ITM510/raw/assets/assignments/hw5/screenshot5.png"><br><small>Screenshot 5 &mdash; Safeguarding measures</small>

## Diagrams

<img width="640" src="https://github.com/hanggrian/IIT-ITM510/raw/assets/assignments/hw5/diagram1.svg"><br><small>Diagram 1 &mdash; UML</small>

> ## Instructions
>
> **Movie Library**
>
> The attached text-based Java app is not complete. When run it will open and
  load a tab-delimited text file containing movie data. Each record in the data
  file consists of a movie title, director's name, year released, genre and
  movie runtime. Once the data is loaded, the application will display the
  following menu.
>
> ```
> Menu:
> 1 - Create a movie
> 2 - Read (navigate movies)
> 3 - Update a movie
> 4 - Delete a movie
> 5 - Exit
> ```
>
> Entering menu option 2 will cause the movies to be listed. Entering menu
  option 5 will cause the application to exit. Entering menu options 1, 3 and 4
  will cause the application to display the user's choice and then display the
  menu again.
>
> Add your program heading to the code. Add comments where necessary in the body
  of the code so that the code will be well commented.
>
> *Complete menu options 1, 3 and 4*:
>
> - When the user selects menu option 1, the application should allow the user
    to enter the movie title, director's name, year released, genre and movie
    runtime and add the new movie to the ArrayList with the other movies.
> - When the user selects the menu option 3, the application should allow the
    user to choose a movie by number, i.e., 1 for the first move, 2 for the
    second movie... 5 for the fifth movie, etc. After the user selects a movie,
    the application should allow them to input new movie data and update the
    movie in the ArrayList.
> - When the user selects the menu option 4, the application should allow the
    user to choose a movie by number, i.e., 1 for the first move, 2 for the
    second movie... 5 for the fifth movie, etc. After the user selects a movie,
    the application should display the movie and prompt the user for
    confirmation to delete the movie. Once the user confirms that the movie
    should be deleted, the movie should be removed from the ArrayList.
>
> *Modify menu option 2*:
>
> - When the user selects menu option 2, the application should display the
    first movie along with it's number, i.e., 1 for the first move, 2 for the
    second movie... 5 for the fifth movie, etc. and then present the user with
    three options: Previous, Next or Quit. Selecting P will display the previous
    movie. Selecting N will display the next movie and selecting Q will cause
    the application to stop displaying movies and display the main menu again.
    Selecting Previous when the first movie is displayed should cause the last
    movie to be displayed. Selecting Next when the last movie is displayed
    should cause the first movie to be displayed.
>
> It is not necessary to save changes made using options 1, 3 or 4 to the data
  file.
>
> ### Please submit the following:
>
> 1.   A captured image of your screen showing your program’s output
> 1.   The compressed (zipped) folder containing your **_entire_** project
