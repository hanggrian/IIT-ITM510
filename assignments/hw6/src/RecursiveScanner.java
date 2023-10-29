////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Movie Library 2.0                                      //
// Date: 29/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A recursive CLI app that manages movie library using MVC design    //
// pattern.                                                           //
////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

/**
 * A wrapper of {@link Scanner} that endlessly prompts user until the input is valid according to
 * the specified restriction.
 */
public class RecursiveScanner {
  private final Scanner scanner = new Scanner(System.in);

  /**
   * Ask user for a text. This function will repeat itself if input is blank.
   *
   * @param prompt question to ask.
   * @return a text, never null.
   */
  public String scan(String prompt) {
    if (!isNullOrBlank(prompt)) {
      System.out.print(prompt + ' ');
    }
    String input = scanner.nextLine();
    if (isNullOrBlank(input)) {
      return scan("Cannot be empty, try again...");
    }
    return input;
  }

  /**
   * Ask user for a number. This function will repeat itself if input is blank, not a number, or not
   * in required range.
   *
   * @param prompt question to ask.
   * @param rangeFrom restriction's lower bound.
   * @param rangeTo restriction's upper bound.
   * @return an in bounds number.
   */
  public int scanInt(String prompt, int rangeFrom, int rangeTo) {
    if (!isNullOrBlank(prompt)) {
      System.out.print(prompt + ' ');
    }
    String input = scanner.nextLine();
    if (isNullOrBlank(input)) {
      return scanInt("Cannot be empty, try again...", rangeFrom, rangeTo);
    }
    try {
      int parsedResult = Integer.parseInt(input);
      if (rangeFrom <= parsedResult && parsedResult <= rangeTo) {
        return parsedResult;
      }
      return scanInt("Unknown input, try again...", rangeFrom, rangeTo);
    } catch (NumberFormatException e) {
      return scanInt("Parsing error, try again...", rangeFrom, rangeTo);
    }
  }

  /**
   * Ask user for a character. This function will repeat itself if input is blank, not a character,
   * or not in allowed inputs.
   *
   * @param prompt question to ask.
   * @param allowedInputs characters restriction.
   * @return an uppercase character.
   */
  public char scanChar(String prompt, char... allowedInputs) {
    if (!isNullOrBlank(prompt)) {
      System.out.print(prompt + ' ');
    }
    String input = scanner.nextLine();
    if (isNullOrBlank(input)) {
      return scanChar("Cannot be empty, try again...", allowedInputs);
    }
    if (input.length() != 1) {
      return scanChar("Parsing error, try again...", allowedInputs);
    }
    char parsedResult = Character.toUpperCase(input.charAt(0));
    for (char c : allowedInputs) {
      if (Character.toUpperCase(c) == parsedResult) {
        return parsedResult;
      }
    }
    return scanChar("Unknown input, try again...", allowedInputs);
  }

  private static boolean isNullOrBlank(String s) {
    return s == null || s.trim().isEmpty();
  }
}
