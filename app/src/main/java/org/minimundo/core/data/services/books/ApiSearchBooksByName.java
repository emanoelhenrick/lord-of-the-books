package org.minimundo.core.data.services.books;

import org.minimundo.core.data.protocols.SearchBooksByNameRepository;
import org.minimundo.core.domain.services.books.SearchBooksByName;
import org.minimundo.core.infra.APIs.books.dtos.BookDto;

import java.io.IOException;
import java.util.List;

public class ApiSearchBooksByName implements SearchBooksByName {
  SearchBooksByNameRepository repository;
  public ApiSearchBooksByName(SearchBooksByNameRepository repository) {
    this.repository = repository;
  }
  @Override
  public List<BookDto> searchByName(String args, int startIndex, int maxResults) throws IOException, InterruptedException {
    return repository.searchByName(args, startIndex, maxResults);
  }
}
