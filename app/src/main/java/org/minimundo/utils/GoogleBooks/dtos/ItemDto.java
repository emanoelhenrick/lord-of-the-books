package org.minimundo.utils.GoogleBooks.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
  public String id;
  public VolumeInfoDto volumeInfo;
}
