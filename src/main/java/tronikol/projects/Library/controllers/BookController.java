package tronikol.projects.Library.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tronikol.projects.Library.dao.BookDAO;
import tronikol.projects.Library.dao.ReaderDAO;
import tronikol.projects.Library.models.Book;
import tronikol.projects.Library.models.Reader;
import tronikol.projects.Library.util.BookValidator;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDAO bookDAO;
    private final ReaderDAO readerDAO;
    private final BookValidator bookValidator;

    @Autowired
    public BookController(BookDAO bookDAO, ReaderDAO readerDAO, BookValidator bookValidator) {
        this.bookDAO = bookDAO;
        this.readerDAO = readerDAO;
        this.bookValidator = bookValidator;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    // страница создания нового пользователя
    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping()
    public String create(@Valid Book book, BindingResult bindingResult) {
        bookValidator.validate(book, bindingResult);
        if(bindingResult.hasErrors()){
            return "books/new";
        }
        bookDAO.add(book);
        return "redirect:/books";
    }

    // Страница с информацией о книге, также о пользователе который ее взял
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("reader") Reader reader) {
        model.addAttribute("book", bookDAO.get(id));
        model.addAttribute("owner", bookDAO.getBookOwner(id));
        // В модель помещается список всех пользователей, для выдачи в списке
        model.addAttribute("readers", readerDAO.index());
        return "books/show";
    }

    // Страница изменения книги
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDAO.get(id));
        return "books/edit";
    }
    // Изменение книги
    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult){
        bookValidator.validate(book, bindingResult);
        if(bindingResult.hasErrors()){
            return "books/edit";
        }
        bookDAO.update(id, book);
        return "redirect:/books/"+id;
    }
    // Выдача книги читателю
    @PatchMapping("{id}/give")
    public String give(@PathVariable("id") int id, @ModelAttribute("reader") Reader reader) {
        bookDAO.give(id, reader);
        return "redirect:/books/" + id;
    }
    // Возврат книги в библиотеку
    @PatchMapping("{id}/free")
    public String free(@PathVariable("id") int id) {
        bookDAO.free(id);
        return "redirect:/books/" + id;
    }
    // Удаление книги
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDAO.delete(id);
        return "redirect:/books";
    }


}
