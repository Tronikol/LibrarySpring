package tronikol.projects.Library.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tronikol.projects.Library.dto.BookReaderDTO;
import tronikol.projects.Library.models.Book;
import tronikol.projects.Library.models.Reader;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("Select * from book", new BookMapper());
    }

    public void add(Book book) {
        jdbcTemplate.update("Insert into book(title, author, year) values (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public Book get(int id) {
        return jdbcTemplate.query("Select * from book where id = ?", new BookMapper(),
                id).stream().findAny().orElse(null);
    }
    public BookReaderDTO getWithReader(int id) {
        return jdbcTemplate.query("Select * from book left join reader on book.person_id = reader.id where book.id = ?",
                new BookReaderDtoRowMapper(), id).stream().findAny().orElse(null);
    }
    public List<Book> getByPersonId(int id){
        return jdbcTemplate.query("Select * from book where person_id = ?",
                new BookMapper(), id);
    }

    public Book get(String title) {
        return jdbcTemplate.query("Select * from book where title = ?",
                new BookMapper(), title).stream().findAny().orElse(null);
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE book set title=?, author=?, year=?, person_id=? where id = ?",
                book.getTitle(), book.getAuthor(), book.getYear(), book.getPersonId(), id);
    }

    public void give(int id, Reader reader) {
        jdbcTemplate.update("UPDATE book set person_id=? where id = ?",
        reader.getId(), id);
    }

    public void free(int id) {
        jdbcTemplate.update("UPDATE  book set person_id=null where id = ?", id);
    }
}
