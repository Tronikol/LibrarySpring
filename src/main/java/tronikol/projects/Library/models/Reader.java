package tronikol.projects.Library.models;


public class Reader {
    private int id;
    private String fullName;
    private int burthYear;

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
    public Reader() {};
    public Reader(int id, String name, int yearOfBirth) {
        this.id = id;
        this.fullName = name;
        this.burthYear = yearOfBirth;
    }

}
