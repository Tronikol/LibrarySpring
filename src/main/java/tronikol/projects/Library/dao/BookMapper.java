package tronikol.projects.Library.dao;


import org.springframework.jdbc.core.RowMapper;
import tronikol.projects.Library.models.Book;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setAuthor(rs.getString("author"));
        book.setTitle(rs.getString("title"));
        book.setPersonId(rs.getInt("person_id"));
        book.setYear(rs.getInt("year"));
        return book;
    }
}
