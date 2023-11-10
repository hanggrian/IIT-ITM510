////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: ImageViewer (Generic Linked List)                      //
// Date: 06/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Sliding navigation with a side panel list showing current picture  //
// collection.                                                        //
////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DLinkedListTest {
  @Test
  public void crud() {
    DLinkedList<String> list = new DLinkedList<>();

    list.add("Amy");
    list.add("Bob");
    list.add(0, "Al");
    list.add(2, "Beth");
    list.add(4, "Carol");
    assertEquals("Al", list.get(0));
    assertEquals("Amy", list.get(1));
    assertEquals("Beth", list.get(2));
    assertEquals("Bob", list.get(3));
    assertEquals("Carol", list.get(4));

    String amy = list.set(1, "Amelia");
    assertEquals("Amelia", list.get(1));
    assertEquals("Amy", amy);

    String beth = list.remove(2);
    list.remove("Carol");
    assertEquals("Beth", beth);
    assertEquals("Bob", list.get(2));
    assertEquals(3, list.size());

    list.clear();
    assertTrue(list.isEmpty());
  }
}
