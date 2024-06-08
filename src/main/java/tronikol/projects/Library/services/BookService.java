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
@Transactional
public class BookService {
    private final BookRepo bookRepo;
    private final ReaderRepo readerRepo;

    @Autowired
    public BookService(BookRepo bookRepo, ReaderRepo readerRepo) {
        this.bookRepo = bookRepo;
        this.readerRepo = readerRepo;
    }
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Transactional
    public void add(Book book) {
        bookRepo.save(book);
    }

    public Book findById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    // Проверь тут ли этот метод должен быть
    public Reader findBookOwnerByBookId(int id) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book != null) {
            return book.getReader();
        } else {
            return null;
        }
    }
    @Transactional
    public void update(int id, Book book) {
        book.setId(id);
        bookRepo.save(book);
    }
    @Transactional
    public void giveBook(int id, Reader reader) {
        Book book = bookRepo.findById(id).orElse(null);
        book.setReader(reader);
        bookRepo.save(book);

    }

    public void free(int id) {
        Book book = bookRepo.findById(id).orElse(null);
        book.setReader(null);
    }

    public void delete(int id) {
        bookRepo.deleteById(id);
    }
}
