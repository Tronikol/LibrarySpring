package tronikol.projects.Library.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tronikol.projects.Library.models.Book;
import tronikol.projects.Library.services.BookService;

@Component
public class BookValidator implements Validator {

    private final BookService bookService;
    @Autowired
    public BookValidator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        // Strange equals correct this
        if(bookService.findByTitle(book.getTitle())!=null && bookService.findByTitle(book.getTitle()).getId()!=((Book) target).getId()) {
            errors.rejectValue("title", "", "Такая книга уже зарегистрирована");
        }

    }
}
