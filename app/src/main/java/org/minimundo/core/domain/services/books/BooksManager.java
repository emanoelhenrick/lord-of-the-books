package org.minimundo.core.domain.services.books;

import org.minimundo.core.domain.models.Book;

import java.util.List;

public interface BooksManager {

  List<Book> searchByName(String name);

  List<Book> searchByAuthor(String author);

  List<Book> searchByGenre(String genre);

}
