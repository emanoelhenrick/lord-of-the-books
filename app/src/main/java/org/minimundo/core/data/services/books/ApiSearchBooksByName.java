package org.minimundo.core.data.services.books;

import org.minimundo.core.data.protocols.SearchBookByNameRepository;
import org.minimundo.core.domain.services.books.SearchBooksByName;
import org.minimundo.utils.GoogleBooks.dtos.BookDto;

import java.io.IOException;
import java.util.List;

public class ApiSearchBooksByName implements SearchBooksByName {

  SearchBookByNameRepository repository;

  ApiSearchBooksByName(SearchBookByNameRepository repository) {
    this.repository = repository;
  }
  @Override
  public List<BookDto> searchByName(String args, int startIndex, int maxResults) throws IOException, InterruptedException {
    return repository.searchByName(args, startIndex, maxResults);
  }

  public List<BookDto> searchByName(String args) throws IOException, InterruptedException {
    return repository.searchByName(args, 0, 10);
  }
}
