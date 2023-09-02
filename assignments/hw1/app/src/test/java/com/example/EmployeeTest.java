package com.example;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.example.Employee;
import org.junit.Test;

public class EmployeeTest {
  @Test
  public void constructors() {
    Employee lessArg = new Employee("", 0);
    assertThat(lessArg.getDepartment()).isEmpty();
    assertThat(lessArg.getPosition()).isEmpty();

    Employee noArg = new Employee();
    assertThat(noArg.getName()).isEmpty();
    assertThat(noArg.getIdNumber()).isEqualTo(0);
  }

  @Test
  public void errors() {
    Throwable nullName = assertThrows(NullPointerException.class, () -> new Employee(null, 0));
    assertThat(nullName).hasCauseThat();

    Throwable negativeId = assertThrows(IllegalStateException.class, () -> new Employee("", -1));
    assertThat(negativeId).hasCauseThat();
  }
}
