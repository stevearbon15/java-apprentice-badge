package com.goodairware.jab.exception;

import com.goodairware.jab.sorting.AscendingSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class ExceptionExample {
  private static final Logger LOG = LoggerFactory.getLogger(AscendingSorter.class);

  /**
   * Default constructor for ExceptionExample
   */
  public ExceptionExample() {
    // default constructor
  }

  /**
   * Runs the program
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    ExceptionExample exceptionExample = new ExceptionExample();
    exceptionExample.run();
  }

  private void run() {
    String[] fileArgs = new String[1];
    fileArgs[0] = "/a/fake/path/to/a/fake/file";
    runCheckedExceptionExample(fileArgs);

    String[] emptyArgs = new String[0];
    runUncheckedExceptionExample(emptyArgs);
  }

  /**
   * Checked exceptions are caught at compile time. If code can throw
   * a checked exception, it must be handled via try blocks, or added
   * to the method signature indicating it throws said exception.
   *
   * @param args command line arguments
   */
  private void runCheckedExceptionExample(String[] args) {
    try (FileReader fr = new FileReader(args[0]); BufferedReader br = new BufferedReader(fr)) {
      LOG.info(br.readLine());
    }
    catch (FileNotFoundException e) {
      LOG.error("File doesn't exist.", e);
    }
    catch (IOException e) {
      LOG.error("Unable to read file.", e);
    }
  }

  /**
   * Unchecked exceptions cannot be caught at compile time. The compiler
   * simply cannot know what certain values will be at compile time and,
   * therefore, cannot vouch for the safety of the operation. All exceptions
   * under Error and RuntimeException are unchecked exceptions.
   * <p>
   * As for Error exceptions, the following is stated in the Javadoc:
   * <p>
   * An Error is a subclass of Throwable that indicates serious problems
   * that a reasonable application should not try to catch. Most such errors
   * are abnormal conditions.
   *
   * @param args command line arguments
   */
  private void runUncheckedExceptionExample(String[] args) {
    try {
      LOG.info(args[0]);
    }
    catch (ArrayIndexOutOfBoundsException e) {
      LOG.error("This is a runtime exception. The compiler cannot know how many"
                + "strings will be in 'args' at compile time.", e);
    }
  }
}