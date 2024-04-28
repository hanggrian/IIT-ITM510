<style type="text/css">ol { list-style-type: upper-alpha; }</style>

# Quiz 5: Exceptions and Advanced File I/O

- Handling Exceptions
- Throwing Exceptions
- More about Input/Output Streams
- Advanced Topics:
  - Binary Files,
  - Random Access Files, and
  - Object Serialization

## Problem 1

> The ability to catch multiple types of exceptions with a single `catch` clause
  is known as multi-catch and was introduced in Java 7.
>
> 1.  True
> 1.  False

**A.** True

## Problem 2

> A `catch` clause that uses a parameter variable of the `Exception` type is
  capable of catching any exception that extends the `Error` class.
>
> 1.  True
> 1.  False

**B.** False

## Problem 3

> When an object is serialized, it is converted into a series of bytes that
  contain the object's data.
>
> 1.  True
> 1.  False

**A.** True

## Problem 4

> What What will the following code display?
>
> ```java
> String input = "99#7";
> int number;
> try {
>   number = Integer.parseInt (input);
> } catch (NumberFormatException ex) {
>   number = 0;
> } catch (RuntimeException ex) {
>   number = 1;
> } catch (Exception ex) {
>   number = -1;
> }
> System.out.printIn (number);
> ```
>
> 1.  -1
> 1.  0
> 1.  1
> 1.  99

**B.** 0

## Problem 5

> If you want to append data to an existing binary file, `BinaryFile.dat`, which
  of the following statements would you use to open the file?
>
> 1.
>
> ```java
> FileOutputStream fstream = new FileOutputStream("BinaryFile.dat");
> DataOutputStream binaryOutputFile = new DataOutputStream(fstream);
> ```
>
> 2.
>
> ```java
> FileOutputStream fstream = new FileOutputStream("BinaryFile.dat", false);
> DataOutputStream binaryOutputFile = new DataOutputStream(fstream);
> ```
>
> 3.
>
> ```java
> FileOutputStream fstream = new FileOutputStream("BinaryFile.dat", true);
> DataOutputStream binaryOutputFile = new DataOutputStream(fstream);
> ```
>
> 4.
>
> ```java
> IFileOutputStream fstream = new FileOutputStream("BinaryFile.dat");
> DataOutputStream binaryOutputFile = new DataOutputStream(fstream, true);
> ```

**C.** 3

## Problem 6

> An exception's default error message can be retrieved by using the
>
> 1.  `getMessage()`
> 1.  `getErrorMessage()`
> 1.  `getDefaultMessage()`
> 1.  `getDefaultErrorMessage()`

**A.** `getMessage()`

## Problem 7

> A file that contains raw binary data is known as a ______.
>
> 1.  binary file
> 1.  machine file
> 1.  serial file
> 1.  raw data file

**A.** binary file

## Problem 8

> In a catch statement, what does the following code do?
>
> ```java
> System.out.println(e.getMessage());
> ```
>
> 1.  It prints the code that caused the exception.
> 1.  It prints the stack trace.
> 1.  It prints the error message for an exception.
> 1.  It overrides the tostring method.

**C.** It prints the error message for an exception.

## Problem 9

> In the following code, assume that `inputFile` references a `Scanner` object
  that has been successfully used to open a file:
>
> ```java
> double totalIncome = 0.0;
> while (inputFile.hasNext()) {
>   try {
>     totalIncome += inputFile.nextDouble();
>   } catch (InputMismatchException ex) {
>     System.out.println("Non-numeric data encountered " +
>         "in the file.");
>     inputFile.nextLine();
>   } finally {
>     totalIncome = 35.5;
>   }
> }
> ```
>
> What will be the value of `totalIncome` after the following values are read
  from the file?
>
> ```
> 2.5
> 8.5
> 3.0
> 5.5
> abc
> 1.0
> ```
>
> 1.  18.5
> 1.  0.0
> 1.  35.5
> 1.  75.0

**C.** 35.5

## Problem 10

> The `IllegalArgumentException` class extends the `RuntimeException` class and
  is, therefore, ______.
>
> 1.  a checked exception class
> 1.  an unchecked exception class
> 1.  never used directly
> 1.  None of these

**B.** an unchecked exception class

## Problem 11

> If your code does not handle an exception when it is thrown, ______ prints an
  error message and crashes the program.
>
> 1.  the Java error handler
> 1.  multi-catch
> 1.  default exception handler
> 1.  `try` statement

**C.** default exception handler

## Problem 12

> The `RandomAccessFile` class treats a file as a stream of ______.
>
> 1.  bytes
> 1.  characters
> 1.  integers
> 1.  data

**A.** bytes
