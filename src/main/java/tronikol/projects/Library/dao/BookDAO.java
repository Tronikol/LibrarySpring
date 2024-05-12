package tronikol.projects.Library.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import tronikol.projects.Library.models.Book;
import tronikol.projects.Library.models.Reader;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("Select * from book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void add(Book book) {
        jdbcTemplate.update("Insert into book(title, author, year) values (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public Book get(int id) {
        return jdbcTemplate.query("Select * from book where id = ?", new BeanPropertyRowMapper<>(Book.class),
                id).stream().findAny().orElse(null);
    }
    public List<Book> getByPersonId(int id){
        return jdbcTemplate.query("Select * from book where person_id = ?",
                new BeanPropertyRowMapper<>(Book.class), id);
    }

    public Book get(String title) {
        return jdbcTemplate.query("Select * from book where title = ?",
                new BeanPropertyRowMapper<>(Book.class), title).stream().findAny().orElse(null);
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE book set title=?, author=?, year = ? where id = ?",
                book.getTitle(), book.getAuthor(), book.getYear(), id);
    }

    public void give(int id, Reader reader) {
        jdbcTemplate.update("UPDATE book set person_id=? where id = ?",
        reader.getId(), id);
    }

    public void free(int id) {
        jdbcTemplate.update("UPDATE  book set person_id=null where id = ?", id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

    public Reader getBookOwner(int id) {
        return jdbcTemplate.query("Select reader.* from reader left join public.book on reader.id = book.person_id where book.id=?",
                new BeanPropertyRowMapper<>(Reader.class), id).stream().findAny().orElse(null);

    }
}
