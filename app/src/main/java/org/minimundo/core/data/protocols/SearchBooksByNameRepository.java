package org.minimundo.core.data.protocols;


import org.minimundo.core.infra.APIs.books.dtos.BookDto;

import java.io.IOException;
import java.util.List;

public interface SearchBooksByNameRepository {
  List<BookDto> searchByName(String args, int startIndex, int maxResults) throws IOException, InterruptedException;
}
