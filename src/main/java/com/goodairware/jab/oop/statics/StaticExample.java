package com.goodairware.jab.oop.statics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class StaticExample {
  private static final Logger LOG = LoggerFactory.getLogger(StaticExample.class);

  /**
   * Runs the program
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    StaticExample staticExample = new StaticExample();
    staticExample.run(args);
  }

  private void run(String[] args) {
    runWriter("This is my message".toUpperCase(), args[0]);
    runWriter("This is my message".toLowerCase(), args[1]);
  }

  private void runWriter(String message, String filePath) {
    File file = new File("output/statics/" + filePath);
    if (!file.exists()) {
      LOG.info("Creating file " + file.getPath());
      file.getParentFile().mkdirs();
    }

    StaticFileWriter.writeMessage(message, file);
  }
}