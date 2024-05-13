package org.minimundo.main.factories.services.books;

import org.minimundo.core.data.protocols.SearchBooksByNameRepository;
import org.minimundo.core.data.services.books.ApiSearchBooksByName;
import org.minimundo.core.domain.services.books.SearchBooksByName;
import org.minimundo.core.infra.APIs.books.GoogleBooksRepository;

public class SearchBooksByNameFactory {
  public static SearchBooksByName make() {
    SearchBooksByNameRepository repository = new GoogleBooksRepository();
    return new ApiSearchBooksByName(repository);
  }
}
