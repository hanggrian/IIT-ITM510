# Homework 3

- `BankAccount` is an abstract class that holds common properties like balance,
  interest rates, and monthly fees.
- `SavingsAccount` is a subclass of `BankAccount` that holds additional
  components such as active status and cap on monthly withdrawals.
- `App` is a driver class that generates random accounts and keeps them in a
  self-sorting set.

## Screenshots

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw3/screenshot1.png"><br><small>Screenshot 1 &mdash; App</small>

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw3/screenshot2.png"><br><small>Screenshot 2 &mdash; Tests</small>

## Diagrams

<img width="640" src="https://github.com/hendraanggrian/IIT-ITM510/raw/assets/assignments/hw3/diagram1.png"><br><small>Diagram 1 &mdash; UML</small>

> ## Instructions
>
> **BankAccount and SavingsAccount Classes**
>
> Design an abstract class named BankAccount to hold the following data for a
  bank account:
>
> - Balance
> - Number of deposits this month
> - Number of withdrawals
> - Annual interest rate
> - Monthly service charges
>
> The class should have the following methods:
>
> | Method | Description |
> | --- | --- |
> | Constructor | The constructor should accept arguments for the balance and annual interest rate. |
> | `deposit` | A method that accepts an argument for the amount of the deposit. The method should add the argument to the account balance. It should also increment the variable holding the number of deposits. |
> | `withdraw` | A method that accepts an argument for the amount of the withdrawal. The method should subtract the argument from the balance. It should also increment the variable holding the number of withdrawals. |
> | `calcInterest` | A method that updates the balance by calculating the monthly interest earned by the account, and adding this interest to the balance. This is performed by the following formulas:<br><ul><li>Monthly Interest Rate = (Annual Interest Rate/12)</li><li>Monthly Interest = Balance * Monthly Interest Rate</li><li>Balance = Balance + Monthly Interest</li></ul> |
> | `monthlyProcess` | A method that subtracts the monthly service charges from the balance, calls the `calcInterest` method, and then sets the variables that hold the number of withdrawals, number of deposits, and monthly service charges to zero. |
>
> Next, design a SavingsAccount class that extends the BankAccount class. The
  SavingsAccount class should have a status field to represent an active or
  inactive account. If the balance of a savings account falls below $25, it
  becomes inactive. (The status field could be a boolean variable.) No more
  withdrawals may be made until the balance is raised above $25, at which time
  the account becomes active again. The savings account class should have the
  following methods:
>
> | Method | Description |
> | --- | --- |
> | `withdraw` | A method that determines whether the account is inactive before a withdrawal is made. (No withdrawal will be allowed if the account is not active.) A withdrawal is then made by calling the superclass version of the method. |
> | `deposit` | A method that determines whether the account is inactive before a deposit is made. If the account is inactive and the deposit brings the balance above $25, the account becomes active again. A deposit is then made by calling the superclass version of the method. |
> | `monthlyProcess` | Before the superclass method is called, this method checks the number of withdrawals. If the number of withdrawals for the month is more than 4, a service charge of $1 for each withdrawal above 4 is added to the superclass field that holds the monthly service charges. (Don't forget to check the account balance after the service charge is taken. If the balance falls below $25, the account becomes inactive.) |
>
> Override the toString, compareTo and equals methods.
>
> - [Effective Java Tuesday! Override `toString`](https://dev.to/kylec32/effective-java-tuesday-override-tostring-14n7)
> - [Effective Java Tuesday! Obey the `equals` contract](https://dev.to/kylec32/effective-java-tuesday-obey-the-equals-contract-4df4)
> - [Java String compareTo() Method with Examples](https://www.geeksforgeeks.org/java-string-compareto-method-with-examples/)
>
> Create a UML diagram of the BankAccount and SavingsAccount classes. Show any
  relationships. See [Software Design Resources](https://blackboard.iit.edu/webapps/blackboard/content/listContentEditable.jsp?content_id=_1325275_1&course_id=_138996_1).
>
> Demonstrate the SavingsAccount class in a program that has an ArrayList
  containing 10 random SavingsAccount objects.  The program should then step
  through the ArrayList, printing each object.
>
> ### Please submit the following:
>
> 1. An exported image (jpeg or png only) of your UML diagram
> 2. A captured image of your screen showing your program’s output
> 3. The compressed (zipped) folder containing your **_entire_** project
