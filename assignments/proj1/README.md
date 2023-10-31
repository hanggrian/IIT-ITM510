# Project 1

- Multiple ways to operate the GUI (menu, buttons, keyboard shortcuts).
- Bindings make the GUI responsive to user input.
- Use file picker to save and load file.

## Diagrams

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj1/diagram1.png"><br><small>Diagram 1 &mdash; UML</small>

## Screenshots

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj1/screenshot1.png"><br><small>Screenshot 1 &mdash; Clean state, empty library</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj1/screenshot2.png"><br><small>Screenshot 2 &mdash; Read state, loaded file from txt</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj1/screenshot3.png"><br><small>Screenshot 3 &mdash; Create state</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj1/screenshot4.png"><br><small>Screenshot 4 &mdash; Update state</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj1/screenshot5.png"><br><small>Screenshot 5 &mdash; Delete state</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj1/screenshot6.png"><br><small>Screenshot 6 &mdash; Safeguarding measure</small>

> ## Instructions
>
> **Movie Library 2.0**
>
> The attached text-based Java app *implements the Model-View-Contoller design
  pattern*.
>
> Following the attached wireframe diagram, create JavaFX GUI View to replace
  the text-based View.
>
> ![](https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj1.png)
>
> When run your application should open and load movies from a binary file,
  **movieDb.dat**, containing serialized movie objects. Once the data is loaded,
  the GUI View should display the first movie (Read). The GUI View should allow
  the user to perform all CRUD actions.
>
> **Create**
>
> - The text of the New button should change to "Cancel New" in <span style="color: red;">**red**</span>.
> - All text fields should become empty.
> - The Previous, Edit, Delete and Next buttons should be disabled.
> - If the user clicks Cancel New, the GUI View should return to 'Read' state.
> - If the user clicks Save, the new movie should be added and the GUI View
    should go to 'Read' state.
>
> **Read**
>
> - When the GUI View enters the 'Read' state the Previous, New, Edit, Delete
    and Next buttons should be enabled.
> - The Save button should be disabled.
> - All text should be black.
> - Clicking the Next button should display the next movie. If the end of the
    list is reached, clicking Next should do nothing.
> - Clicking the Previous button should display the previous movie. If the
    beginning of the list is reached, clicking Previous should do nothing.
> - When the user clicks the New button, the GUI View should enter the 'Create'
    state.
> - When the user clicks the Edit button, the GUI View should enter the 'Update'
    state.
> - When the user clicks the Delete button, the GUI View should enter the
    'Delete' state.
>
> **Update**
>
> - The text of the Edit button should change to "Cancel Edit" in <span style="color: red;">**red**</span>.
> - The Previous, New, Delete and Next buttons should be disabled.
> - If the user clicks Cancel, the GUI View should return to 'Read' state.
> - If the user clicks Save, the movie data should be updated and the GUI View
    should go to 'Read' state.
>
> **Delete**
>
> - The text of the Delete button should change to "Yes, delete" in <span style="color: red;">**red**</span>.
> - The New, Edit and Save buttons should be disabled.
> - If the user clicks Previous or Next, the GUI View should return to 'Read'
    state.
> - If the user clicks Yes, delete, the movie should be deleted and the GUI View
    should go to the 'Read' state.
>
> **Instructions**
>
> Add your program heading to the code. Add comments where necessary in the body
  of the code so that the code will be well commented.
>
> The file movieDb.dat *is __not__ supplied with this project*. Use the
  MovieFileConverter utility supplied with this project to create the serialized
  movie objects.
>
> **WARNING**: Do <span style="color: red;">**NOT**</span> alter the Model,
  Controller or Movie classes.
>
> For assistance with the Model-View-Controller design pattern
>
> - Watch the Design Pattern video
> - Read the Design Pattern document
>
> To enable/disable or change the text on a TextField or Button, read the JavaFX
  documentation linked in References & Resources.
>
> ### Please submit the following:
>
> 1. Captured images of your screen showing your program performing each CRUD
     action.
> 2. The compressed (zipped) folder containing your **_entire_** project
