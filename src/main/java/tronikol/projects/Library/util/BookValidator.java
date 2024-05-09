package tronikol.projects.Library.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tronikol.projects.Library.dao.BookDAO;
import tronikol.projects.Library.models.Book;
@Component
public class BookValidator implements Validator {

    private final BookDAO bookDao;
    @Autowired
    public BookValidator(BookDAO bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        // Strange equals correct this
        if(bookDao.get(book.getTitle())!=null && bookDao.get(book.getTitle()).getId()!=((Book) target).getId()) {
            errors.rejectValue("title", "", "Такая книга уже зарегистрирована");
        }

    }
}
