package org.minimundo.core.domain.services.books;

import org.minimundo.core.infra.APIs.books.dtos.BookDto;

import java.io.IOException;

public interface SearchBooksById {
  BookDto searchById(String bookId) throws IOException, InterruptedException;
}
