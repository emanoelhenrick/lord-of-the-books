package org.minimundo.utils.GoogleBooks.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfoDto {
  String title;
  ArrayList<String> authors;
  String publisher;
  String description;
  ArrayList<String> categories;
  int pageCount;
  ImageLinksDto imageLinks;
}
