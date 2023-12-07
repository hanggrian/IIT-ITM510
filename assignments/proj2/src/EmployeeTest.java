////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class EmployeeTest {
  @Test
  public void checkArguments() {
    Employee employee = Employee.randomize();

    assertThrows(NullPointerException.class, () -> employee.setFirstName(null));
    assertThrows(IllegalArgumentException.class, () -> employee.setFirstName(""));

    assertThrows(NullPointerException.class, () -> employee.setLastName(null));
    assertThrows(IllegalArgumentException.class, () -> employee.setLastName(""));

    assertThrows(NullPointerException.class, () -> employee.setPhoneNumber(null));
    assertThrows(IllegalArgumentException.class, () -> employee.setPhoneNumber(""));
    assertThrows(IllegalArgumentException.class, () -> employee.setPhoneNumber("0"));

    assertThrows(NullPointerException.class, () -> employee.setAddress(null));
    assertThrows(IllegalArgumentException.class, () -> employee.setAddress(""));

    assertThrows(NullPointerException.class, () -> employee.setCity(null));
    assertThrows(IllegalArgumentException.class, () -> employee.setCity(""));

    assertThrows(NullPointerException.class, () -> employee.setState(null));

    assertThrows(IllegalArgumentException.class, () -> employee.setEmployeeId(0));

    assertThrows(NullPointerException.class, () -> employee.setEmployeeTitle(null));
    assertThrows(IllegalArgumentException.class, () -> employee.setEmployeeTitle(""));

    assertThrows(NullPointerException.class, () -> employee.setDepartment(null));
    assertThrows(IllegalArgumentException.class, () -> employee.setDepartment(""));

    assertThrows(IllegalArgumentException.class, () -> employee.setSalary(-0.1));
  }
}
