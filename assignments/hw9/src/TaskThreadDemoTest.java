////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: TaskThreadDemo                                         //
// Date: 20/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// A multithreading practice of updating JavaFX components in UI      //
// thread.                                                            //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;

import com.sun.javafx.application.PlatformImpl;
import java.util.stream.IntStream;
import javafx.scene.control.TextField;
import org.junit.Before;
import org.junit.Test;

public class TaskThreadDemoTest {
  @Before
  public void init() {
    // required to unit test JavaFX components
    PlatformImpl.startup(() -> {
    });
  }

  @Test
  public void joining() {
    TextField field = new TextField();
    Thread threadChar = new Thread(new PrintChar(field, 'a', 100));
    Thread threadNum = new Thread(new PrintNum(field, 100));

    try {
      threadChar.start();
      threadChar.join();
      threadNum.start();
      threadNum.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    StringBuilder sb = new StringBuilder();
    IntStream.range(0, 100).forEach(i -> sb.append('a'));
    IntStream.rangeClosed(1, 100).forEach(i -> sb.append(String.format(" %d", i)));

    // need to wait until all texts are appended
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(sb.toString(), field.getText());
  }
}
