/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.controller;

import corp.siendev.com.keeper.bookservice.domain.Book;
import corp.siendev.com.keeper.bookservice.domain.Genre;
import corp.siendev.com.keeper.bookservice.service.book.BookServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/book")
@Api(tags = "book", description = "Books API")
public class BookController {

    private BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ApiOperation(value = "Get all books", notes = "Getting all books")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Got all books"),
            @ApiResponse(code = 400, message = "Couldn't find any book")
    })
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookService.findAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable("genre") Genre genre) {
        List<Book> booksByGenre = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(booksByGenre, HttpStatus.OK);
    }



    /*

    Book findBookByTitle(String bookTitle);

    List<Book> findBooksByPublishDate(Date publishDate);*/

    @PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        
        return ResponseEntity.ok(new Book());
    }

    @PostMapping
    public ResponseEntity<?> createBook(@Valid @RequestBody Book newBook) {
        newBook = bookRepository.save(newBook);

        // set location header for new book
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        URI newBookUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newBook.getBookId())
                .toUri();
        responseHttpHeaders.setLocation(newBookUri);

        return new ResponseEntity<>(null, responseHttpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable(value = "bookId") Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @PutMapping(value = "{bookId}")
    public ResponseEntity<?> updateBook(@RequestBody Book bookData, @PathVariable(value = "bookId") Long bookId) {
        Book book = bookRepository.save(bookData);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
