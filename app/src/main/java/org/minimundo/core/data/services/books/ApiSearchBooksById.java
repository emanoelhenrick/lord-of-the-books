package org.minimundo.core.data.services.books;

import org.minimundo.core.data.protocols.SearchBooksByIdRepository;
import org.minimundo.core.domain.services.books.SearchBooksById;
import org.minimundo.core.infra.APIs.books.dtos.BookDto;

import java.io.IOException;

public class ApiSearchBooksById implements SearchBooksById {
  SearchBooksByIdRepository repository;

  ApiSearchBooksById(SearchBooksByIdRepository repository){
    this.repository = repository;
  }

  @Override
  public BookDto searchById(String bookId) throws IOException, InterruptedException {
    return repository.searchById(bookId);
  }
}
