package org.minimundo.utils.GoogleBooks.dtos;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class BookDtoAssembler {

  public static BookDto toBookDto(ItemDto item){
    String description = fixDescription(item.volumeInfo().description());
    ImageLinksDto imageLinks = verifyThumbs(item.volumeInfo().imageLinks());
    String publishedYear = fixDateYear(item.volumeInfo().publishedDate());

    return new BookDto(
      item.id(),
      item.volumeInfo().title(),
      item.volumeInfo().authors(),
      item.volumeInfo().publisher(),
      description,
      publishedYear,
      item.volumeInfo().categories(),
      item.volumeInfo().pageCount(),
      imageLinks.smallThumbnail(),
      imageLinks.thumbnail()
    );
  }

  private static String fixDescription(String description){
    String fix1 = RegExUtils.replaceAll(description, "</p><p>", " ");
    String fix2 = RegExUtils.removeAll(fix1, "<[^>]*>");
    return StringUtils.normalizeSpace(fix2);
  }

  private static ImageLinksDto verifyThumbs(ImageLinksDto imageLinks) {
    if (imageLinks == null) return new ImageLinksDto("none", "none");
    return imageLinks;
  }

  private static String fixDateYear(String publishedDate) {
    if (StringUtils.isEmpty(publishedDate)) return "none";
    String[] split = publishedDate.split("-");

    return Arrays.stream(split)
      .map(string -> RegExUtils.removeAll(string, "\\D+"))
      .filter(string -> string.length() == 4)
      .toList().getFirst();
  }
}
