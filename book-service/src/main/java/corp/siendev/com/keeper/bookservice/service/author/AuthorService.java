/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.service.author;

import corp.siendev.com.keeper.bookservice.domain.Author;

import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);

    void deleteAuthor(String authorUuid);

    List<Author> findAllAuthors();

    List<Author> findAuthorsByFirstName(String firstName);

    List<Author> findAuthorsByLastName(String lastName);

    Author findAuthor(String firstName, String lastName);

    void updateAuthor(Author author);
}
