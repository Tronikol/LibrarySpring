package tronikol.projects.Library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tronikol.projects.Library.models.Reader;
@Repository
public interface ReaderRepo extends JpaRepository<Reader, Integer> {
    Reader findByFullName(String fullName);
}
