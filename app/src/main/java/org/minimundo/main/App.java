package org.minimundo.main;

<<<<<<< HEAD
import org.minimundo.utils.GoogleBooks.dtos.BookDto;
import org.minimundo.utils.GoogleBooks.GoogleBooks;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        BookDto book = GoogleBooks.findById("h82uCgAAQBAJ");
        System.out.println(book.getSmallThumbnail());
        System.out.println(book.getThumbnail());

=======
public class App {

    public static void main(String[] args) {
        System.out.println("a book to rule them all");
>>>>>>> 1c75094 (chore: initial folders template)
    }
}
