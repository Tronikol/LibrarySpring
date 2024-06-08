package tronikol.projects.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tronikol.projects.Library.models.Book;
@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    public Book findByTitle(String title);
}
