<style type="text/css">ol { list-style-type: upper-alpha; }</style>

# Quiz 6: JavaFX

Chapter 12 | Chapter 13
--- | ---
Graphical User Interfaces | Styling JavaFX Applications with CSS
Introduction to JavaFX | RadioButton Controls
Creating Scenes | CheckBox Controls
Displaying Images | ListView Controls
More About the HBox, VBox, and GridPane Layout Containers | ComboBox Controls
Button Controls and Events | Slider Controls
Reading Input with TextField Controls | TextArea Controls
Using Lambda Expressions to Handle Events | Menus
The BorderPane Layout Container | The FileChooser Class
The ObserveableList Interface | Using Console Output to Debug a GUI Application

## Problem 1

> If you set a scene's size to a width and height that is smaller than the width
  and height of the image to be displayed ______.
>
> 1.  only part of the image will be displayed
> 1.  the image will only occupy part of the window
> 1.  the scene will automatically be resized to fit the image
> 1.  the image will automatically be resized to fit the window

**A.** only part of the image will be displayed.

## Problem 2

> Select all that apply. Which of the following file types are supported by the
  `Image` class?
>
> 1.  BMP
> 1.  JPEG
> 1.  GIF
> 1.  PNG

- **A.** BMP
- **B.** JPEG
- **C.** GIF
- **D.** PNG

## Problem 3

> Select Select all that apply. Given the statement shown below, which of the
  following statements are true?
>
> ```java
> Scene scene = new Scene(hbox, 100, 500);
> ```
>
> 1.  The width of the scene will be 100 pixels.
> 1.  The height of the scene will be 100 pixels.
> 1.  A `Scene` object named `scene` will be created.
> 1.  The root node is `hbox`.

- **A.** The width of the scene will be 100 pixels.
- **C.** A `Scene` object named `scene` will be created.
- **D.** The root node is `hbox`.

## Problem 4

> What does the following statement do?
>
> ```java
> Image puppy = new Image("file:C:Images\\terrier.jpg");
> ```
>
> 1.  It creates an instance of the `ImageView` class with the terrier. jpg file
      passed to the constructor.
> 1.  It loads an image named `images\terrier.jpg` and stores the image in the
      `Image` variable.
> 1.  It loads an image file named `terrier.jpg` which is found in the `images`
      folder on the user's C-drive.
> 1.  Nothing; it is not possible to include a path to a file when using the
      `Image` class.

**C.** It loads an image file named `terrier.jpg` which is found in the `images`

## Problem 5

> Select all that apply. It may be possible to simplify event handler code by
  using which of the following?
>
> 1.  nested classes
> 1.  anonymous inner classes
> 1.  lambda expressions
> 1.  listener expressions

- **C.** anonymous inner classes

## Problem 6

> The command line interface is an event-driven interface.
>
> 1.  True
> 1.  False

**B.** False

## Problem 7

> An event handler class will not be executed unless it has been registered with
  the correct control.
>
> 1.  True
> 1.  False

**A.** True

## Problem 8

> Which of the following will create a `CheckBox` that displays `pizza` and
  shows up as selected?
>
> 1.
>
> ```java
> CheckBox checkOne.setSelected(true) = "pizza";
> ```
>
> 2.
>
> ```java
> CheckBox checkOne = new CheckBox("pizza");
> checkone.setSelected(true);
> ```
>
> 3.
>
> ```java
> CheckBox checkOne = new CheckBox("pizza") ;
> CheckBox.setSelected(false);
> ```
>
> 4.
>
> ```java
> CheckBox checkOne("pizza") = setSelected(true);
> ```

**B.** 2.

## Problem 9

> Which CSS type selector corresponds with the `TextField` JavaFX class?
>
> 1.  `text-box`
> 1.  `text-field`
> 1.  `text-area`
> 1.  `text`

**B.** `text-field`

## Problem 10

> Adding `RadioButton` controls to a ______ object creates a mutually exclusive
  relationship between them.
>
> 1.  `MutualGroup`
> 1.  `RadioGroup`
> 1.  `ToggleGroup`
> 1.  `ExcludeGroup`

**C.** `ToggleGroup`

## Problem 11

> Which of the following statements creates a `Slider` with a range of `1` to
  `20` with a starting value of `1`?
>
> 1.  `Slider slider = new Slider(0, 20, 1);`
> 1.  `Slider slider = new slider(0.0, 20.0, 1.0);`
> 1.  `Slider slider = new Slider(1.0, 20.0, 1.0);`
> 1.  `Slider slider = new Slider(1.0, 20);`

**C.** `Slider slider = new Slider(1.0, 20.0, 1.0);`

## Problem 12

> Select all that apply. Which of the following classes inherit from the Region
  class?
>
> 1.  multiple selection mode
> 1.  single selection mode
> 1.  multiple interval selection mode
> 1.  single interval selecton mode

None of the above.

## Problem 13

> Radio buttons are normally used when you want the user to be able to select
  one or more options from a group of several possible options.
>
> 1.  True
> 1.  False

**B.** False

## Problem 14

> In JavaFX all CSS properties begin with `-fx-`.
>
> 1.  True
> 1.  False

**A.** True
