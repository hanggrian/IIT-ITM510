////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library                                          //
// Date: 09/16/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A self-repeating CLI application that manages movie library.       //
////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

/**
 * An extension to a standard {@link Scanner} that endlessly prompts user until the input is valid
 * according to the specified restriction.
 */
public class ScannerWrapper {
  private final Scanner scanner;

  /**
   * Default constructor using standard input stream.
   */
  public ScannerWrapper() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Ask user for a text. This function will repeat itself if input is blank.
   *
   * @param prompt question to ask.
   */
  public String read(String prompt) {
    System.out.print(prompt + ' ');
    String result = scanner.nextLine();
    if (isNullOrBlank(result)) {
      return read("Cannot be empty, try again...");
    }
    return result;
  }

  /**
   * Ask user for a number. This function will repeat itself if input is blank, not a number, or not
   * in required range.
   *
   * @param prompt question to ask.
   * @param rangeFrom range restriction's lower bound.
   * @param rangeTo range restriction's upper bound.
   */
  public int readInt(String prompt, int rangeFrom, int rangeTo) {
    System.out.print(prompt + ' ');
    String result = scanner.nextLine();
    if (isNullOrBlank(result)) {
      return readInt("Cannot be empty, try again...", rangeFrom, rangeTo);
    }
    try {
      int parsedResult = Integer.parseInt(result);
      if (rangeFrom <= parsedResult && parsedResult <= rangeTo) {
        return parsedResult;
      }
      return readInt("Unknown input, try again...", rangeFrom, rangeTo);
    } catch (NumberFormatException e) {
      return readInt("Parsing error, try again...", rangeFrom, rangeTo);
    }
  }

  /**
   * Ask user for a character. This function will repeat itself if input is blank, not a character,
   * or not in allowed inputs.
   *
   * @param prompt question to ask.
   * @param allowedInputs characters restriction.
   */
  public char readChar(String prompt, char... allowedInputs) {
    System.out.print(prompt + ' ');
    String result = scanner.nextLine();
    if (isNullOrBlank(result)) {
      return readChar("Cannot be empty, try again...", allowedInputs);
    }
    if (result.length() != 1) {
      return readChar("Parsing error, try again...", allowedInputs);
    }
    char parsedResult = Character.toUpperCase(result.charAt(0));
    for (char c : allowedInputs) {
      if (Character.toUpperCase(c) == parsedResult) {
        return parsedResult;
      }
    }
    return readChar("Unknown input, try again...", allowedInputs);
  }

  private static boolean isNullOrBlank(String s) {
    return s == null || s.isEmpty() || s.trim().isEmpty();
  }
}
