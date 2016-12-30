package com.goodairware.jab.oop.inheritance;

import java.io.File;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class LowercaseInheritanceWriter extends InheritanceWriter {

  // Java virtual method invocation allows us to specify the behavior
  // of this method call when the InheritanceWriter is a
  // LowercaseInheritanceWriter, and this method will be called as
  // opposed to the default method on InheritanceWriter.
  @Override
  public void writeModifiedMessage(String message, File file) {
    writeMessage(message.toLowerCase(), file);
  }
}