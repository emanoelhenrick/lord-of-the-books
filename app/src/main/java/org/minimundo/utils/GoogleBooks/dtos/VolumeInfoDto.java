package org.minimundo.utils.GoogleBooks.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VolumeInfoDto(
  String title,
  ArrayList<String> authors,
  String publisher,
  String description,
  String publishedDate,
  ArrayList<String> categories,
  int pageCount,
  ImageLinksDto imageLinks
) {}
