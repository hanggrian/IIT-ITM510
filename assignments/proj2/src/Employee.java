////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.JANUARY;
import static java.util.Objects.requireNonNull;

import com.github.javafaker.Faker;
import i18n.State;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Data class that represents an employee assumed to be located in the US. Therefore, phone number
 * and state follows US format.
 */
public class Employee implements Serializable {
  private static final Pattern PATTERN_PHONE_NUMBER = Pattern.compile("^\\d{10}$");
  private static final Date DATE_FROM = new GregorianCalendar(1980, JANUARY, 1).getTime();
  private static final Date DATE_TO = new GregorianCalendar(2020, DECEMBER, 30).getTime();
  private static Faker faker; // generate random data

  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;
  private String city;
  private State state;
  private int employeeId;
  private String employeeTitle;
  private String department;
  private double salary;
  private LocalDate hireDate;

  /**
   * Single constructor with all the declared properties.
   *
   * @param firstName     given name, cannot be empty.
   * @param lastName      surname, cannot be empty.
   * @param phoneNumber   10-digits telephone number, cannot be empty. (e.g: {@code 5551234567})
   * @param address       residing street, cannot be empty.
   * @param city          residing town, cannot be empty.
   * @param state         residing state, cannot be null. (e.g.: {@code i18n.State.CA})
   * @param employeeId    work identification, starts from 1.
   * @param employeeTitle job description, cannot be empty.
   * @param department    company subsection, cannot be empty.
   * @param salary        hourly wage, starts from 0.0.
   * @param hireDate      immutable hiring appointment, cannot be null.
   */
  public Employee(
      String firstName,
      String lastName,
      String phoneNumber,
      String address,
      String city,
      State state,
      int employeeId,
      String employeeTitle,
      String department,
      double salary,
      LocalDate hireDate
  ) {
    setFirstName(firstName);
    setLastName(lastName);
    setPhoneNumber(phoneNumber);
    setAddress(address);
    setCity(city);
    setState(state);
    setEmployeeId(employeeId);
    setEmployeeTitle(employeeTitle);
    setDepartment(department);
    setSalary(salary);
    this.hireDate = Objects.requireNonNull(hireDate, "Missing hire date.");
  }

  /**
   * @return given name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param name given name, cannot be empty.
   */
  public void setFirstName(String name) {
    if (requireNonNull(name).isEmpty()) {
      throw new IllegalArgumentException("Missing first name.");
    }
    this.firstName = name;
  }

  /**
   * @return surname.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param name surname, cannot be empty.
   */
  public void setLastName(String name) {
    if (requireNonNull(name).isEmpty()) {
      throw new IllegalArgumentException("Missing last name.");
    }
    this.lastName = name;
  }

  /**
   * @return 10-digits telephone number.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param number 10-digits telephone number, cannot be empty.
   */
  public void setPhoneNumber(String number) {
    if (requireNonNull(number).isEmpty()) {
      throw new IllegalArgumentException("Missing phone number.");
    } else if (!PATTERN_PHONE_NUMBER.matcher(number).matches()) {
      throw new IllegalArgumentException("Phone number should be 10-digits.");
    }
    this.phoneNumber = number;
  }

  /**
   * @return residing street.
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address residing street, cannot be empty.
   */
  public void setAddress(String address) {
    if (requireNonNull(address).isEmpty()) {
      throw new IllegalArgumentException("Missing address.");
    }
    this.address = address;
  }

  /**
   * @return residing town.
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city residing town, cannot be empty.
   */
  public void setCity(String city) {
    if (requireNonNull(city).isEmpty()) {
      throw new IllegalArgumentException("Missing city.");
    }
    this.city = city;
  }

  /**
   * @return residing state.
   */
  public State getState() {
    return state;
  }

  /**
   * @param state residing state, cannot be null.
   */
  public void setState(State state) {
    this.state = Objects.requireNonNull(state, "Missing state.");
  }

  /**
   * @return work identification.
   */
  public int getEmployeeId() {
    return employeeId;
  }

  /**
   * @param id work identification, starts from 1.
   */
  public void setEmployeeId(int id) {
    if (id < 1) {
      throw new IllegalArgumentException("Employee ID starts from 1.");
    }
    this.employeeId = id;
  }

  /**
   * @return job description.
   */
  public String getEmployeeTitle() {
    return employeeTitle;
  }

  /**
   * @param title job description, cannot be empty.
   */
  public void setEmployeeTitle(String title) {
    if (requireNonNull(title).isEmpty()) {
      throw new IllegalArgumentException("Missing employee title.");
    }
    this.employeeTitle = title;
  }

  /**
   * @return company subsection.
   */
  public String getDepartment() {
    return department;
  }

  /**
   * @param dept company subsection, cannot be empty.
   */
  public void setDepartment(String dept) {
    if (requireNonNull(dept).isEmpty()) {
      throw new IllegalArgumentException("Missing department.");
    }
    this.department = dept;
  }

  /**
   * @return hourly wage.
   */
  public double getSalary() {
    return salary;
  }

  /**
   * @param salary hourly wage, starts from 0.0.
   */
  public void setSalary(double salary) {
    if (salary < 0) {
      throw new IllegalArgumentException("Salary starts from 0.0.");
    }
    this.salary = salary;
  }

  /**
   * @return hiring appointment.
   */
  public LocalDate getHireDate() {
    return hireDate;
  }

  /**
   * A line that will be printed into 'employeeDb.txt'.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getFirstName());
    sb.append(" | ");
    sb.append(getLastName());
    sb.append(" | ");
    sb.append(getPhoneNumber());
    sb.append(" | ");
    sb.append(getAddress());
    sb.append(" | ");
    sb.append(getCity());
    sb.append(" | ");
    sb.append(getState().name());
    sb.append(" | ");
    sb.append(getEmployeeId());
    sb.append(" | ");
    sb.append(getEmployeeTitle());
    sb.append(" | ");
    sb.append(getDepartment());
    sb.append(" | ");
    sb.append(getSalary());
    sb.append(" | ");
    sb.append(getHireDate());
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return employeeId == employee.employeeId
        && Double.compare(salary, employee.salary) == 0
        && Objects.equals(firstName, employee.firstName)
        && Objects.equals(lastName, employee.lastName)
        && Objects.equals(phoneNumber, employee.phoneNumber)
        && Objects.equals(address, employee.address)
        && Objects.equals(city, employee.city)
        && state == employee.state
        && Objects.equals(employeeTitle, employee.employeeTitle)
        && Objects.equals(department, employee.department)
        && Objects.equals(hireDate, employee.hireDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
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

  /**
   * Returns an instance of employee using generated data from {@link Faker}.
   */
  public static Employee randomize() {
    if (faker == null) {
      faker = new Faker();
    }
    String profession = faker.company().profession();
    profession = profession.substring(0, 1).toUpperCase() + profession.substring(1);
    return new Employee(
        faker.name().firstName(),
        faker.name().lastName(),
        faker.numerify("##########"),
        faker.address().streetAddress(),
        faker.address().cityName(),
        State.valueOf(faker.address().stateAbbr()),
        (int) faker.number().randomNumber(3, false),
        profession,
        faker.company().industry(),
        Double.parseDouble(faker.commerce().price()),
        faker.date().between(DATE_FROM, DATE_TO)
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate());
  }
}
