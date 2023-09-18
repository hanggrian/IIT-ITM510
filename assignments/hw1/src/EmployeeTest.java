////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 6.1 Employee Class                                  //
// Date: 02/09/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Write an employee class with property name, ID, department, and    //
// position.                                                          //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class EmployeeTest {
  @Test
  public void constructors() {
    Employee lessArg = new Employee("", 0);
    assertEquals("", lessArg.getDepartment());
    assertEquals("", lessArg.getPosition());

    Employee noArg = new Employee();
    assertEquals("", noArg.getName());
    assertEquals(0, noArg.getIdNumber());
  }

  @Test
  public void errors() {
    Throwable nullName = assertThrows(NullPointerException.class, () -> new Employee(null, 0));
    assertNotEquals("", nullName.getMessage());

    Throwable negativeId = assertThrows(IllegalStateException.class, () -> new Employee("", -1));
    assertNotEquals("", negativeId.getMessage());
  }
}
