////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

package ui;

import static javafx.geometry.Pos.TOP_CENTER;
import static javafx.scene.layout.Priority.ALWAYS;

import i18n.State;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

/**
 * Parent of text fields placed at the center of the main window.
 */
public class MainGridPane extends GridPane {
  // name
  public final TextField firstName = new TextField();
  public final TextField lastName = new TextField();
  // phone
  public final TextField phoneNumber = new TextField();
  // location
  public final TextField address = new TextField();
  public final TextField city = new TextField();
  public final ComboBox<State> state = new ComboBox<>();
  // employee
  public final TextField employeeId = new TextField();
  public final TextField employeeTitle = new TextField();
  // company
  public final TextField department = new TextField();
  public final TextField salary = new TextField();
  // hired
  public final DatePicker hireDate = new DatePicker();

  public MainGridPane() {
    Tooltip tip = new Tooltip("Insert a non-empty text.");
    firstName.setPromptText("(First)");
    firstName.setTooltip(tip);
    lastName.setPromptText("(Last)");
    lastName.setTooltip(tip);
    phoneNumber.setPromptText("(No.)");
    phoneNumber.setTooltip(new Tooltip("Insert a 10-digits phone number."));
    address.setPromptText("(Address)");
    address.setTooltip(tip);
    city.setPromptText("(City)");
    city.setTooltip(tip);
    state.setItems(FXCollections.observableArrayList(State.values()));
    state.setTooltip(new Tooltip("Pick one from a dropdown."));
    employeeId.setPromptText("(ID)");
    employeeId.setTooltip(new Tooltip("Insert a number that starts from 1."));
    employeeTitle.setPromptText("(Title)");
    employeeTitle.setTooltip(tip);
    department.setPromptText("(Dept.)");
    department.setTooltip(tip);
    salary.setPromptText("(Salary)");
    salary.setTooltip(new Tooltip("Insert a decimal that starts from 0.0."));
    hireDate.setPromptText("(Date)");
    hireDate.setTooltip(new Tooltip("Any date."));

    int i = 0;
    add(new Label("Name:"), 0, i);
    add(firstName, 1, i, 2, 1);
    add(lastName, 3, i++, 2, 1);
    add(new Label("Phone:"), 0, i);
    add(phoneNumber, 1, i++, 4, 1);
    add(new Label("Location:"), 0, i);
    add(address, 1, i);
    add(city, 2, i);
    add(state, 3, i++, 2, 1);
    add(new Label("Employee:"), 0, i);
    add(employeeTitle, 1, i, 2, 1);
    add(new Label("#"), 3, i);
    add(employeeId, 4, i++);
    add(new Label("Company:"), 0, i);
    add(department, 1, i, 2, 1);
    add(new Label("$"), 3, i);
    add(salary, 4, i++);
    add(new Label("Hired:"), 0, i);
    add(hireDate, 1, i, 2, 1);

    setAlignment(TOP_CENTER);
    setPadding(new Insets(5, 50, 5, 50));
    setHgap(10);
    setVgap(10);
    setHgrow(firstName, ALWAYS);
    restrictDigits(phoneNumber);
    restrictDigits(employeeId);
    restrictDecimals(salary);
  }

  /**
   * Returns all user-configurable nodes.
   */
  public List<Control> getControls() {
    return Arrays.asList(
        firstName,
        lastName,
        phoneNumber,
        address,
        city,
        state,
        employeeId,
        employeeTitle,
        department,
        salary,
        hireDate);
  }

  private static void restrictDigits(TextField field) {
    field.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d*")) {
        field.setText(newValue.replaceAll("[^\\d]", ""));
      }
    });
  }

  private static void restrictDecimals(TextField field) {
    field.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!newValue.matches("\\d*(\\.\\d*)?")) {
        field.setText(oldValue);
      }
    });
  }
}
