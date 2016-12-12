package com.goodairware.jab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Sorted {
  private static final Logger LOG = LoggerFactory.getLogger(Sorted.class);

  public static void main(String[] args) {
    Sorted sorted = new Sorted();
    sorted.run(args);
  }

  private void run(String[] args) {
    if (args.length > 0) {
      File file = new File(args[0]);
      if (file.exists()) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
          String line;
          while ((line = br.readLine()) != null) {
            LOG.info(line);
          }
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
      else {
        LOG.warn("File " + file.getAbsolutePath() + " does not exist.");
      }
    }
    else {
      LOG.warn("Please provide a path to a file to be read in.");
    }
  }
}