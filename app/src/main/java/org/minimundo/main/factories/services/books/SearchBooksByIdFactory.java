package org.minimundo.main.factories.services.books;

import org.minimundo.core.data.protocols.SearchBooksByIdRepository;
import org.minimundo.core.data.services.books.ApiSearchBooksById;
import org.minimundo.core.domain.services.books.SearchBooksById;
import org.minimundo.core.infra.APIs.books.GoogleBooksRepository;

public class SearchBooksByIdFactory {
  public static SearchBooksById make() {
    SearchBooksByIdRepository repository = new GoogleBooksRepository();
    return new ApiSearchBooksById(repository);
  }
}
