package org.minimundo.utils.GoogleBooks.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseDto(ArrayList<ItemDto> items){
}
