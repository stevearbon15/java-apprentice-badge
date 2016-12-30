package com.goodairware.jab.oop.composition;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class LowercaseMessageModifier implements MessageModifier {
  @Override
  public String modify(String message) {
    return message.toLowerCase();
  }
}
