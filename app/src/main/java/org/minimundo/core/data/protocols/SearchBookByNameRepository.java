package org.minimundo.core.data.protocols;

import org.minimundo.utils.GoogleBooks.dtos.BookDto;

import java.io.IOException;
import java.util.List;

public interface SearchBookByNameRepository {
  List<BookDto> searchByName(String args, int startIndex, int maxResults) throws IOException, InterruptedException;
}
