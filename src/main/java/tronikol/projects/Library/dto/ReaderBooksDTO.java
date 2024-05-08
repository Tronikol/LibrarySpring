package tronikol.projects.Library.dto;

import tronikol.projects.Library.models.Book;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReaderBooksDTO {
    // Person data
    private int id;
    private String fullName;
    private int burthYear;
    List<Book> bookList = new LinkedList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBurthYear() {
        return burthYear;
    }

    public void setBurthYear(int burthYear) {
        this.burthYear = burthYear;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public ReaderBooksDTO() {}

    public ReaderBooksDTO(int id, String fullName, int burthYear, List<Book> bookList) {
        this.id = id;
        this.fullName = fullName;
        this.burthYear = burthYear;
        this.bookList = bookList;
    }
}
