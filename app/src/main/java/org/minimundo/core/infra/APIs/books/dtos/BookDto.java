package org.minimundo.core.infra.APIs.books.dtos;

import java.util.ArrayList;

public record BookDto(
  String id,
  String title,
  ArrayList<String> authors,
  String publisher,
  String description,
  String publishedYear,
  ArrayList<String> categories,
  int pageCount,
  String smallThumbnail,
  String thumbnail
) {}
