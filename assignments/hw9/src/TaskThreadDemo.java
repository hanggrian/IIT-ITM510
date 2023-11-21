////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: TaskThreadDemo                                         //
// Date: 20/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A multithreading practice of updating JavaFX components in UI      //
// thread.                                                            //
////////////////////////////////////////////////////////////////////////

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Modified version of <a href="https://liveexample.pearsoncmg.com/html/TaskThreadDemo.html">TaskThreadDemo</a>
 * that uses JavaFX text area to display the output.
 */
public class TaskThreadDemo extends Application {
  public static void main(String[] args) {
    launch(TaskThreadDemo.class);
  }

  private TextArea area;

  @Override
  public void init() {
    area = new TextArea();
    area.setFont(new Font(16));
    area.setEditable(false);
    area.setWrapText(true);

    // create tasks
    Runnable printA = new PrintChar(area, 'a', 100);
    Runnable printB = new PrintChar(area, 'b', 100);
    Runnable print100 = new PrintNum(area, 100);

    // create threads
    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);
    Thread thread3 = new Thread(print100);

    // start threads
    thread1.start();
    thread2.start();
    thread3.start();
  }

  @Override
  public void start(Stage stage) {
    stage.setTitle("Concurrent Output");
    stage.setMinWidth(600);
    stage.setMinHeight(200);
    stage.setWidth(600);
    stage.setHeight(200);
    stage.setScene(new Scene(area));
    stage.show();
  }
}

/**
 * The task for printing a specified character in specified times.
 */
class PrintChar implements Runnable {
  private final TextInputControl control;
  private final char charToPrint; // the character to print
  private final int times; // the times to repeat

  public PrintChar(TextInputControl ctrl, char c, int t) {
    control = ctrl;
    charToPrint = c;
    times = t;
  }

  @Override
  public void run() {
    for (int i = 0; i < times; i++) {
      Platform.runLater(() -> control.appendText(String.valueOf(charToPrint)));
    }
  }
}

/**
 * The task class for printing number from 1 to n for a given n.
 */
class PrintNum implements Runnable {
  private final TextInputControl control;
  private final int lastNum;

  public PrintNum(TextInputControl ctrl, int n) {
    control = ctrl;
    lastNum = n;
  }

  @Override
  public void run() {
    for (int i = 1; i <= lastNum; i++) {
      final int finalI = i;
      Platform.runLater(() -> control.appendText(String.format(" %d", finalI)));
    }
  }
}
