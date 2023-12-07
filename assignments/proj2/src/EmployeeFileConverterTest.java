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

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

/**
 * This test will generate text and binary file that contains 10 random employees.
 */
public class EmployeeFileConverterTest {
  private static final int HOW_MANY = 10;

  @Before
  public void writeText() {
    List<Employee> employees = new ArrayList<>();
    for (int i = 0; i < HOW_MANY; i++) {
      employees.add(Employee.randomize());
    }
    EmployeeFileConverter.saveTextToFile(employees);
  }

  @Test
  public void readText() {
    assertEquals(HOW_MANY, EmployeeFileConverter.loadTextFromFile().size());
  }

  @Before
  public void writeBinary() {
    List<Employee> employees = new ArrayList<>();
    for (int i = 0; i < HOW_MANY; i++) {
      employees.add(Employee.randomize());
    }
    EmployeeFileConverter.saveDataToFile(employees);
  }

  @Test
  public void readBinary() {
    ObservableList<Employee> employees = FXCollections.observableArrayList();
    EmployeeFileConverter.loadDataFromFile(employees);
    assertEquals(HOW_MANY, employees.size());
  }
}
