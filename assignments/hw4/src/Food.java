////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 12.1 Tip, Tax, and Total                            //
// Date: 02/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Single-window JavaFX app that takes food orders and calculate      //
// their prices at the bottom.                                        //
////////////////////////////////////////////////////////////////////////

/**
 * Data class representing an order in the menu.
 */
public class Food {
  private final String name;
  private final double price;

  /**
   * Creates an instance of com.example.Food.
   *
   * @param name cuisine, cannot be blank or null.
   * @param price in USD, cannot be less than 0.
   */
  public Food(String name, double price) {
    if (Strings.isBlank(name) || price <= 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.price = price;
  }

  /**
   * Returns the food price.
   *
   * @return USD price.
   */
  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return String.format("%s ($%s)", name, Strings.dollarize(price));
  }
}
