////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

import i18n.State;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 * Utility class for IO operations such as loading employee database from a text file, and saving
 * Java objects into a binary file.
 */
public final class EmployeeFileConverter {
  public static final String FILENAME_TXT = "employeeDb.txt";
  public static final String FILENAME_DAT = "employeeDb.dat";

  private EmployeeFileConverter() {
  }

  /**
   * Writes a collection of employees into a text file.
   *
   * @param employees cannot be null.
   */
  public static void saveTextToFile(List<Employee> employees) {
    StringBuilder sb = new StringBuilder();
    for (Employee employee : employees) {
      sb.append(employee.toString());
      sb.append("\n");
    }
    try (OutputStream stream = Files.newOutputStream(Paths.get(FILENAME_TXT))) {
      String s = sb.toString();
      stream.write(s.getBytes(), 0, s.length());
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Error saving file %s: %s%n", FILENAME_TXT, e.getMessage()));
    }
  }

  /**
   * Reads a text file and returns a collection of employees of all the parsed objects.
   *
   * @return parsed objects.
   */
  public static List<Employee> loadTextFromFile() {
    List<Employee> employees = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME_TXT))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(" \\| ");
        employees.add(new Employee(
            data[0],
            data[1],
            data[2],
            data[3],
            data[4],
            State.valueOf(data[5]),
            Integer.parseInt(data[6]),
            data[7],
            data[8],
            Double.parseDouble(data[9]),
            LocalDate.parse(data[10])));
      }
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Error loading file %s: %s%n", FILENAME_TXT, e.getMessage()));
    }
    return employees;
  }

  /**
   * Writes a copy of employee collection into a binary file.
   *
   * @param employees cannot be null.
   */
  public static void saveDataToFile(List<Employee> employees) {
    try (ObjectOutputStream stream =
             new ObjectOutputStream(Files.newOutputStream(Paths.get(FILENAME_DAT)))) {
      stream.writeObject(new ArrayList<>(employees));
    } catch (IOException e) {
      throw new RuntimeException(
          String.format("Error saving serializable %s: %s%n", FILENAME_DAT, e.getMessage()));
    }
  }

  /**
   * Reads a binary file and replace employee collection items with the parsed objects.
   *
   * @param employees JavaFX collection, cannot be null.
   * @return true if file exists.
   */
  public static boolean loadDataFromFile(ObservableList<Employee> employees) {
    Path path = Paths.get(FILENAME_DAT);
    if (!Files.exists(path)) {
      return false;
    }
    try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(path))) {
      Object obj = stream.readObject();
      if (obj instanceof ArrayList) {
        employees.setAll((List<Employee>) obj);
      }
      return true;
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(
          String.format("Error loading serializable %s: %s%n", FILENAME_DAT, e.getMessage()));
    }
  }
}
