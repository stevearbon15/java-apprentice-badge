package com.goodairware.jab.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

/**
 * Sorts a file into ascending order
 */
public class NaturalSorter {
  private static final Logger LOG = LoggerFactory.getLogger(NaturalSorter.class);

  /**
   * Runs the sorter
   *
   * @param args command line input args
   */
  public static void main(String[] args) {
    NaturalSorter naturalSorter = new NaturalSorter();
    naturalSorter.run(args);
  }

  private void run(String[] args) {
    try {
      new Sorter(Comparator.naturalOrder()).sort(args[0], "output/" + args[1]);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      LOG.error("Please provide an input file path and an output file path.", e);
    }
  }
}
