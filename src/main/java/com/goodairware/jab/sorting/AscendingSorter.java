package com.goodairware.jab.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

/**
 * Sorts a file into ascending order
 */
public class AscendingSorter {
  private static final Logger LOG = LoggerFactory.getLogger(AscendingSorter.class);

  /**
   * Runs the sorter
   *
   * @param args command line input args
   */
  public static void main(String[] args) {
    AscendingSorter ascendingSorter = new AscendingSorter();
    ascendingSorter.run(args);
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
