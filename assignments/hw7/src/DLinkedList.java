////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: ImageViewer (Generic Linked List)                      //
// Date: 06/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Sliding navigation with a side panel list showing current picture  //
// collection.                                                        //
////////////////////////////////////////////////////////////////////////

/**
 * The DLinkedList class implements a doubly Linked list.
 *
 * @param <E> the type element of this collection.
 */
public class DLinkedList<E> {
  /**
   * The Node class stores a list element and a reference to the next node.
   */
  private class Node {
    E value;
    Node next;
    Node prev;

    /**
     * @param val The element to be stored in the node.
     * @param n   The reference to the successor node.
     * @param p   The reference to the predecessor node.
     */
    Node(E val, Node n, Node p) {
      value = val;
      next = n;
      prev = p;
    }

    /**
     * @param val The element to be stored in the node.
     */
    Node(E val) {
      this(val, null, null);
    }
  }

  private Node first;
  private Node last;

  /**
   * Constructs an empty list.
   */
  public DLinkedList() {
    first = null;
    last = null;
  }

  /**
   * The isEmpty method checks to see if the list is empty.
   *
   * @return true if list is empty, false otherwise.
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * The size method returns the length of the list.
   *
   * @return The number of elements in the list.
   */
  public int size() {
    int count = 0;
    Node p = first;
    while (p != null) {
      // There is an element at p
      count++;
      p = p.next;
    }
    return count;
  }

  /**
   * The add method adds to the end of the list.
   *
   * @param element The value to add.
   */
  public void add(E element) {
    if (isEmpty()) {
      last = new Node(element);
      first = last;
      return;
    }
    // Add to end of existing list
    last.next = new Node(element, null, last);
    last = last.next;
  }

  /**
   * This add method adds an element at an index.
   *
   * @param element The element to add to the list.
   * @param index   The index at which to add.
   * @throws IndexOutOfBoundsException When the index is out of bounds.
   */
  public void add(int index, E element) {
    checkIndex(index);

    // index is at least 0
    if (index == 0) {
      // new element goes at beginning
      Node p = first; // old first
      first = new Node(element, p, null);
      if (p != null) {
        p.prev = first;
      }
      if (last == null) {
        last = first;
      }
      return;
    }

    // pred will point to the predecessor
    // of the new node.
    Node pred = first;
    for (int k = 1; k <= index - 1; k++) {
      pred = pred.next;
    }

    // splice in a node with the new element
    // we want to go from  pred-- succ to
    // pred--middle--succ
    Node succ = pred.next;
    Node middle = new Node(element, succ, pred);
    pred.next = middle;
    if (succ == null) {
      last = middle;
    } else {
      succ.prev = middle;
    }
  }

  /**
   * The toString method computes the string representation of the list.
   *
   * @return The string representation of the linked list.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node p = first;
    while (p != null) {
      sb.append(p.value).append("\n");
      p = p.next;
    }
    return sb.toString();
  }

  /**
   * The remove method removes the element at a given position.
   *
   * @param index The position of the element to remove.
   * @return The element removed.
   * @throws IndexOutOfBoundsException When index is out of bounds.
   */
  public E remove(int index) {
    checkIndex(index);

    // locate the node targeted for removal
    Node target = first;
    for (int k = 1; k <= index; k++) {
      target = target.next;
    }

    E element = target.value;
    Node pred = target.prev;
    Node succ = target.next;

    // route forward and back pointers around the node to be removed
    if (pred == null) {
      first = succ;
    } else {
      pred.next = succ;
    }

    if (succ == null) {
      last = pred;
    } else {
      succ.prev = pred;
    }

    return element;
  }

  /**
   * The remove method removes an element from the list.
   *
   * @param element The element to remove.
   * @return true if the element was removed, false otherwise.
   */
  public boolean remove(E element) {
    if (isEmpty()) {
      return false;
    }

    // locate the node targeted for removal
    Node target = first;
    while (target != null && !element.equals(target.value)) {
      target = target.next;
    }

    if (target == null) {
      return false;
    }

    Node pred = target.prev;
    Node succ = target.next;

    // route forward and back pointers around the node to be removed
    if (pred == null) {
      first = succ;
    } else {
      pred.next = succ;
    }

    if (succ == null) {
      last = pred;
    } else {
      succ.prev = pred;
    }

    return true;
  }

  /**
   * Iterates from backwards to remove all of the elements from this list.
   */
  public void clear() {
    for (int i = size() - 1; i >= 0; i--) {
      remove(i);
    }
    first = null;
    last = null;
  }

  /**
   * Iterate nodes to find an element.
   *
   * @param index index of the element to return.
   */
  public E get(int index) {
    checkIndex(index);

    Node p = first;
    for (int i = 0; i < index; i++) {
      p = p.next;
    }
    return p.value;
  }

  /**
   * Iterate nodes to change an element.
   *
   * @param index   index of the element to change.
   * @param element element to be stored at the specified position.
   */
  public E set(int index, E element) {
    checkIndex(index);

    Node p = first;
    for (int i = 0; i < index; i++) {
      p = p.next;
    }

    E oldValue = p.value;
    p.value = element;
    return oldValue;
  }

  private void checkIndex(int index) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Invalid index: " + index);
    }
  }
}
