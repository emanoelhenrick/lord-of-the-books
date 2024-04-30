package org.minimundo.utils.GoogleBooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.minimundo.utils.GoogleBooks.dtos.BookDto;
import org.minimundo.utils.GoogleBooks.dtos.ItemDto;
import org.minimundo.utils.GoogleBooks.dtos.ResponseDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class GoogleBooks {
  static ObjectMapper mapper = new ObjectMapper();

  public static List<BookDto> search(String args, int startIndex, int maxResults) throws IOException, InterruptedException {
    String url = "https://www.googleapis.com/books/v1/volumes?q=" + args + "&printType=books"
      + "&projection=lite"
      + "&maxResults=" + maxResults
      + "&startIndex=" + startIndex;
    String response = getRequest(url);
    ResponseDto responseDto = mapper.readValue(response, ResponseDto.class);

    return responseDto.items
      .stream()
      .map(BookDto::assembler)
      .toList();
  }

  public static void search(String args) throws IOException, InterruptedException {
    String url = "https://www.googleapis.com/books/v1/volumes?q=" + args
      + "&projection=lite"
      + "&printType=books";

    String response = getRequest(url);
    System.out.println(response);
  }

  public static void findById(String bookId) throws IOException, InterruptedException {
    String url = "https://www.googleapis.com/books/v1/volumes/" + bookId + "&projection=lite";
    String response = getRequest(url);
    System.out.println(response);
  }

  static private String getRequest(String url) throws IOException, InterruptedException {
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

}
