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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SavingsAccountTest {
  @Test
  public void accountStatus() {
    SavingsAccount account = new SavingsAccount(0, 0, 0);
    assertFalse(account.isActive());

    account.deposit(50);
    assertTrue(account.isActive());

    // trigger extra service fee
    account.withdraw(5);
    account.withdraw(5);
    account.withdraw(5);
    account.withdraw(5);
    account.withdraw(5);
    account.monthlyProcess();
    assertEquals(25 - 1, account.getBalance(), 0);
  }
}
