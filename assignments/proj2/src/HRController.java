////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

import static java.util.Objects.requireNonNull;

import i18n.State;
import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * A controller responsible for CRUD operations of an employee collection. The JavaFX collection and
 * property are necessary to automatically trigger bindings.
 */
public class HRController {
  private final ObservableList<Employee> employeeList;
  private final IntegerProperty currentEmployeeIndex = new SimpleIntegerProperty();

  /**
   * New instance with empty collection.
   */
  public HRController() {
    this(FXCollections.observableArrayList());
  }

  /**
   * New instance with custom collection.
   *
   * @param list starting items.
   */
  public HRController(ObservableList<Employee> list) {
    employeeList = list;
    currentEmployeeIndex.set(list.size() - 1);
  }

  /**
   * Creates a new employee using today as hiring date.
   *
   * @see Employee#Employee
   */
  public void createEmployee(
      String firstName,
      String lastName,
      String phoneNumber,
      String address,
      String city,
      State state,
      int employeeId,
      String employeeTitle,
      String department,
      double salary
  ) {
    employeeList.add(new Employee(
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
        LocalDate.now()));
    currentEmployeeIndex.set(employeeList.size() - 1);
  }

  /**
   * Updates an existing employee.
   *
   * @param index must be in range of collection.
   * @see Employee#Employee
   */
  public void updateEmployee(
      int index,
      String firstName,
      String lastName,
      String phoneNumber,
      String address,
      String city,
      State state,
      int employeeId,
      String employeeTitle,
      String department,
      double salary
  ) {
    checkIndex(index);
    Employee employee = employeeList.get(index);
    employee.setFirstName(firstName);
    employee.setLastName(lastName);
    employee.setPhoneNumber(phoneNumber);
    employee.setAddress(address);
    employee.setCity(city);
    employee.setState(state);
    employee.setEmployeeId(employeeId);
    employee.setEmployeeTitle(employeeTitle);
    employee.setDepartment(department);
    employee.setSalary(salary);
  }

  /**
   * Deletes an existing employee in the collection
   *
   * @param index must be in range of collection.
   */
  public void deleteEmployee(int index) {
    checkIndex(index);
    employeeList.remove(index);
    if (currentEmployeeIndex.get() > index) {
      currentEmployeeIndex.set(currentEmployeeIndex.get() - 1);
    } else if (currentEmployeeIndex.get() == index) {
      if (currentEmployeeIndex.get() >= employeeList.size()) {
        currentEmployeeIndex.set(employeeList.size() - 1);
      }
    }
  }

  /**
   * Returns an employee based on current counter.
   */
  public Employee getCurrentEmployee() {
    if (employeeList.isEmpty()) {
      return null;
    }
    return employeeList.get(currentEmployeeIndex.get());
  }

  /**
   * Returns the current counter.
   */
  public IntegerProperty getCurrentEmployeeIndex() {
    return currentEmployeeIndex;
  }

  /**
   * Set counter to particular value.
   *
   * @param index must be valid index within collection.
   */
  public void setCurrentEmployeeIndex(int index) {
    checkIndex(index);
    currentEmployeeIndex.set(index);
  }

  /**
   * Increments the counter, or do nothing when out of bounds.
   */
  public void navigateNext() {
    if (currentEmployeeIndex.get() < employeeList.size() - 1) {
      currentEmployeeIndex.set(currentEmployeeIndex.get() + 1);
    }
  }

  /**
   * Decrements the counter, or do nothing when out of bounds.
   */
  public void navigatePrevious() {
    if (currentEmployeeIndex.get() > 0) {
      currentEmployeeIndex.set(currentEmployeeIndex.get() - 1);
    }
  }

  /**
   * Returns the employee collection as array list.
   */
  public ObservableList<Employee> getEmployeeList() {
    return employeeList;
  }

  /**
   * Replace all items of the employee collection.
   *
   * @param list cannot be null.
   */
  public void setEmployeeList(List<Employee> list) {
    employeeList.setAll(requireNonNull(list));
    currentEmployeeIndex.set(employeeList.size() - 1);
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= employeeList.size()) {
      throw new IndexOutOfBoundsException();
    }
  }
}
