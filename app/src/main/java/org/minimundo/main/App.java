package org.minimundo.main;

import org.minimundo.utils.GoogleBooks.dtos.BookDto;
import org.minimundo.utils.GoogleBooks.GoogleBooks;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        List<BookDto> books = GoogleBooks.search("filhos de duna");
        for (BookDto book : books) {
            System.out.println(book.getTitle());
        }
    }
}
