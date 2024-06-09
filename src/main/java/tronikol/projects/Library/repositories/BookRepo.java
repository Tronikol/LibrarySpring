package tronikol.projects.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tronikol.projects.Library.models.Book;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    public Book findByTitle(String title);

    public List<Book> findByTitleContains(String searchRequest);
}
