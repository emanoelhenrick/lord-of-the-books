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
  ArrayList<String> categories;
  int pageCount;
  String smallThumbnail;
  String thumbnail;

  public BookDto(ItemDto item) {
    String desc1 = RegExUtils.replaceAll(item.volumeInfo.description, "</p><p>", " ");
    String desc2 = RegExUtils.removeAll(desc1, "<[^>]*>");
    String desc3 = StringUtils.normalizeSpace(desc2);

    this.id = item.getId();
    this.title = item.volumeInfo.getTitle();
    this.authors = item.volumeInfo.getAuthors();
    this.publisher = item.volumeInfo.getPublisher();
    this.categories = item.volumeInfo.getCategories();
    this.pageCount = item.volumeInfo.getPageCount();
    this.description = desc3;

    if (item.volumeInfo.imageLinks == null) {
      this.smallThumbnail = "none";
      this.thumbnail = "none";
    } else {
      this.smallThumbnail = item.volumeInfo.imageLinks.getSmallThumbnail();
      this.thumbnail = item.volumeInfo.imageLinks.getThumbnail();
    }
  }

  public static BookDto assembler(ItemDto item) {
    return new BookDto(item);
  }
}
