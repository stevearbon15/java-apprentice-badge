package com.goodairware.jab.oop.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class InheritanceWriter {
  private static final Logger LOG = LoggerFactory.getLogger(InheritanceWriter.class);

  /**
   * A method to modify the message before writing it.
   *
   * @param message The message to modify.
   * @param file    The file to write it to.
   */
  public void writeModifiedMessage(String message, File file) {
    writeMessage(message, file);
  }

  /**
   * Writes a message to a file
   *
   * @param message The message to write
   * @param file    The file to write it to
   */
  protected void writeMessage(String message, File file) {
    try (FileWriter writer = new FileWriter(file)) {
      writer.write(message);
      writer.flush();
    }
    catch (IOException e) {
      LOG.error("Unable to write message=" + message, e);
    }
  }
}