package org.minimundo.utils.GoogleBooks.dtos;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

public class BookDtoAssembler {

  public static BookDto toBookDto(ItemDto item){
    String description = fixDescription(item.volumeInfo().description());
    ImageLinksDto imageLinks = verifyThumbs(item.volumeInfo().imageLinks());

    return new BookDto(
      item.id(),
      item.volumeInfo().title(),
      item.volumeInfo().authors(),
      item.volumeInfo().publisher(),
      description,
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
}
