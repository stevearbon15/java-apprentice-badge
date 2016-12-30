package com.goodairware.jab.oop.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class InhertianceExample {
  private static final Logger LOG = LoggerFactory.getLogger(InhertianceExample.class);

  /**
   * Runs the program.
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    InhertianceExample inhertianceExample = new InhertianceExample();
    inhertianceExample.run(args);
  }

  private void run(String[] args) {
    runWriter(args[0], new UppercaseInheritanceWriter());
    runWriter(args[1], new LowercaseInheritanceWriter());
  }

  private void runWriter(String arg, InheritanceWriter writer) {
    File file = new File("output/inheritance/" + arg);
    if (!file.exists()) {
      LOG.info("Creating file " + file.getPath());
      file.getParentFile().mkdirs();
    }

    writer.writeModifiedMessage("This is my message", file);
  }
}