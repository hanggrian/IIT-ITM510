////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 10.1 BankAccount and SavingsAccount Classes         //
// Date: 18/09/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A program that holds 10 savings accounts, each of which is a       //
// subtype of a bank account.                                         //
////////////////////////////////////////////////////////////////////////

/**
 * A subclass of {@link BankAccount} with 2 extra rules:
 *
 * - A minimum balance of $25 is required to be considered active.
 * - An extra service fee of $1 is charged for each withdrawal over 4 per month.
 */
public class SavingsAccount extends BankAccount implements Comparable<SavingsAccount> {
  private boolean active;

  /**
   * {@inheritDoc}
   */
  public SavingsAccount(double balance) {
    super(balance);
    active = balance >= 25;
  }

  /**
   * {@inheritDoc}
   */
  public SavingsAccount(double balance, double annualInterestRate) {
    super(balance, annualInterestRate);
    active = balance >= 25;
  }

  /**
   * {@inheritDoc}
   */
  public SavingsAccount(double balance, double annualInterestRate, double monthlyServiceCharges) {
    super(balance, annualInterestRate, monthlyServiceCharges);
    active = balance >= 25;
  }

  /**
   * @return true if the account is active.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deposit(double amount) {
    super.deposit(amount);
    if (!active && balance >= 25) {
      active = true;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void withdraw(double amount) {
    if (!active) {
      throw new IllegalStateException("Account is inactive");
    }
    super.withdraw(amount);
    if (active && balance < 25) {
      active = false;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void monthlyProcess() {
    if (monthlyWithdrawalCount > 4) {
      monthlyServiceCharges += monthlyWithdrawalCount - 4;
    }
    super.monthlyProcess();
    active = balance >= 25;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (!active) {
      builder.append("Inactive: ");
    }
    builder.append(String.format("$%,.0f (%.2f%% @year/$%,.0f @month)",
        balance, annualInterestRate, monthlyServiceCharges));
    return builder.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof SavingsAccount) {
      return super.equals(other) && active == ((SavingsAccount) other).active;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return super.hashCode() + Boolean.hashCode(active);
  }

  @Override
  public int compareTo(SavingsAccount other) {
    return Double.compare(balance, other.balance);
  }
}
