package org.minimundo.core.domain.services.books;

import org.minimundo.core.infra.APIs.books.dtos.BookDto;

import java.io.IOException;
import java.util.List;

public interface SearchBooksByName {
  List<BookDto> searchByName(String args, int startIndex, int maxResults) throws IOException, InterruptedException;
}
