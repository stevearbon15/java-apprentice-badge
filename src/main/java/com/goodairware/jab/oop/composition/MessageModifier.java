package com.goodairware.jab.oop.composition;

/**
 * Interface created by sarbon15 on 12/30/16.
 */
@FunctionalInterface
public interface MessageModifier {
  /**
   * Modifies a given a message and returns it.
   *
   * @param message
   * @return
   */
  String modify(String message);
}
