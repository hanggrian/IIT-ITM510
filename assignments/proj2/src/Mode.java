////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

/**
 * Navigation mode that determines control disability and color.
 */
public enum Mode {
  /**
   * All buttons enabled except 'Save'. This is the default mode.
   */
  READ,

  /**
   * All buttons disabled except 'New' and 'Save'.
   */
  CREATE,

  /**
   * All buttons disabled except 'Edit' and 'Save'.
   */
  UPDATE,

  /**
   * All buttons disabled except 'Delete' and 'Save'.
   */
  DELETE
}
