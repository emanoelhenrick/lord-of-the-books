package org.minimundo.main;

import org.minimundo.core.data.protocols.SearchBooksByNameRepository;
import org.minimundo.core.data.services.books.ApiSearchBooksByName;
import org.minimundo.core.domain.services.books.SearchBooksByName;
import org.minimundo.core.infra.APIs.books.GoogleBooksRepository;
import org.minimundo.core.infra.APIs.books.dtos.BookDto;
import org.minimundo.main.factories.services.books.SearchBooksByNameFactory;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        SearchBooksByName BooksApi = SearchBooksByNameFactory.make();
        List<BookDto> books = BooksApi.searchByName("hereges de duna", 0, 10);
        for (BookDto book : books) {
            System.out.println(book.categories());
        }
    }
}
