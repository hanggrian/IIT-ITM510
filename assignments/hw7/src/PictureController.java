////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: ImageViewer (Generic Linked List)                      //
// Date: 06/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Sliding navigation with a side panel list showing current picture  //
// collection.                                                        //
////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.util.Collection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * A controller responsible for CRUD operations of picture collection. The index property is
 * replaced by JavaFX API to automatically trigger bindings when items are manipulated.
 */
public class PictureController {
  public final DLinkedList<File> fileList;
  public final IntegerProperty currentFileIndex = new SimpleIntegerProperty();

  /**
   * New instance with empty collection.
   */
  public PictureController() {
    this(new DLinkedList<>());
  }

  /**
   * New instance with custom collection.
   *
   * @param fileList starting items.
   */
  public PictureController(DLinkedList<File> fileList) {
    this.fileList = fileList;
    currentFileIndex.set(fileList.size() - 1);
  }

  /**
   * Adds a new picture to the collection.
   *
   * @param files items to add.
   */
  public void createPictures(Collection<File> files) {
    for (File file : files) {
      fileList.add(file);
    }
    currentFileIndex.set(fileList.size() - 1);
  }

  /**
   * Updates an existing picture in the collection.
   *
   * @param index must be in range of collection.
   * @param file item to change.
   */
  public void updatePicture(int index, File file) {
    fileList.set(index, file);
  }

  /**
   * Deletes an existing picture in the collection
   *
   * @param index must be in range of collection.
   */
  public void deletePicture(int index) {
    fileList.remove(index);

    if (currentFileIndex.get() > index) {
      currentFileIndex.set(currentFileIndex.get() - 1);
    } else if (currentFileIndex.get() == index) {
      if (currentFileIndex.get() >= fileList.size()) {
        currentFileIndex.set(fileList.size() - 1);
      }
    }
  }

  /**
   * Removes all elements in this collection.
   */
  public void clearPictures() {
    fileList.clear();
    currentFileIndex.set(-1);
  }

  /**
   * Returns a picture based on current counter.
   */
  public File getCurrentPicture() {
    if (fileList.isEmpty()) {
      return null;
    }
    return fileList.get(currentFileIndex.get());
  }

  /**
   * Increments the counter, or do nothing when out of bounds.
   */
  public void navigateNext() {
    if (currentFileIndex.get() < fileList.size() - 1) {
      currentFileIndex.set(currentFileIndex.get() + 1);
    }
  }

  /**
   * Decrements the counter, or do nothing when out of bounds.
   */
  public void navigatePrevious() {
    if (currentFileIndex.get() > 0) {
      currentFileIndex.set(currentFileIndex.get() - 1);
    }
  }
}
