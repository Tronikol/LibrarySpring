package tronikol.projects.Library.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import tronikol.projects.Library.models.Reader;

import java.util.List;

@Component
public class ReaderDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReaderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Reader> index() {
        return jdbcTemplate.query("Select * from reader", new BeanPropertyRowMapper<>(Reader.class));
    }


    public void safe(Reader reader) {
        jdbcTemplate.update("INSERT INTO reader(fullname, burthyear) values (?, ?)",
                reader.getFullName(), reader.getBurthYear());
    }

    public Reader get(int id) {
        return jdbcTemplate.query("Select * from reader where id = ?",
                new BeanPropertyRowMapper<>(Reader.class), id).stream().findAny().orElse(null);
    }
    public Reader get(String fullName){
        return jdbcTemplate.query("Select * from reader where fullname = ?",
                new BeanPropertyRowMapper<>(Reader.class), fullName).stream().findAny().orElse(null);

    }

    public void update(int id, Reader reader) {
        jdbcTemplate.update("UPDATE reader set fullname = ?, burthyear = ? where id = ?",
                reader.getFullName(), reader.getBurthYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM reader where id = ?", id);
    }
}
