////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Ex 12.1 Tip, Tax, and Total                            //
// Date: 02/10/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Single-window JavaFX app that takes food orders and calculate      //
// their prices at the bottom.                                        //
////////////////////////////////////////////////////////////////////////

package com.example.ui;

import javafx.scene.Node;
import javafx.scene.control.TitledPane;

/**
 * A titled pane without the collapsible arrow.
 */
public class FixedTitledPane extends TitledPane {
  public FixedTitledPane(String title, Node content) {
    super(title, content);
    setCollapsible(false);
  }
}
