package org.minimundo.utils.GoogleBooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RegExUtils;
import org.minimundo.utils.GoogleBooks.dtos.BookDto;
import org.minimundo.utils.GoogleBooks.dtos.BookDtoAssembler;
import org.minimundo.utils.GoogleBooks.dtos.ItemDto;
import org.minimundo.utils.GoogleBooks.dtos.ResponseDto;

import java.io.IOException;
import java.util.List;

public class GoogleBooks {
  static ObjectMapper mapper = new ObjectMapper();

  public static List<BookDto> search(String args, int startIndex, int maxResults) throws IOException, InterruptedException {
    String newArgs = RegExUtils.replaceAll(args, " ", "+");
    String url = "https://www.googleapis.com/books/v1/volumes?q=" + newArgs + "&printType=books"
      + "&maxResults=" + maxResults
      + "&startIndex=" + startIndex;
    String response = getRequest(url);
    return responseToBooks(response);
  }

  public static List<BookDto> search(String args) throws IOException, InterruptedException {
    return search(args, 0, 10);
  }

  public static BookDto findById(String bookId) throws IOException, InterruptedException {
    String url = "https://www.googleapis.com/books/v1/volumes/" + bookId;
    String response = getRequest(url);
    ItemDto itemDto = mapper.readValue(response, ItemDto.class);
    return BookDtoAssembler.toBookDto(itemDto);
  }

  private static String getRequest(String url) throws IOException, InterruptedException {
    return HttpHelper.getRequest(url);
  }

  private static List<BookDto> responseToBooks(String response) throws JsonProcessingException {
    ResponseDto responseDto = mapper.readValue(response, ResponseDto.class);
    return responseDto.items()
      .stream()
      .map(BookDtoAssembler::toBookDto)
      .toList();
  }

}
