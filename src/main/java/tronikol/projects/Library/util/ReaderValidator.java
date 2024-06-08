package tronikol.projects.Library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tronikol.projects.Library.models.Reader;
import tronikol.projects.Library.services.ReaderService;

@Component
public class ReaderValidator implements Validator {
    private final ReaderService readerService;
    @Autowired
    public ReaderValidator(ReaderService readerService) {
        this.readerService = readerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Reader.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Reader reader = (Reader) target;
        // maybe i can correct this?
        if(readerService.findByFullName(reader.getFullName())!=null && readerService.findByFullName(reader.getFullName()).getId()!=((Reader) target).getId()) {
            errors.rejectValue("fullName", "", "Пользователь с таким именем уже существует");
        }
    }
}
