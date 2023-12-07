////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Human Resources                                        //
// Date: 06/12/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// An employee database application with sliding navigation, created  //
// using MVC design pattern.                                          //
////////////////////////////////////////////////////////////////////////

package i18n;

/**
 * 50 U.S. states ignoring other territories. This enum cannot be placed in root package because it
 * is accessed by other classes in subpackage.
 */
public enum State {
  AK("Alaska"),
  AL("Alabama"),
  AR("Arkansas"),
  AZ("Arizona"),
  CA("California"),
  CO("Colorado"),
  CT("Connecticut"),
  DE("Delaware"),
  FL("Florida"),
  GA("Georgia"),
  HI("Hawaii"),
  IA("Iowa"),
  ID("Idaho"),
  IL("Illinois"),
  IN("Indiana"),
  KS("Kansas"),
  KY("Kentucky"),
  LA("Louisiana"),
  MA("Massachusetts"),
  MD("Maryland"),
  ME("Maine"),
  MI("Michigan"),
  MN("Minnesota"),
  MO("Missouri"),
  MS("Mississippi"),
  MT("Montana"),
  NC("North Carolina"),
  ND("North Dakota"),
  NE("Nebraska"),
  NH("New Hampshire"),
  NJ("New Jersey"),
  NM("New Mexico"),
  NV("Nevada"),
  NY("New York"),
  OH("Ohio"),
  OK("Oklahoma"),
  OR("Oregon"),
  PA("Pennsylvania"),
  RI("Rhode Island"),
  SC("South Carolina"),
  SD("South Dakota"),
  TN("Tennessee"),
  TX("Texas"),
  UT("Utah"),
  VA("Virginia"),
  VT("Vermont"),
  WA("Washington"),
  WI("Wisconsin"),
  WV("West Virginia"),
  WY("Wyoming");

  private final String name;

  State(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
