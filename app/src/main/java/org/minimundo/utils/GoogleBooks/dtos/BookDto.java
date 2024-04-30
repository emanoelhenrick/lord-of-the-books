package org.minimundo.utils.GoogleBooks.dtos;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

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
    String desc1 = RegExUtils.replaceAll(item.volumeInfo.description, "</p><p>", " ");
    String desc2 = RegExUtils.removeAll(desc1, "<[^>]*>");
    String desc3 = StringUtils.normalizeSpace(desc2);

    this.id = item.id;
    this.title = item.volumeInfo.title;
    this.authors = item.volumeInfo.authors;
    this.publisher = item.volumeInfo.publisher;
    this.description = desc3;

    if (item.volumeInfo.imageLinks == null) {
      this.smallThumbnail = "none";
      this.thumbnail = "none";
    } else {
      this.smallThumbnail = item.volumeInfo.imageLinks.smallThumbnail;
      this.thumbnail = item.volumeInfo.imageLinks.thumbnail;
    }
  }

  public static BookDto assembler(ItemDto item) {
    return new BookDto(item);
  }
}
