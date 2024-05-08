package tronikol.projects.Library.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;
    @Size(min=3, message = "Название должно быть больше 3 знаков")
    private String title;
    @NotEmpty(message="Поле автора не должно быть пустым")
    @Pattern(regexp="[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+", message = "Имя автора должно быть в формате: Фамилия Имя Отчество")
    private String author;
    private int year;
    private int personId;

    public Book(int id, String title, String author, int personId, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.personId = personId;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Book() {}


    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
