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
}
