package tronikol.projects.Library.dto;

public class BookReaderDTO {
    // Book data:
    private String title;
    private String author;
    private int year;
    private int personId;
    // Person data
    private String fullName;
    private int burthYear;

    public BookReaderDTO(String title, String author, int personId, int year, String fullName, int burthYear) {
        this.title = title;
        this.author = author;
        this.personId = personId;
        this.year = year;
        this.fullName = fullName;
        this.burthYear = burthYear;
    }

    public BookReaderDTO() {}

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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
}
