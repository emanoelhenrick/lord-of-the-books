package org.minimundo.core.data.protocols;

import org.minimundo.core.infra.APIs.books.dtos.BookDto;

import java.io.IOException;

public interface SearchBooksByIdRepository {
  BookDto searchById(String id) throws IOException, InterruptedException;
}
