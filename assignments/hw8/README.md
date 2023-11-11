# Homework 8

## Wireframes

<img width="480" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw8/wireframe1.png"><br><small>Wireframe 1 &mdash; Main window</small>

## Screenshots

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw8/screenshot1.png"><br><small>Screenshot 1 &mdash; File not loaded</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw8/screenshot2.png"><br><small>Screenshot 2 &mdash; An unbalanced input</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw8/screenshot3.png"><br><small>Screenshot 3 &mdash; Another unbalanced input</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw8/screenshot4.png"><br><small>Screenshot 4 &mdash; Balanced input</small>

## Diagrams

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw8/diagram1.png"><br><small>Diagram 1 &mdash; UML</small>

> ## Instructions
>
> **Balanced (grouping) symbols**
>
> A Java program contains various pairs of grouping symbols, such as:
>
> - Parentheses: `(` and `)`
> - Curly braces: `{` and `}`
> - Brackets: `[` and `]`
> - Angled brackets: `<` and `>`
>
> Proper nesting is allowed. For example, `{{(a(b)[]}}` grouping symbols cannot
  overlap. For example, `(a{b)}` is illegal.
>
> Create an application that detects non-matching grouping symbols.
>
> Implement a JavaFX application which checks whether a Java source-code file
  has balanced parentheses, `()`; curly braces, `{}`; square brackets, `[]` and
  angled brackets, `<>`.
>
> The applications GUI should include a file menu that includes open, close and
  exit options. The open option should use the FileChooser class to allow the
  user to select a Java file to open.
>
> Once a file is selected, the application should read the file and detect
  unbalanced grouping symbols. Use the [Stack class](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Stack.html)
  from the Java Collections Framework, or use a stack class from the source code
  for chapter 20.
>
> A TextArea should display the results that there was no problems or display
  the line number where the problem was found. Any character that is not a
  parenthesis, curly brace, square bracket or angled brackets should be ignored.
>
> ### Please submit the following:
>
> 1. A captured image of your screen showing your program’s output
> 2. The compressed (zipped) folder containing your **_entire_** project
