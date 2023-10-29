# Homework 6

- Multi-layered recursions:
  - Main menu &mdash; runs endlessly unless explicitly stopped.
  - User prompts &mdash; ensures every input is valid.
- Use barebone MVC design pattern.
- Saving and loading movies from a binary file.

## Diagrams

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw6/diagram1.png"><br><small>Diagram 1 &mdash; UML</small>

## Screenshots

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw6/screenshot1.png"><br><small>Screenshot 1 &mdash; Clean state, resetting movies and saving to file</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw6/screenshot2.png"><br><small>Screenshot 2 &mdash; Loaded file</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw6/screenshot3.png"><br><small>Screenshot 3 &mdash; Creating a movie, then navigate</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw6/screenshot4.png"><br><small>Screenshot 4 &mdash; Updating a movie</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw6/screenshot5.png"><br><small>Screenshot 5 &mdash; Deleting a movie</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw6/screenshot6.png"><br><small>Screenshot 6 &mdash; Safeguarding measures</small>

> ## Instructions
>
> **Movie Library 2.0**
>
> The attached text-based Java app is has the same functionality as the previous
  assignment, but it implements the Model-View-Contoller design pattern. When
  run it will open and load movies from a binary file, movieDb.dat, containing
  serialized movie objects. Once the data is loaded, the application will
  display the following menu.
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
> Entering menu option
>
> 1. will allow the user to create a new movie.
> 2. will cause the movies to be listed.
> 3. will allow the user to enter new values for a particular movie.
> 4. will allow the user to delete a movie.
> 5. will cause the application to exit.
>
> Add your program heading to the code. Add comments where necessary in the body
  of the code so that the code will be well commented.
>
> The file movieDb.dat *is __not__ supplied with this project*. Use the
  MovieFileConverter utility supplied with this project to create the serialized
  movie objects.
>
> *Modify menu option 2*
>
> **Using the methods in the model, view and controller**, the application
  should allow the user to navigate to the next or previous movie and display
  it, and then present the user with three options: Previous, Next or Quit.
  Selecting P will display the previous movie. Selecting N will display the next
  movie and selecting Q will cause the application to stop displaying movies and
  display the main menu again. Selecting Previous when the first movie is
  displayed should not cause the last movie to be displayed. The first movie
  should continue to be viewed. Selecting Next when the last movie is displayed
  should not cause the first movie to be displayed. The last movie should
  continue to be viewed.
>
> For assistance with the Model-View-Controller design pattern
>
> - Watch the Design Pattern video
> - Read the Design Pattern document
>
> ### Please submit the following:
>
> 1. A captured image of your screen showing your program’s output
> 2. The compressed (zipped) folder containing your **_entire_** project
