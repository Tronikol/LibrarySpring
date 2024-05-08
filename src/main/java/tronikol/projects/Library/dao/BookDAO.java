package tronikol.projects.Library.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tronikol.projects.Library.dto.BookReaderDTO;
import tronikol.projects.Library.models.Book;

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
        jdbcTemplate.update("Insert into book(person_id, title, author, year) values (?, ?, ?, ?)",
                null, book.getTitle(), book.getAuthor(), book.getYear());
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
}
