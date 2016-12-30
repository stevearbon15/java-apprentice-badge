package com.goodairware.jab.oop.composition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class CompositionExample {
  private static final Logger LOG = LoggerFactory.getLogger(CompositionExample.class);

  /**
   * Runs the composition example.
   *
   * @param args
   */
  public static void main(String[] args) {
    CompositionExample compositionExample = new CompositionExample();
    compositionExample.run(args);
  }

  private void run(String[] args) {
    runComposition(args[0], new UppercaseMessageModifier());
    runComposition(args[1], new LowercaseMessageModifier());
  }

  private void runComposition(String arg, MessageModifier modifier) {
    ComposedMessageWriter writer = new ComposedMessageWriter(modifier);
    File file = new File("output/composition/" + arg);
    if (!file.exists()) {
      LOG.info("Creating file " + file.getPath());
      file.getParentFile().mkdirs();
    }

    writer.writeMessage("This is a modified message", file);
  }
}