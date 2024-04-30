package org.minimundo.utils.GoogleBooks.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto{
  public ArrayList<ItemDto> items = new ArrayList<>();
  public int totalItems;
}
