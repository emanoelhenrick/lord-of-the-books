package org.minimundo.utils.GoogleBooks.dtos;

import java.util.ArrayList;

public record BookDto(
  String id,
  String title,
  ArrayList<String> authors,
  String publisher,
  String description,
  ArrayList<String> categories,
  int pageCount,
  String smallThumbnail,
  String thumbnail
) {}
