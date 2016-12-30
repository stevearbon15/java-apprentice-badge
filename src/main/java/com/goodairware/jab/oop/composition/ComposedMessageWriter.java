package com.goodairware.jab.oop.composition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class ComposedMessageWriter {
  private static final Logger LOG = LoggerFactory.getLogger(ComposedMessageWriter.class);
  private final MessageModifier messageModifier;

  /**
   * Constructs a new message writer
   *
   * @param messageModifier The modifier to make modifications to the message if any
   */
  public ComposedMessageWriter(MessageModifier messageModifier) {
    this.messageModifier = messageModifier;
  }

  /**
   * Writes a message to a file
   *
   * @param message The message to write
   * @param file    The file to write it to
   */
  public void writeMessage(String message, File file) {
    try (FileWriter writer = new FileWriter(file)) {
      writer.write(messageModifier.modify(message));
      writer.flush();
    }
    catch (IOException e) {
      LOG.error("Unable to write message=" + message, e);
    }
  }
}