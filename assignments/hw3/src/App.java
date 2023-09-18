////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 10.1 BankAccount and SavingsAccount Classes         //
// Date: 18/09/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A program that holds 10 savings accounts, each of which is a       //
// subtype of a bank account.                                         //
////////////////////////////////////////////////////////////////////////

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Generates 10 random accounts and keep them in a natural ordering based on current balance amount.
 */
public class App {
  private static final int ACCOUNT_SIZE = 10;
  private static final int MIN_BALANCE = 5;
  private static final int MAX_BALANCE = 250;
  private static final double MIN_RATES = 0.1;
  private static final double MAX_RATES = 5;
  private static final int MIN_CHARGES = 1;
  private static final int MAX_CHARGES = 50;

  public static void main(String[] args) {
    // populate list
    Random random = new Random();
    Set<SavingsAccount> set = new TreeSet<>();
    for (int i = 0; i < ACCOUNT_SIZE; i++) {
      set.add(new SavingsAccount(
          random.nextInt(MAX_BALANCE + 1 - MIN_BALANCE) + MIN_BALANCE,
          MIN_RATES + (MAX_RATES + 1 - MIN_RATES) * random.nextDouble(),
          MIN_CHARGES + (MAX_CHARGES + 1 - MIN_CHARGES) * random.nextDouble()));
    }

    // print result
    int i = 0;
    Iterator<SavingsAccount> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(++i + ". " + iterator.next());
    }
  }
}
