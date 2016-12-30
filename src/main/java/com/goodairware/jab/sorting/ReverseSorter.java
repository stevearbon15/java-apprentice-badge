package com.goodairware.jab.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

/**
 * Class created by sarbon15 on 12/12/16.
 */
public class ReverseSorter {
  private static final Logger LOG = LoggerFactory.getLogger(ReverseSorter.class);

  /**
   * Runs the sorter
   *
   * @param args command line input args
   */
  public static void main(String[] args) {
    ReverseSorter reverseSorter = new ReverseSorter();
    reverseSorter.run(args);
  }

  private void run(String[] args) {
    try {
      new Sorter(Comparator.reverseOrder()).sort(args[0], "output/" + args[1]);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      LOG.error("Please provide an input file path and an output file path.", e);
    }
  }
}
