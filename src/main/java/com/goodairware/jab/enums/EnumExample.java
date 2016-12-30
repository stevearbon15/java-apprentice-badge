package com.goodairware.jab.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class EnumExample {
  private static final Logger LOG = LoggerFactory.getLogger(EnumExample.class);

  /**
   * This internal enum class can be used to set and report the status of
   * the application. We use something similar to report the health of a
   * lot of our applications.
   *
   * @param args
   */
  public static void main(String[] args) {
    EnumExample enumExample = new EnumExample();
    enumExample.run(args);
  }

  private void run(String[] args) {
    LOG.info("Current machine status: {}", getStatus(args));
  }

  private StatusType getStatus(String[] args) {
    StatusType retVal;
    switch (args[0]) {
      case "ON":
        retVal = StatusType.ON;
        break;
      case "OFF":
        retVal = StatusType.OFF;
        break;
      case "TESTING":
        retVal = StatusType.TESTING;
        break;
      case "FAILED":
      default:
        retVal = StatusType.FAILED;
        break;
    }
    return retVal;
  }

  /**
   * Used to set/report status of application.
   */
  public enum StatusType {
    ON,
    OFF,
    TESTING,
    FAILED
  }
}