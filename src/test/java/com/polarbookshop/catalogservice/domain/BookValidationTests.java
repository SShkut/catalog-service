package com.polarbookshop.catalogservice.domain;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookValidationTests {

  private static Validator validator;

  @BeforeAll
  static void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void whenAllFieldsCorrectThenValidationSucceeds() {
    var book = Book.of("1234567890", "Title", "Author", 9.99, "Publisher");
    var violations = validator.validate(book);
    assertThat(violations).isEmpty();
  }

  @Test
  void whenIsbnDefinedButIncorrectThenValidationFails() {
    var book = Book.of("1F34567890", "Title", "Author", 9.99, "Publisher");
    var violations = validator.validate(book);
    assertThat(violations).hasSize(1);
    assertThat(violations.iterator().next().getMessage())
        .isEqualTo("The ISBN format must be valid.");
  }
}
