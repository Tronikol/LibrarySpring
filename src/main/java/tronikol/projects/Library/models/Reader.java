package tronikol.projects.Library.models;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Reader {
    private int id;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min=3, max=40, message = "Имя должно быть от 3 до 40 знаков")
    @Pattern(regexp="[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+", message = "Имя должно быть в формате: Фамилия Имя Отчество")
    private String fullName;
    @Min(value = 1900, message = "Читатель родился позже 1900 года")
    private int birthYear;

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
    public Reader(int id, String name, int yearOfBirth) {
        this.id = id;
        this.fullName = name;
        this.birthYear = yearOfBirth;
    }

}
