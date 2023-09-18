////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 10.1 BankAccount and SavingsAccount Classes         //
// Date: 18/09/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A program that holds 10 savings accounts, each of which is a       //
// subtype of a bank account.                                         //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class BankAccountTest {
  @Test
  public void createAccount() {
    BankAccount specificAccount = new BankAccount(100, 1, 10) {};
    assertEquals(100, specificAccount.getBalance(), 0);
    assertEquals(1, specificAccount.getAnnualInterestRate(), 0);
    assertEquals(10, specificAccount.getMonthlyServiceCharges(), 0);

    BankAccount defaultAccount = new BankAccount(200) {};
    assertEquals(200, defaultAccount.getBalance(), 0);
    assertEquals(0.5, defaultAccount.getAnnualInterestRate(), 0);
    assertEquals(5, defaultAccount.getMonthlyServiceCharges(), 0);
  }

  @Test
  public void transaction() {
    BankAccount account = new BankAccount(0) {};

    assertEquals("Amount cannot be negative.",
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-1)).getMessage());
    assertEquals("Amount cannot be negative.",
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1)).getMessage());

    account.deposit(100);
    assertEquals(100, account.getBalance(), 0);

    account.withdraw(50);
    assertEquals(50, account.getBalance(), 0);
    assertEquals("Amount cannot be greater than balance.",
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(51)).getMessage());
  }

  @Test
  public void nextMonth() {
    BankAccount account = new BankAccount(0) {};

    account.deposit(100);
    account.withdraw(50);
    assertEquals(50, account.getBalance(), 0);
    assertEquals(1, account.getMonthlyDepositCount());
    assertEquals(1, account.getMonthlyWithdrawalCount());

    account.calcInterest();
    account.monthlyProcess();
    assertNotEquals(50, account.getBalance(), 0);
    assertEquals(0, account.getMonthlyDepositCount());
    assertEquals(0, account.getMonthlyWithdrawalCount());
  }
}
