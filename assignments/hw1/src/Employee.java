////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 6.1 Employee Class                                  //
// Date: 12/09/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Write an employee class with property name, ID, department, and    //
// position.                                                          //
////////////////////////////////////////////////////////////////////////

import java.util.Objects;

/**
 * A standard employee class, meant to be represented as single string with {@link #toString()}.
 */
public class Employee {
  private String name;
  private int idNumber;
  private String department;
  private String position;

  /**
   * No configuration of Employee.
   */
  public Employee() {
    this("", 0, "", "");
  }

  /**
   * Partial configuration of employee.
   *
   * @param name person name, cannot be null.
   * @param idNumber company-issued ID, cannot be negative.
   */
  public Employee(String name, int idNumber) {
    this(name, idNumber, "", "");
  }

  /**
   * Full configuration of employee.
   *
   * @param name person name, cannot be null.
   * @param idNumber company-issued ID, cannot be negative.
   * @param department company sub-branch, cannot be null.
   * @param position job role, cannot be null.
   */
  public Employee(String name, int idNumber, String department, String position) {
    if (idNumber < 0) {
      throw new IllegalStateException();
    }
    this.name = Objects.requireNonNull(name);
    this.idNumber = idNumber;
    this.department = Objects.requireNonNull(department);
    this.position = Objects.requireNonNull(position);
  }

  /**
   * @return person name, may be empty.
   */
  public String getName() {
    return name;
  }

  /**
   * @param name person name, cannot be null.
   */
  public void setName(String name) {
    this.name = Objects.requireNonNull(name);
  }

  /**
   * @return company-issued ID.
   */
  public int getIdNumber() {
    return idNumber;
  }

  /**
   * @param idNumber company-issued ID, cannot be negative.
   */
  public void setIdNumber(int idNumber) {
    if (idNumber < 0) {
      throw new IllegalStateException();
    }
    this.idNumber = idNumber;
  }

  /**
   * @return company sub-branch, may be empty.
   */
  public String getDepartment() {
    return department;
  }

  /**
   * @param department company sub-branch, cannot be null.
   */
  public void setDepartment(String department) {
    this.department = Objects.requireNonNull(department);
  }

  /**
   * @return job role, may be empty.
   */
  public String getPosition() {
    return position;
  }

  /**
   * @param position job role, cannot be null.
   */
  public void setPosition(String position) {
    this.position = Objects.requireNonNull(position);
  }

  @Override
  public String toString() {
    return String.format("%s (%d/%s/%s)", name, idNumber, department, position);
  }
}
