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
 * Base class of {@link SavingsAccount}. Balance has no setter, instead, use
 * {@link #deposit(double)} and {@link #withdraw(double)}.
 */
public abstract class BankAccount {
  private static final double DEFAULT_INTEREST_RATES = 0.5;
  private static final double DEFAULT_SERVICE_CHARGES = 5;

  protected double balance;
  protected double annualInterestRate;
  protected double monthlyServiceCharges;
  protected int monthlyDepositCount = 0;
  protected int monthlyWithdrawalCount = 0;

  /**
   * Creates a new bank account using default annual interest rates and monthly service charges.
   */
  public BankAccount(double balance) {
    this(balance, DEFAULT_INTEREST_RATES, DEFAULT_SERVICE_CHARGES);
  }

  /**
   * Creates a new bank account using default monthly service charges.
   */
  public BankAccount(double balance, double annualInterestRate) {
    this(balance, annualInterestRate, DEFAULT_SERVICE_CHARGES);
  }

  /**
   * Creates a new bank account.
   */
  public BankAccount(double balance, double annualInterestRate, double monthlyServiceCharges) {
    this.balance = balance;
    this.annualInterestRate = annualInterestRate;
    this.monthlyServiceCharges = monthlyServiceCharges;
  }

  /**
   * @return total cash.
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Add cash to account balance.
   *
   * @param amount cash, cannot be negative.
   */
  public void deposit(double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative.");
    }
    balance += amount;
    monthlyDepositCount++;
  }

  /**
   * Subtract cash from account balance, assuming that the balance is sufficient.
   *
   * @param amount cash, cannot be negative.
   */
  public void withdraw(double amount) {
    if (amount < 0 ) {
      throw new IllegalArgumentException("Amount cannot be negative.");
    } else if (amount > balance) {
      throw new IllegalArgumentException("Amount cannot be greater than balance.");
    }
    balance -= amount;
    monthlyWithdrawalCount++;
  }

  /**
   * @return percentage of annual interest rate.
   */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /**
   * @param rate percentage of annual interest rate.
   */
  public void setAnnualInterestRate(double rate) {
    annualInterestRate = rate;
  }

  /**
   * @return monthly fee.
   */
  public double getMonthlyServiceCharges() {
    return monthlyServiceCharges;
  }

  /**
   * @param monthlyServiceCharges monthly fee.
   */
  public void setMonthlyServiceCharges(double charges) {
    monthlyServiceCharges = charges;
  }

  /**
   * @return number of deposits made this month.
   */
  public int getMonthlyDepositCount() {
    return monthlyDepositCount;
  }

  /**
   * @return number of withdrawals made this month.
   */
  public int getMonthlyWithdrawalCount() {
    return monthlyWithdrawalCount;
  }

  /**
   * Add monthly interest to account balance.
   */
  public void calcInterest() {
    double monthlyInterestRate = annualInterestRate / 12;
    double monthlyInterest = balance * monthlyInterestRate;
    balance += monthlyInterest;
  }

  /**
   * Charges monthly service charges to account balance, resetting the counters in the process.
   */
  public void monthlyProcess() {
    balance -= monthlyServiceCharges;
    calcInterest();
    monthlyDepositCount = 0;
    monthlyWithdrawalCount = 0;
    monthlyServiceCharges = 0;
  }
}
