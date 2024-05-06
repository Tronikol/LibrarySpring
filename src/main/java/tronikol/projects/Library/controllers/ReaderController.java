package tronikol.projects.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tronikol.projects.Library.dao.ReaderDAO;

@Controller
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderDAO readerDAO;
    @Autowired
    public ReaderController(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }

    // показ всех читателя
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("readers", readerDAO.index());
        return "readers/index";
    }
    // Страница создания нового читателя
    @GetMapping("/new")
    public String newReader() {
        return "readers/new";
    }

    // Метод добавления нового пользователя
    @PostMapping("/new")
    public String addReader() {
        return null;
    }

}
