# Project 2

- Enum containing 50 US states.
- Randomize and reset all functionality.
- Safeguarding measure to prevent invalid input.

## Wireframes

<img width="480" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/wireframe1.png"><br><small>Wireframe 1 &mdash; Main window</small>

## Screenshots

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/screenshot1.png"><br><small>Screenshot 1 &mdash; Clean state</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/screenshot2.png"><br><small>Screenshot 2 &mdash; Randomize functionality</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/screenshot3.png"><br><small>Screenshot 3 &mdash; Reset all functionality</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/screenshot4.png"><br><small>Screenshot 4 &mdash; READ state with edging index</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/screenshot5.png"><br><small>Screenshot 5 &mdash; CREATE state</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/screenshot6.png"><br><small>Screenshot 6 &mdash; UPDATE state</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/screenshot7.png"><br><small>Screenshot 7 &mdash; DELETE state</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/screenshot8.png"><br><small>Screenshot 8 &mdash; Safeguarding measure</small>

## Diagrams

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/proj2/diagram1.png"><br><small>Diagram 1 &mdash; UML</small>

> ## Instructions
>
> **Human Resources Application**
>
> Create a JavaFX application that performs CRUD operations on Human Resources
  employee data using the MVC design pattern. Newly created employees and
  updates to existing employees should persist. That means the program will have
  saved additions and changes to the file before the program stops running.
>
> Create a class for employees.
>
> Employee class
>
> - First Name
> - Last Name
> - Phone Number
> - Address
> - City
> - State
> - Employee id
> - Employee Title
> - Department
> - Salary
> - Hire Date
>
> Your employee class should include constructor(s), accessors and mutators.
  Override the toString, hashCode and equals methods.
>
> The data for your application is in a tab delimited text file. You will need
  to input the data and serialize it so that it is stored in as an object. Refer
  to the assignments from earlier in the semester for examples.
>
> When run your application should open and load employees from a binary file
  containing serialized employee objects. Once the data is loaded, the GUI View
  should display the first employee (Read). The GUI View should allow the user
  to perform all CRUD actions.
>
> **Create**
>
> - The text of the New button should change to "Cancel New" in <span style="color: red;">**red**</span>.
> - All text fields should become empty.
> - The Previous, Edit, Delete and Next buttons should be disabled.
> - If the user clicks Cancel New, the GUI View should return to 'Read' state.
> - If the user clicks Save, the new employee should be added and the GUI View
    should go to 'Read' state.
>
> **Read**
>
> - When the GUI View enters the 'Read' state the Previous, New, Edit, Delete
    and Next buttons should be enabled.
> - The Save button should be disabled.
> - All text should be black.
> - Clicking the Next button should display the next employee. If the end of the
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
> The file containing employee objects will have to be create. Create a
  `EmployeeFileConverter` utility to create the serialized employee objects from
  the text file. See [Scanner](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)
  `useDelimiter()` method.
>
> For assistance with the Model-View-Controller design pattern
>
> - Watch the Design Pattern video
> - Read the Design Pattern document
> - Review the code from earlier assignments
>
> To enable/disable or change the text on a TextField or Button, read the JavaFX
  documentation linked in References & Resources.
>
> ### Please submit the following:
>
> 1. Captured images of your screen showing your program performing each CRUD
     action.
> 2. The compressed (zipped) folder containing your **_entire_** project
