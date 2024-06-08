package tronikol.projects.Library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tronikol.projects.Library.models.Book;
import tronikol.projects.Library.models.Reader;
import tronikol.projects.Library.repositories.BookRepo;
import tronikol.projects.Library.repositories.ReaderRepo;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ReaderService {
    private final ReaderRepo readerRepo;
    private final BookRepo bookRepo;


    @Autowired
    public ReaderService(ReaderRepo readerRepo, BookRepo bookRepo) {
        this.readerRepo = readerRepo;
        this.bookRepo = bookRepo;
    }

    public List<Reader> findAll() {
        return readerRepo.findAll();
    }
    @Transactional
    public void safe(Reader reader) {
        readerRepo.save(reader);
    }

    public Reader findById(int id) {
        return readerRepo.findById(id).orElse(null);
    }
    @Transactional
    public List<Book> findReaderBooks(int id) {
        Reader reader = readerRepo.findById(id).orElse(null);
        return reader.getBooks();
    }
    @Transactional
    public void update(int id, Reader reader) {
        reader.setId(id);
        readerRepo.save(reader);
    }
    @Transactional
    public void delete(int id) {
        readerRepo.deleteById(id);

    }

    public Reader findByFullName(String fullName) {
        return readerRepo.findByFullName(fullName);
    }
}
