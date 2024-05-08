package tronikol.projects.Library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tronikol.projects.Library.dao.ReaderDAO;
import tronikol.projects.Library.models.Reader;
@Component
public class ReaderValidator implements Validator {
    private final ReaderDAO readerDAO;
    @Autowired
    public ReaderValidator(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Reader.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Reader reader = (Reader) target;
        if(readerDAO.get(reader.getFullName())!=null) {
            errors.rejectValue("fullName", "", "Пользователь с таким именем уже существует");
        }
    }
}
