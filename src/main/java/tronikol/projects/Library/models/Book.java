package tronikol.projects.Library.models;

public class Book {
    private int id;
    private String title;
    private String author;
    private int personId;
    private int year;

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
