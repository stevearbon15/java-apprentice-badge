package com.goodairware.jab.oop.inheritance;

import java.io.File;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class UppercaseInheritanceWriter extends BaseInheritanceWriter {

  @Override
  public void writeModifiedMessage(String message, File file) {
    writeMessage(message.toUpperCase(), file);
  }
}