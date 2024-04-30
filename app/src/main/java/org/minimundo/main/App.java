package org.minimundo.main;

import org.minimundo.utils.GoogleBooks.BookDto;
import org.minimundo.utils.GoogleBooks.GoogleBooks;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        List<BookDto> books = GoogleBooks.search("dune", 0, 1);
        System.out.println(books.getFirst().getTitle());
    }
}
