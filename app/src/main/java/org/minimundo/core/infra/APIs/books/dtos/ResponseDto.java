package org.minimundo.core.infra.APIs.books.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseDto(ArrayList<ItemDto> items){
}
