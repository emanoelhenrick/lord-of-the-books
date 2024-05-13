package org.minimundo.core.infra.APIs.books;

import org.apache.commons.lang3.RegExUtils;
import org.minimundo.core.data.protocols.SearchBooksByNameRepository;
import org.minimundo.core.infra.APIs.books.dtos.BookDto;
import org.minimundo.core.infra.APIs.helpers.HttpBookHelper;

import java.io.IOException;
import java.util.List;

public class ApiBooksRepository implements
  SearchBooksByNameRepository {
  @Override
  public List<BookDto> searchByName(String args, int startIndex, int maxResults) throws IOException, InterruptedException {
    String newArgs = RegExUtils.replaceAll(args, " ", "+");
    String url = "https://www.googleapis.com/books/v1/volumes?q=" + newArgs + "&printType=books"
      + "&maxResults=" + maxResults
      + "&startIndex=" + startIndex;
    String response = HttpBookHelper.getRequest(url);
    return HttpBookHelper.responseToBooks(response);
  }

}
