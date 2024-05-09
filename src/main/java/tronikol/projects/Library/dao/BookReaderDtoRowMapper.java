package tronikol.projects.Library.dao;

import org.springframework.jdbc.core.RowMapper;
import tronikol.projects.Library.dto.BookReaderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
// Возомжно нужен этот класс, в другом случае лучше обойтись без него
public class BookReaderDtoRowMapper implements RowMapper<BookReaderDTO> {
    @Override
    public BookReaderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookReaderDTO bookReaderDTO = new BookReaderDTO();
        bookReaderDTO.setId(rs.getInt("id"));
        bookReaderDTO.setAuthor(rs.getString("author"));
        bookReaderDTO.setTitle(rs.getString("title"));
        bookReaderDTO.setYear(rs.getInt("year"));
        bookReaderDTO.setPersonId(rs.getInt("person_id"));
        bookReaderDTO.setFullName(rs.getString("fullname"));
        bookReaderDTO.setBurthYear(rs.getInt("burthyear"));
        return bookReaderDTO;
    }
}
