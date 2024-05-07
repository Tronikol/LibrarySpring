package tronikol.projects.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tronikol.projects.Library.dao.ReaderDAO;
import tronikol.projects.Library.models.Reader;

import java.time.Period;

@Controller
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderDAO readerDAO;
    @Autowired
    public ReaderController(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
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
    public String createReader(@ModelAttribute("reader") Reader reader) {
        readerDAO.safe(reader);
        return "redirect:/readers";
    }

    // Страница с информацией о читателе
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("reader", readerDAO.get(id));
        return "readers/show";
    }


}
