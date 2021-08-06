/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.service.book;

import corp.siendev.com.keeper.bookservice.domain.Book;
import corp.siendev.com.keeper.bookservice.domain.Genre;

import java.util.Date;
import java.util.List;

public interface BookService {

    Book addBook(Book book);

    void deleteBook(String bookUuid);

    List<Book> findAllBooks();

    List<Book> findBooksByGenre(Genre genre);

    Book findBookByTitle(String bookTitle);

    List<Book> findBooksByPublishDate(Date publishDate);

    void updateBook(Book book);
}
