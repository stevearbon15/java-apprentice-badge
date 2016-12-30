package com.goodairware.jab.encapsulation;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class EncapsulationExample {
  // All these fields should be private and only accessible through
  // the means that we provide. In this way, we can protect the data.
  private String name;
  private String ssn;
  private String dept;
  private int age;

  /**
   * Public constructor
   *
   * @param name
   * @param ssn
   * @param dept
   * @param age
   */
  public EncapsulationExample(String name, String ssn, String dept, int age) {
    this.name = name;
    this.ssn = ssn;
    this.dept = dept;
    this.age = age;
  }

  /* Accessors */

  // Here is an example of some good encapsulation. Names, departments, and ages
  // can change, but SSNs should never change. Therefore, it should only be set
  // on construction and then never modified. It is immutable.

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSsn() {
    return ssn;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
