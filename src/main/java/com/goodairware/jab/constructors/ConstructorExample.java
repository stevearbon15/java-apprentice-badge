package com.goodairware.jab.constructors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class ConstructorExample {
  private static final Logger LOG = LoggerFactory.getLogger(ConstructorExample.class);

  String type;
  long amount;
  double time;
  String name;

  public ConstructorExample(String type) {
    new ConstructorExample(type, 0, 0L, "NoName");
  }

  public ConstructorExample(String type, long amount) {
    new ConstructorExample(type, amount, 0L, "NoName");
  }

  public ConstructorExample(String type, long amount, double time) {
    new ConstructorExample(type, amount, time, "NoName");
  }

  public ConstructorExample(String type, long amount, double time, String name) {
    this.type = type;
    this.amount = amount;
    this.time = time;
    this.name = name;
  }

  public void outputStuff(Function<String, String> modifier) {
    LOG.info(modifier.apply(toString()));
  }

  public void outputStuff() {
    outputStuff(str->str);
  }

  @Override
  public String toString() {
    return "ConstructorExample{" +
           "type='" + type + '\'' +
           ", amount=" + amount +
           ", time=" + time +
           ", name='" + name + '\'' +
           '}';
  }
}