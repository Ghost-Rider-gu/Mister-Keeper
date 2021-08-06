package corp.siendev.com.keeper.bookservice.repository;

import corp.siendev.com.keeper.bookservice.domain.Book;
import corp.siendev.com.keeper.bookservice.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Optional<List<Book>> findBooksByGenreIgnoreCase(Genre genre);
    Optional<Book> findBookByTitleIgnoreCase(String bookTitle);
    Optional<List<Book>> findBooksByPublishDate(Date publishDate);
}
