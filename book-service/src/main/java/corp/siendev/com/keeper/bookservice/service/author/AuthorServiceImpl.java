/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.service.author;

import corp.siendev.com.keeper.bookservice.domain.Author;
import corp.siendev.com.keeper.bookservice.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthorServiceImpl.class);
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public Author addAuthor(Author author) {
        Author existsAuthor = findAuthor(author.getFirstName(), author.getLastName());
        if (Objects.isNull(existsAuthor)) {
            UUID uuid = UUID.fromString(author.getFirstName() + author.getLastName());
            author.setAuthorUuid(uuid.toString());
            Author newAuthor = authorRepository.save(author);
            LOGGER.info("A new author was added: {} {}", newAuthor.getFirstName(), newAuthor.getLastName());
            return newAuthor;
        } else {
            LOGGER.warn("Author already exists: {} {}", author.getFirstName(), author.getLastName());
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteAuthor(String authorUuid) {
        Optional<Author> author = authorRepository.findById(authorUuid);
        if (author.isPresent()) {
            authorRepository.deleteById(authorUuid);
            LOGGER.info("Author : {} {} is deleted.", author.get().getFirstName(), author.get().getLastName());
        } else {
            LOGGER.warn("Couldn't find an author for deleting.");
        }
    }

    @Override
    public List<Author> findAllAuthors() {
        List<Author> allAuthors = authorRepository.findAll();
        LOGGER.info("Got {} authors.", allAuthors.size());
        return allAuthors;
    }

    @Override
    public Author findAuthor(String firstName, String lastName) {
        Optional<Author> existsAuthor = authorRepository.findAuthorByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
        if (existsAuthor.isPresent()) {
            LOGGER.info("Got author: {} {}", firstName, lastName);
            return existsAuthor.get();
        } else {
            LOGGER.warn("Couldn't find an author: {} {}", firstName, lastName);
            return null;
        }
    }

    @Override
    public List<Author> findAuthorsByFirstName(String firstName) {
        Optional<List<Author>> authors = authorRepository.findAuthorsByFirstNameIgnoreCase(firstName);
        if (authors.isPresent()) {
            LOGGER.info("Got authors (by first name): {}", authors.get().size());
            return authors.get();
        } else {
            LOGGER.warn("Couldn't find authors");
            return null;
        }
    }

    @Override
    public List<Author> findAuthorsByLastName(String lastName) {
        Optional<List<Author>> authors = authorRepository.findAuthorsByLastNameIgnoreCase(lastName);
        if (authors.isPresent()) {
            LOGGER.info("Got authors (by last name):", authors.get().size());
            return authors.get();
        } else {
            LOGGER.warn("Couldn't find authors");
            return null;
        }
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        Optional<Author> existsAuthor = authorRepository.findById(author.getAuthorUuid());
        if (existsAuthor.isPresent()) {
            existsAuthor.get().setBio(author.getBio());
            existsAuthor.get().setFirstName(author.getFirstName());
            existsAuthor.get().setLastName(author.getLastName());
            existsAuthor.get().setBooks(author.getBooks());
            authorRepository.save(existsAuthor.get());
            LOGGER.info("Author : {} {} is updated.", existsAuthor.get().getFirstName(), existsAuthor.get().getLastName());
        } else {
            LOGGER.warn("Couldn't find an author for updating.");
        }
    }
}
