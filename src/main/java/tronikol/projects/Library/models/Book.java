package tronikol.projects.Library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    @Size(min=3, message = "Название должно быть больше 3 знаков")
    private String title;
    @Column(name = "author")
    @NotEmpty(message="Поле автора не должно быть пустым")
    @Pattern(regexp="[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+", message = "Имя автора должно быть в формате: Фамилия Имя Отчество")
    private String author;
    @Column(name = "year")
    private int year;
    @Transient
    private Boolean isOverdue;
    @Column(name="date_of_issue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfIssue;


    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Reader reader;

    public Book(int id, String title, String author, int personId, int year, Reader reader) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.reader = reader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Book() {

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

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Boolean getOverdue() {
        return isOverdue;
    }

    public void setOverdue(Boolean overdue) {
        isOverdue = overdue;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
}
