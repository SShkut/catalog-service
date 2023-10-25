package com.polarbookshop.catalogservice.domain;

public class BookNotFoundException extends RuntimeException {

  public BookNotFoundException(String isbn) {
    super(String.format("A book with ISBN %s already exists.", isbn));
  }
}
