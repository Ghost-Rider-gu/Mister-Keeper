/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.service.book;

import corp.siendev.com.keeper.bookservice.domain.Book;
import corp.siendev.com.keeper.bookservice.domain.Genre;
import corp.siendev.com.keeper.bookservice.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        Optional<Book> existsBook = bookRepository.findBookByTitleIgnoreCase(book.getTitle());
        if (existsBook.isPresent()) {
            UUID uuid = UUID.fromString(book.getTitle());
            book.setBookUuid(uuid.toString());
            Book newBook = bookRepository.save(book);
            LOGGER.info("A new book was added: {}", book.getTitle());
            return newBook;
        } else {
            LOGGER.warn("Book already exists: {}", book.getTitle());
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteBook(String bookUuid) {
        Optional<Book> book = bookRepository.findById(bookUuid);
        if (book.isPresent()) {
            bookRepository.deleteById(bookUuid);
            LOGGER.info("Book : {} is deleted.", book.get().getTitle());
        } else {
            LOGGER.warn("Couldn't find a book for deleting.");
        }
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        LOGGER.info("Got {} books.", allBooks.size());
        return allBooks;
    }

    @Override
    public List<Book> findBooksByGenre(Genre genre) {
        Optional<List<Book>> books = bookRepository.findBooksByGenreIgnoreCase(genre);
        if (books.isPresent()) {
            LOGGER.info("Got books (by genre): {}", books.get().size());
            return books.get();
        } else {
            LOGGER.warn("Couldn't find books");
            return null;
        }
    }

    @Override
    public Book findBookByTitle(String bookTitle) {
        Optional<Book> book = bookRepository.findBookByTitleIgnoreCase(bookTitle);
        if (book.isPresent()) {
            LOGGER.info("Got book (by title): {}", book.get().getTitle());
            return book.get();
        } else {
            LOGGER.warn("Couldn't find book");
            return null;
        }
    }

    @Override
    public List<Book> findBooksByPublishDate(Date publishDate) {
        Optional<List<Book>> books = bookRepository.findBooksByPublishDate(publishDate);
        if (books.isPresent()) {
            LOGGER.info("Got books (by publish date): {}", books.get().size());
            return books.get();
        } else {
            LOGGER.warn("Couldn't find books");
            return null;
        }
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        Optional<Book> existsBook = bookRepository.findById(book.getBookUuid());
        if (existsBook.isPresent()) {
            existsBook.get().setAuthor(book.getAuthor());
            existsBook.get().setDescription(book.getDescription());
            existsBook.get().setGenre(book.getGenre());
            existsBook.get().setPublishDate(book.getPublishDate());
            existsBook.get().setTitle(book.getTitle());
            bookRepository.save(existsBook.get());
            LOGGER.info("Book : {} is updated.", existsBook.get().getTitle());
        } else {
            LOGGER.warn("Couldn't find a book for updating.");
        }
    }
}
