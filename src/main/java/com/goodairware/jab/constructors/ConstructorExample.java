package com.goodairware.jab.constructors;

/**
 * Class created by sarbon15 on 12/30/16.
 */
public class ConstructorExample {
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
}