# Homework 7

- Sliding navigation with a side panel list showing current picture collection.
- Maintaining 2 collections:
  - `DLinkedList` for main navigation.
  - `ObservableArrayList` for side panel.
- MVC design pattern (without the model class).

## Wireframes

<img width="480" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw7/wireframe1.svg"><br><small>Wireframe 1 &mdash; Main window</small>

## Screenshots

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw7/screenshot1.png"><br><small>Screenshot 1 &mdash; Empty collection</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw7/screenshot2.png"><br><small>Screenshot 2 &mdash; Import pictures</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw7/screenshot3.png"><br><small>Screenshot 3 &mdash; Expanded window</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw7/screenshot4.png"><br><small>Screenshot 4 &mdash; Safeguarding measure</small>

## Diagrams

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw7/diagram1.svg"><br><small>Diagram 1 &mdash; UML</small>

> ## Instructions
>
> **ImageViewer (Generic Linked List)**
>
> Modify the doubly linked list class presented in this chapter so it works with
  generic types. Add the following methods drawn from the java.util.List
  interface:
>
> - `void clear()`: remove all elements from the list.
> - `E get(int index)`: return the element at position index in the list.
> - `E set(int index, E element)`: replace the element at the specified position
    with the specified element and return the previous element.
>
> Test your generic linked list class by creating a JavaFX application that can
  perform Create, Read, Update and Delete actions on a list of images. The list
  should be contained in a doubly linked list that can be saved as a playlist
  file. Your application should use the FileChooser control to allow the user to
  choose a playlist file to open. It should also use the FileChooser control to
  allow the user to choose an image to the playlist. When a playlist file is
  opened, your application should display the first image.
>
> Your GUI should
>
> - include Next and Previous buttons allowing the user to navigate to next and
    previous images
> - include controls to Update (add and delete images to/from) a list
> - include a way to Create a new list
>
> **Instructions**
>
> Create a wireframe and plan your application. You probably need a wireframe
  for C, R, U and D.
>
> Reference & Resources
>
> - [JavaFX 20 API Specification](https://openjfx.io/javadoc/20/)
>   - [Class Alert](https://openjfx.io/javadoc/20/javafx.controls/javafx/scene/control/Alert.html)
>   - [Class FileChooser](https://openjfx.io/javadoc/20/javafx.graphics/javafx/stage/FileChooser.html), [Oracle FileChooser](https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm), [File Chooser | JavaFX GUI Tutorial for Beginners](https://www.youtube.com/watch?v=Af-hwO19AMY)
>   - [Oracle Menu](https://docs.oracle.com/javafx/2/ui_controls/menu_controls.htm), [JavaFX | MenuBar and Menu](https://www.geeksforgeeks.org/javafx-menubar-and-menu/)
>
> ### Please submit the following:
>
> 1.   A captured image of your screen showing your program’s output
> 1.   The compressed (zipped) folder containing your **_entire_** project
