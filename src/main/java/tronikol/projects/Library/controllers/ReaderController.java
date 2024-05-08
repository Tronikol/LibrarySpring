package tronikol.projects.Library.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tronikol.projects.Library.dao.BookDAO;
import tronikol.projects.Library.dao.ReaderDAO;
import tronikol.projects.Library.models.Reader;
import tronikol.projects.Library.util.ReaderValidator;

import java.time.Period;

@Controller
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderDAO readerDAO;
    private final BookDAO bookDAO;
    private final ReaderValidator readerValidator;

    @Autowired
    public ReaderController(ReaderDAO readerDAO, BookDAO bookDAO, ReaderValidator readerValidator) {
        this.readerDAO = readerDAO;
        this.bookDAO = bookDAO;
        this.readerValidator = readerValidator;
    }

    // показ всех читателей
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("readers", readerDAO.index());
        return "readers/index";
    }
    // Страница создания нового читателя
    @GetMapping("/new")
    public String newReader(@ModelAttribute("reader") Reader reader) {
        return "readers/new";
    }

    // Метод добавления нового пользователя
    // Тут указано что @ModelAttribute можно и опускать
    // https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/arguments.html
    @PostMapping()
    public String createReader(@ModelAttribute("reader") @Valid Reader reader,
                               BindingResult bindingResult) {
        readerValidator.validate(reader, bindingResult);
        if(bindingResult.hasErrors()) {
            return "readers/new";
        }
        readerDAO.safe(reader);
        return "redirect:/readers";
    }

    // Страница с информацией о читателе, реализация без dto, кажется так проще
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("reader", readerDAO.get(id));
        model.addAttribute("books", bookDAO.getByPersonId(id));
        return "readers/show";
    }


}
