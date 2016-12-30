package com.goodairware.jab.passby;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class PassByExample {
  private static final Logger LOG = LoggerFactory.getLogger(PassByExample.class);

  public static void main(String[] args) {
    PassByExample passByExample = new PassByExample();
    passByExample.run(args);
  }

  private void run(String[] args) {
    int val = 10;
    PassByRef ref = new PassByRef("Name", 2);
    String fnl = "Another test";

    LOG.info("val: " + val);
    LOG.info("ref: " + ref);
    LOG.info("final: " + fnl);

    exampleMethod(val, ref, fnl);

    LOG.info("val: " + val);
    LOG.info("ref: " + ref);
    LOG.info("final: " + fnl);

    // Nothing has changed because java passes method arguments by value.
    // Even the object was passed by value -- value of the address of the object.
    // If we were to use accessors to modify the object, the values of that
    // object would change.

    exampleMethodTwo(val, ref, fnl);

    LOG.info("val: " + val);
    LOG.info("ref: " + ref);
    LOG.info("final: " + fnl);
  }

  /**
   * Primative types are passed by value.
   * Objects are passed by value. That is the reference is passed by value.
   * Final params are immutable.
   *
   * @param val
   * @param ref
   * @param fnl
   */
  private void exampleMethod(int val, PassByRef ref, final String fnl) {
    val--;
    ref = new PassByRef("Number", 5);
    // test = "changed"; cannot do this. The param is final
  }

  /**
   * Primative types are passed by value.
   * Objects are passed by value. That is the reference is passed by value.
   * However, we can use the value of the reference to modify it's data members.
   * Final params are immutable.
   *
   * @param val
   * @param ref
   * @param fnl
   */
  private void exampleMethodTwo(int val, PassByRef ref, final String fnl) {
    val--;
    ref.setSomething("Number");
    ref.setOtherVal(5);
    // test = "changed"; cannot do this. The param is final
  }

  public class PassByRef {
    String something;
    int otherVal;

    public PassByRef(String something, int otherVal) {
      this.something = something;
      this.otherVal = otherVal;
    }

    public String getSomething() {
      return something;
    }

    public void setSomething(String something) {
      this.something = something;
    }

    public int getOtherVal() {
      return otherVal;
    }

    public void setOtherVal(int otherVal) {
      this.otherVal = otherVal;
    }

    @Override
    public String toString() {
      return "PassByRef{something='" + something + '\'' + ", otherVal=" + otherVal + '}';
    }
  }
}