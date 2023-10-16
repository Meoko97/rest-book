package org.agoncal.quarkus.starting.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Book {

  public int id;
  public String title;
  public String author;
  public int yearOfPublication;
  public String genre;

  // Constructor
}
