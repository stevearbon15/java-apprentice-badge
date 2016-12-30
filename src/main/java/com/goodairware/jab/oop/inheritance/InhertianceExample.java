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
    String message = "This is my message.";
    runWriter(message, args[0], new InheritanceWriter());
    runWriter(message, args[1], new UppercaseInheritanceWriter());
    runWriter(message, args[2], new LowercaseInheritanceWriter());
  }

  private void runWriter(String message, String arg, InheritanceWriter writer) {
    File file = new File("output/inheritance/" + arg);
    if (!file.exists()) {
      LOG.trace("Creating file " + file.getPath());
      file.getParentFile().mkdirs();
    }
    if (writer instanceof LowercaseInheritanceWriter) {
      LOG.debug("Writing with a LowercaseInheritanceWriter type writer.");
      LowercaseInheritanceWriter tempWriter = (LowercaseInheritanceWriter)writer;
      tempWriter.writeModifiedMessage(message, file);
    }
    else if (writer instanceof UppercaseInheritanceWriter) {
      LOG.debug("Writing with a UppercaseInheritanceWriter type writer.");
      UppercaseInheritanceWriter tempWriter = (UppercaseInheritanceWriter)writer;
      tempWriter.writeModifiedMessage(message, file);
    }
    else {
      LOG.debug("Writing with an InheritanceWriter type writer using default method.");
      writer.writeModifiedMessage(message, file);
    }
  }
}