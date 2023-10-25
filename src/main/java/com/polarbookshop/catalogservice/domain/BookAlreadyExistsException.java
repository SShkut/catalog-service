package com.polarbookshop.catalogservice.domain;

public class BookAlreadyExistsException extends RuntimeException {

  public BookAlreadyExistsException(String isbn) {
    super(String.format("The book with ISBN %s was not found.", isbn));
  }
}
