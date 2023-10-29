////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 12.1 Tip, Tax, and Total                            //
// Date: 02/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Single-window JavaFX app that takes food orders and calculate      //
// their prices at the bottom.                                        //
////////////////////////////////////////////////////////////////////////

package com.example;

import com.example.ui.InfoDialog;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main Java application runner and also JavaFX FXML controller. Cannot be run using
 * {@link App#main(String[])} without JavaFX classpath in the configuration. Instead, execute the
 * program using {@code ./gradlew run}.
 */
public class App extends Application implements Initializable {
  private static final double SCALE_TIP = 0.18;
  private static final double SCALE_TAX = 0.07;

  @FXML private VBox root;
  @FXML private MenuItem orderMenu;
  @FXML private MenuItem removeMenu;
  @FXML private TextField nameField;
  @FXML private TextField priceField;
  @FXML private Button orderButton;
  @FXML private ListView<Food> foodList;
  @FXML private Label subtotalLabel;
  @FXML private Label tipLabel;
  @FXML private Label taxLabel;
  @FXML private Label totalLabel;

  private final DoubleProperty subtotalProperty = new SimpleDoubleProperty();
  private final DoubleProperty tipProperty = new SimpleDoubleProperty();
  private final DoubleProperty taxProperty = new SimpleDoubleProperty();
  private final DoubleProperty totalProperty = new SimpleDoubleProperty();

  public static void main(String[] args) {
    Application.launch(App.class, args);
  }

  @Override
  public void start(Stage stage) {
    Parent inflate;
    try {
      inflate = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
    } catch (IOException e) {
      new InfoDialog("Error", "Fatal JavaFX error.", e.getMessage()).showAndWait();
      return;
    }

    stage.setTitle("Restaurant Order");
    stage.setMinWidth(250);
    stage.setMinHeight(500);
    stage.setScene(new Scene(inflate));
    stage.show();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    subtotalProperty.bind(Bindings.createDoubleBinding(() ->
        foodList.getItems().stream().mapToDouble(Food::getPrice).sum(), foodList.getItems()));
    subtotalLabel.textProperty().bind(Bindings.createStringBinding(() ->
        String.format("Sub Total: $%s", Strings
            .dollarize(subtotalProperty.doubleValue())), subtotalProperty));

    tipProperty.bind(Bindings.multiply(subtotalProperty, SCALE_TIP));
    tipLabel.textProperty().bind(Bindings.createStringBinding(() ->
        String.format("Service Charge 18%%: $%s", Strings
            .dollarize(tipProperty.doubleValue())), tipProperty));

    taxProperty.bind(Bindings.multiply(subtotalProperty, SCALE_TAX));
    taxLabel.textProperty().bind(Bindings.createStringBinding(() ->
        String.format("Service Tax 7%%: $%s", Strings
            .dollarize(taxProperty.doubleValue())), taxProperty));

    totalProperty.bind(Bindings.createDoubleBinding(() -> subtotalProperty.doubleValue()
        + tipProperty.doubleValue() + taxProperty.doubleValue(), foodList.getItems()));
    totalLabel.textProperty().bind(Bindings.createStringBinding(() ->
        String.format("Total%%: $%s", Strings
            .dollarize(totalProperty.doubleValue())), totalProperty));

    BooleanBinding orderBinding = Bindings.createBooleanBinding(() -> {
      if (nameField.getText().isEmpty() || priceField.getText().isEmpty()) {
        return true;
      }
      try {
        Double.parseDouble(priceField.getText());
        return false;
      } catch (NumberFormatException e) {
        return true;
      }
    }, nameField.textProperty(), priceField.textProperty());
    orderMenu.disableProperty().bind(orderBinding);
    orderButton.disableProperty().bind(orderBinding);

    removeMenu.disableProperty().bind(foodList.getSelectionModel().selectedItemProperty().isNull());
  }

  @FXML
  public void quit() {
    Platform.exit();
    System.exit(0);
  }

  @FXML
  public void minimize() {
    ((Stage) root.getScene().getWindow()).setIconified(true);
  }

  @FXML
  public void zoom() {
    ((Stage) root.getScene().getWindow()).setMaximized(true);
  }

  @FXML
  public void about() {
    new InfoDialog("About", "When a button is clicked, the application should calculate and "
        + "display the amount of an 18 percent tip on the total food charge, 7 percent sales tax, "
        + "and the total of all three amounts.")
        .showAndWait();
  }

  @FXML
  public void clear() {
    foodList.getItems().clear();
    priceField.clear();
    nameField.clear();
    nameField.requestFocus();
  }

  @FXML
  public void remove() {
    foodList.getItems().remove(foodList.getSelectionModel().getSelectedItem());
  }

  @FXML
  public void order() {
    double price = Double.parseDouble(priceField.getText()); // always successful because of binding
    foodList.getItems().add(new Food(nameField.getText(), price));
  }
}
