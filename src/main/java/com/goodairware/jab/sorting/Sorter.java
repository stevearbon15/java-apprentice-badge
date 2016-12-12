package com.goodairware.jab.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sorts a file according to the provided comparator
 */
public class Sorter {
  private static final Logger LOG = LoggerFactory.getLogger(Sorter.class);
  private final Comparator<String> comparator;

  /**
   * Initializes a new sorter according to provided comparator
   *
   * @param comparator
   */
  public Sorter(Comparator<String> comparator) {
    this.comparator = comparator;
  }

  /**
   * Sorts the file located at the provided path and returns a list of sorted strings
   *
   * @param inputFilePath  A path to a file containing strings to be sorted
   * @param outputFilePath A path to the output file for the sorted strings
   */
  public void sort(String inputFilePath, String outputFilePath) {
    sort(new File(inputFilePath), new File(outputFilePath));
  }

  /**
   * /**
   * Sorts the provided file and returns a list of sorted strings
   *
   * @param inputFile  A file containing strings to be sorted
   * @param outputFile A file to output the sorted strings to
   */
  public void sort(File inputFile, File outputFile) {
    List<String> strings = new ArrayList<>();
    if (inputFile.exists()) {
      readStringsIntoList(inputFile, strings);
      Collections.sort(strings, this.comparator);
    }
    else {
      LOG.warn("File " + inputFile.getAbsolutePath() + " does not exist.");
    }
    writeToFile(strings, outputFile);
  }

  private void readStringsIntoList(File file, List<String> unsortedStrings) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
      String line;
      while ((line = br.readLine()) != null) {
        unsortedStrings.add(line);
      }
    }
    catch (IOException e) {
      LOG.error("Caught IOException.", e);
    }
  }

  private void writeToFile(List<String> sortedStrings, File outputFile) {
    outputFile.getParentFile().mkdirs();
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
      bw.write(sortedStrings.stream().collect(Collectors.joining("\n")));
    }
    catch (IOException e) {
      LOG.error("Caught IOException trying to write file: " + outputFile, e);
    }
  }
}