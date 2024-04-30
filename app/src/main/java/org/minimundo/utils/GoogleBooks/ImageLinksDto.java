package org.minimundo.utils.GoogleBooks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageLinksDto {
  public String smallThumbnail;
  public String thumbnail;
}
