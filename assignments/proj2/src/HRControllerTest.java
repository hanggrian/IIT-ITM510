////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import i18n.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

public class HRControllerTest {
  @Test
  public void crudOperations() {
    HRController controller = new HRController();

    controller.createEmployee(
        "John", "Doe", "5551234567",
        "4th Street", "Long Beach", State.CA,
        1, "Clerk",
        "Operation", 18);
    assertEquals(0, controller.getCurrentEmployeeIndex().get());

    controller.updateEmployee(
        0,
        "Jane", "Appleseed", "6661234567",
        "Park Avenue", "New York City", State.NY,
        2, "Manager",
        "Communication", 37);
    assertEquals("Jane", controller.getCurrentEmployee().getFirstName());
    assertEquals("Appleseed", controller.getCurrentEmployee().getLastName());
    assertEquals("6661234567", controller.getCurrentEmployee().getPhoneNumber());
    assertEquals("Park Avenue", controller.getCurrentEmployee().getAddress());
    assertEquals("New York City", controller.getCurrentEmployee().getCity());
    assertEquals(State.NY, controller.getCurrentEmployee().getState());
    assertEquals("Manager", controller.getCurrentEmployee().getEmployeeTitle());
    assertEquals(2, controller.getCurrentEmployee().getEmployeeId());
    assertEquals("Communication", controller.getCurrentEmployee().getDepartment());
    assertEquals(37, controller.getCurrentEmployee().getSalary(), 0);

    assertThrows(IndexOutOfBoundsException.class, () -> controller.deleteEmployee(1));
    controller.deleteEmployee(0);
    assertTrue(controller.getEmployeeList().isEmpty());
  }

  @Test
  public void edgingIndex() {
    ObservableList<Employee> employees = FXCollections.observableArrayList();
    employees.add(null);
    employees.add(null);

    HRController controller = new HRController(employees);
    assertEquals(1, controller.getCurrentEmployeeIndex().get());
    controller.navigateNext();
    assertEquals(1, controller.getCurrentEmployeeIndex().get());
    controller.navigatePrevious();
    assertEquals(0, controller.getCurrentEmployeeIndex().get());
    controller.navigatePrevious();
    assertEquals(0, controller.getCurrentEmployeeIndex().get());
  }
}
