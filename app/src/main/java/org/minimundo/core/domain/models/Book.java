package org.minimundo.core.domain.models;

import java.util.ArrayList;

public record Book(
  String id,
  String title,
  ArrayList<String> authors,
  String publisher,
  String description,
  String publishedYear,
  ArrayList<String> categories,
  int pageCount,
  double stars
) {
}
