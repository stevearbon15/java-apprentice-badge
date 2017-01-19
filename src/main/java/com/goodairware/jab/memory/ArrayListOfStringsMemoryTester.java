package com.goodairware.jab.memory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created by sarbon15 on 1/19/17.
 */
public class ArrayListOfStringsMemoryTester {
  private static final Logger LOG = LoggerFactory.getLogger(ArrayListOfStringsMemoryTester.class);
  public boolean cont = true;

  public static void main(String[] args) {
    ArrayListOfStringsMemoryTester tester = new ArrayListOfStringsMemoryTester();
    tester.run(args);
  }

  private void run(String[] args) {
    List<String> charList = new ArrayList<>();
    try {
      while (cont) {
        charList.add("a");
      }
    }
    catch (Error e) {
      LOG.error("Encountered an error. charList.size=" + charList.size(), e);
    }
  }
}