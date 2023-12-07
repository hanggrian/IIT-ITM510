////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.Alert.AlertType.INFORMATION;
import static javafx.scene.control.ButtonType.OK;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * The main application with MVC implementation. There is no save and load buttons because changes
 * made to the collection will be automatically saved during closing.
 */
public class HRApp extends Application {
  private HRView view;
  private HRController controller;
  private Employee lastEmployee; // when user cancel, controls will revert back to this value

  public static void main(String[] args) {
    launch(HRApp.class, args);
  }

  /**
   * Initialize properties here instead of constructors.
   */
  @Override
  public void init() {
    view = new HRView();
    controller = new HRController();

    if (EmployeeFileConverter.loadDataFromFile(controller.getEmployeeList())) {
      controller.getCurrentEmployeeIndex().set(controller.getEmployeeList().size() - 1);
      view.displayEmployee(controller.getCurrentEmployee());
    }
  }

  /**
   * Show main window and initialize event handlers.
   */
  @Override
  public void start(Stage stage) {
    stage.setTitle("Human Resources");
    stage.setScene(new Scene(view));
    stage.setMinWidth(700);
    stage.setMinHeight(370);
    stage.setResizable(false);
    stage.show();
    stage.setOnCloseRequest(event ->
        EmployeeFileConverter.saveDataToFile(controller.getEmployeeList()));

    view.bindControls(controller.getEmployeeList(), controller.getCurrentEmployeeIndex());

    view.menus.quit.setOnAction(event -> {
      EmployeeFileConverter.saveDataToFile(controller.getEmployeeList());
      Platform.exit();
    });
    view.menus.minimize.setOnAction(event -> stage.setIconified(true));

    view.menus.randomize.setOnAction(event -> view.displayEmployee(Employee.randomize()));
    view.menus.resetAll.setOnAction(event ->
        new Alert(CONFIRMATION,
            String.format("Reset employees back to %s?", EmployeeFileConverter.FILENAME_TXT))
            .showAndWait()
            .ifPresent(type -> {
              if (type != OK) {
                return;
              }
              try {
                controller.setEmployeeList(EmployeeFileConverter.loadTextFromFile());
                view.displayEmployee(controller.getCurrentEmployee());
              } catch (Exception e) {
                new Alert(ERROR, e.getMessage()).showAndWait();
              }
            })
    );

    view.buttons.create.setOnAction(event -> {
      switch (view.currentMode.get()) {
        case CREATE:
          view.currentMode.set(Mode.READ);
          view.displayEmployee(controller.getCurrentEmployee());
          break;
        case READ:
          view.currentMode.set(Mode.CREATE);
          view.displayEmployee(null);
          view.info.firstName.requestFocus();
          break;
      }
    });
    view.buttons.edit.setOnAction(event -> {
      switch (view.currentMode.get()) {
        case UPDATE:
          view.currentMode.set(Mode.READ);
          view.displayEmployee(lastEmployee);
          lastEmployee = null;
          break;
        case READ:
          view.currentMode.set(Mode.UPDATE);
          view.info.firstName.requestFocus();
          lastEmployee = view.getEmployeeInfo();
          break;
      }
    });
    view.buttons.save.setOnAction(event -> {
      try {
        switch (view.currentMode.get()) {
          case CREATE:
            controller.createEmployee(
                view.info.firstName.getText(),
                view.info.lastName.getText(),
                view.info.phoneNumber.getText(),
                view.info.address.getText(),
                view.info.city.getText(),
                view.info.state.getValue(),
                Integer.parseInt(view.info.employeeId.getText()),
                view.info.employeeTitle.getText(),
                view.info.department.getText(),
                Double.parseDouble(view.info.salary.getText()));
            break;
          case UPDATE:
            controller.updateEmployee(
                controller.getCurrentEmployeeIndex().get(),
                view.info.firstName.getText(),
                view.info.lastName.getText(),
                view.info.phoneNumber.getText(),
                view.info.address.getText(),
                view.info.city.getText(),
                view.info.state.getValue(),
                Integer.parseInt(view.info.employeeId.getText()),
                view.info.employeeTitle.getText(),
                view.info.department.getText(),
                Double.parseDouble(view.info.salary.getText()));
            break;
        }
        view.currentMode.set(Mode.READ);
      } catch (Exception e) {
        new Alert(ERROR, e.getMessage()).showAndWait();
      }
    });
    view.buttons.delete.setOnAction(event -> {
      switch (view.currentMode.get()) {
        case DELETE:
          controller.deleteEmployee(controller.getCurrentEmployeeIndex().get());
          view.currentMode.set(Mode.READ);
          view.displayEmployee(controller.getCurrentEmployee());
          break;
        case READ:
          view.currentMode.set(Mode.DELETE);
          break;
      }
    });

    view.buttons.previous.setOnAction(event -> {
      controller.navigatePrevious();
      view.currentMode.set(Mode.READ);
      view.displayEmployee(controller.getCurrentEmployee());
    });
    view.buttons.next.setOnAction(event -> {
      controller.navigateNext();
      view.currentMode.set(Mode.READ);
      view.displayEmployee(controller.getCurrentEmployee());
    });
    view.menus.goToStart.setOnAction(event -> {
      controller.setCurrentEmployeeIndex(0);
      view.currentMode.set(Mode.READ);
      view.displayEmployee(controller.getCurrentEmployee());
    });
    view.menus.goToEnd.setOnAction(event -> {
      controller.setCurrentEmployeeIndex(controller.getEmployeeList().size() - 1);
      view.currentMode.set(Mode.READ);
      view.displayEmployee(controller.getCurrentEmployee());
    });

    view.menus.about.setOnAction(event ->
        new Alert(INFORMATION,
            "Human Resources application written in JavaFX with MVC design pattern.")
            .showAndWait());
  }
}
