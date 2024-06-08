package tronikol.projects.Library.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name="reader")
public class Reader {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min=3, max=40, message = "Имя должно быть от 3 до 40 знаков")
    @Pattern(regexp="[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+", message = "Имя должно быть в формате: Фамилия Имя Отчество")
    @Column(name = "full_name")
    private String fullName;

    @Min(value = 1900, message = "Читатель родился позже 1900 года")
    @Column(name = "birth_year")
    private int birthYear;

    @OneToMany( mappedBy = "reader", fetch = FetchType.EAGER)
    private List<Book> books;

    public void giveBook(Book book) {
        books.add(book);
    }

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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    public Reader() {};
    public Reader(int id, String name, int yearOfBirth, List<Book> books) {
        this.id = id;
        this.fullName = name;
        this.birthYear = yearOfBirth;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
