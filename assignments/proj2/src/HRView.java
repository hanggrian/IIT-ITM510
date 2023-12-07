////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

import static javafx.beans.binding.Bindings.and;
import static javafx.beans.binding.Bindings.createStringBinding;
import static javafx.beans.binding.Bindings.equal;
import static javafx.beans.binding.Bindings.isEmpty;
import static javafx.beans.binding.Bindings.notEqual;
import static javafx.beans.binding.Bindings.or;
import static javafx.beans.binding.Bindings.size;
import static javafx.beans.binding.Bindings.when;
import static javafx.geometry.Pos.TOP_CENTER;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import ui.MainButtonBar;
import ui.MainGridPane;
import ui.MainMenuBar;

/**
 * The window content with all the binding logics.
 */
public class HRView extends VBox {
  public final ObjectProperty<Mode> currentMode = new SimpleObjectProperty<>(Mode.READ);

  public final Label indicator = new Label("Empty");
  public final MainMenuBar menus = new MainMenuBar();
  public final MainGridPane info = new MainGridPane();
  public final MainButtonBar buttons = new MainButtonBar();

  public HRView() {
    indicator.setPadding(new Insets(5));
    indicator.setAlignment(Pos.CENTER);
    indicator.setTextAlignment(TextAlignment.CENTER);

    getChildren().addAll(menus, indicator, info, buttons);
    setAlignment(TOP_CENTER);
  }

  /**
   * Bind control disability, text, and text color. The menu item click listener is bound to the
   * button counterpart.
   *
   * @param employees obtained from controller.
   * @param index     guaranteed to be in bounds.
   */
  public void bindControls(ObservableList<Employee> employees, IntegerProperty index) {
    indicator.textProperty().bind(
        createStringBinding(() -> employees.isEmpty()
                ? "Empty" : String.format("#%d / %d", index.get() + 1, employees.size()),
            employees,
            index));

    for (Control control : info.getControls()) {
      control.disableProperty().bind(
          or(equal(currentMode, Mode.READ),
              equal(currentMode, Mode.DELETE)));
    }

    menus.randomize.disableProperty().bind(equal(currentMode, Mode.READ));
    menus.resetAll.disableProperty().bind(notEqual(currentMode, Mode.READ));

    bindMenuToButton(
        menus.previous,
        buttons.previous,
        or(isEmpty(employees),
            equal(index, 0)));
    bindMenuToButton(
        menus.next,
        buttons.next,
        or(isEmpty(employees),
            equal(index, size(employees).subtract(1))));

    menus.goToStart.disableProperty().bind(buttons.previous.disableProperty());
    menus.goToEnd.disableProperty().bind(buttons.next.disableProperty());

    bindMenuToButton(
        menus.create,
        buttons.create,
        and(notEqual(currentMode, Mode.READ),
            notEqual(currentMode, Mode.CREATE)),
        Mode.CREATE,
        "New",
        "Cancel New");
    bindMenuToButton(
        menus.edit,
        buttons.edit,
        or(isEmpty(employees),
            and(notEqual(currentMode, Mode.READ),
                notEqual(currentMode, Mode.UPDATE))),
        Mode.UPDATE,
        "Edit",
        "Cancel Edit");
    bindMenuToButton(
        menus.delete,
        buttons.delete,
        or(isEmpty(employees),
            and(notEqual(currentMode, Mode.READ),
                notEqual(currentMode, Mode.DELETE))),
        Mode.DELETE,
        "Delete",
        "Yes, Delete");
    bindMenuToButton(
        menus.save,
        buttons.save,
        and(notEqual(currentMode, Mode.CREATE),
            notEqual(currentMode, Mode.UPDATE)));
  }

  /**
   * Assign control values from an employee, or clear all if null.
   *
   * @param employee nullable employee.
   */
  public void displayEmployee(Employee employee) {
    if (employee == null) {
      for (Control control : info.getControls()) {
        if (control instanceof TextField) {
          ((TextField) control).clear();
        }
      }
      info.state.getSelectionModel().clearSelection();
      info.hireDate.setValue(null);
      return;
    }
    info.firstName.setText(employee.getFirstName());
    info.lastName.setText(employee.getLastName());
    info.phoneNumber.setText(employee.getPhoneNumber());
    info.address.setText(employee.getAddress());
    info.city.setText(employee.getCity());
    info.state.setValue(employee.getState());
    info.employeeId.setText(String.valueOf(employee.getEmployeeId()));
    info.employeeTitle.setText(employee.getEmployeeTitle());
    info.department.setText(employee.getDepartment());
    info.salary.setText(String.valueOf(employee.getSalary()));
    info.hireDate.setValue(employee.getHireDate());
  }

  /**
   * Returns a new employee instance based on control values.
   */
  public Employee getEmployeeInfo() {
    return new Employee(
        info.firstName.getText().trim(),
        info.lastName.getText().trim(),
        info.phoneNumber.getText().trim(),
        info.address.getText().trim(),
        info.city.getText().trim(),
        info.state.getValue(),
        Integer.parseInt(info.employeeId.getText().trim()),
        info.employeeTitle.getText().trim(),
        info.department.getText().trim(),
        Double.parseDouble(info.salary.getText().trim()),
        info.hireDate.getValue()
    );
  }

  private void bindMenuToButton(MenuItem menu, Button button, BooleanBinding disability) {
    button.disableProperty().bind(disability);
    menu.disableProperty().bind(button.disableProperty());
    menu.onActionProperty().bind(button.onActionProperty());
  }

  private void bindMenuToButton(
      MenuItem menu,
      Button button,
      BooleanBinding disability,
      Mode targetState,
      String textDefault,
      String textCancel
  ) {
    button.textFillProperty().bind(
        when(equal(currentMode, targetState))
            .then(RED)
            .otherwise(BLACK));
    button.textProperty().bind(
        when(equal(currentMode, targetState))
            .then(textCancel)
            .otherwise(textDefault));
    menu.textProperty().bind(button.textProperty());
    button.disableProperty().bind(disability);
    menu.disableProperty().bind(button.disabledProperty());
    menu.onActionProperty().bind(button.onActionProperty());
  }
}
