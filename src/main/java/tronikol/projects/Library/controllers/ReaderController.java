package tronikol.projects.Library.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tronikol.projects.Library.models.Reader;
import tronikol.projects.Library.services.ReaderService;
import tronikol.projects.Library.util.ReaderValidator;

@Controller
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderValidator readerValidator;
    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderValidator readerValidator, ReaderService readerService) {
        this.readerValidator = readerValidator;
        this.readerService = readerService;
    }

    // показ всех читателей
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("readers", readerService.findAll());
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
        readerService.safe(reader);
        return "redirect:/readers";
    }

    // Страница с информацией о читателе
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("reader", readerService.findById(id));
        model.addAttribute("books", readerService.findReaderBooks(id));
        return "readers/show";
    }
    // Страница редактирования
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("reader", readerService.findById(id));
        return "readers/edit";
    }
    //  Изменение читателя
    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("reader") @Valid Reader reader,
                         BindingResult bindingResult){
        readerValidator.validate(reader, bindingResult);
        if(bindingResult.hasErrors()) {
            return "readers/edit";
        }
        readerService.update(id, reader);
        return "redirect:/readers/" + id;
    }
    // Удаление читателя
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        readerService.delete(id);
        return "redirect:/readers";
    }


}
