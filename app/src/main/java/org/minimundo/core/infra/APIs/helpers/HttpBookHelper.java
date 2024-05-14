package org.minimundo.core.infra.APIs.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.minimundo.core.infra.APIs.books.dtos.BookDto;
import org.minimundo.core.infra.APIs.books.dtos.BookDtoAssembler;
import org.minimundo.core.infra.APIs.books.dtos.ResponseDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class HttpBookHelper {
  private static final ObjectMapper mapper = new ObjectMapper();
  public static String getRequest(String url) throws IOException, InterruptedException {
    HttpRequest req = HttpRequest.newBuilder()
      .GET()
      .uri(URI.create(url))
      .timeout(Duration.ofSeconds(3))
      .build();

    HttpClient client = HttpClient.newBuilder()
      .connectTimeout(Duration.ofSeconds(3))
      .build();

    HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
    return res.body();
  }

  public static List<BookDto> responseToBooks(String response) throws JsonProcessingException {
    ResponseDto responseDto = mapper.readValue(response, ResponseDto.class);
    return responseDto.items()
      .stream()
      .map(BookDtoAssembler::toBookDto)
      .toList();
  }
}
