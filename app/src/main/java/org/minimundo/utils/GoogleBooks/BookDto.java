package org.minimundo.utils.GoogleBooks;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BookDto {
  String id;
  String title;
  ArrayList<String> authors;
  String publisher;
  String description;
  String smallThumbnail;
  String thumbnail;

  public BookDto(ItemDto item) {
    this.id = item.id;
    this.title = item.volumeInfo.title;
    this.authors = item.volumeInfo.authors;
    this.publisher = item.volumeInfo.publisher;
    this.description = item.volumeInfo.description;
    this.smallThumbnail = item.volumeInfo.imageLinks.smallThumbnail;
    this.thumbnail = item.volumeInfo.imageLinks.thumbnail;
  }
}
