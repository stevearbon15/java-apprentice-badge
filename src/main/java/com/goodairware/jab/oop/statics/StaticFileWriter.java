package com.goodairware.jab.oop.statics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class StaticFileWriter {
  private static final Logger LOG = LoggerFactory.getLogger(StaticFileWriter.class);

  private StaticFileWriter() {
  }

  /**
   * Writes a message to a file
   *
   * @param message The message to write
   * @param file    The file to write it to
   */
  public static void writeMessage(String message, File file) {
    try (FileWriter writer = new FileWriter(file)) {
      writer.write(message);
      writer.flush();
    }
    catch (IOException e) {
      LOG.error("Unable to write message=" + message, e);
    }
  }
}
