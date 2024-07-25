package org.minimundo.core.infra.APIs.books.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImageLinksDto(
  String smallThumbnail,
  String thumbnail
) {}
