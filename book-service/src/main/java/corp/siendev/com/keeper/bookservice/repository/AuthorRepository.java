/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.repository;

import corp.siendev.com.keeper.bookservice.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

    Optional<List<Author>> findAuthorsByFirstNameIgnoreCase(String firstName);
    Optional<List<Author>> findAuthorsByLastNameIgnoreCase(String lastName);
    Optional<Author> findAuthorByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
}
