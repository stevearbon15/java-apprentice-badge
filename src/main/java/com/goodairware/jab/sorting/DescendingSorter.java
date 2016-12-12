package com.goodairware.jab.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

/**
 * Class created by sarbon15 on 12/12/16.
 */
public class DescendingSorter {
  private static final Logger LOG = LoggerFactory.getLogger(DescendingSorter.class);

  /**
   * Runs the sorter
   *
   * @param args command line input args
   */
  public static void main(String[] args) {
    DescendingSorter descendingSorter = new DescendingSorter();
    descendingSorter.run(args);
  }

  private void run(String[] args) {
    if (args.length > 1) {
      new Sorter(Comparator.reverseOrder()).sort(args[0], "output/" + args[1]);
    }
    else {
      LOG.warn("Please provide an input file path and an output file path.");
    }
  }
}
