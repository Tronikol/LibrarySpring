package tronikol.projects.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tronikol.projects.Library.dao.BookDAO;
import tronikol.projects.Library.dao.ReaderDAO;
import tronikol.projects.Library.models.Book;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDAO bookDAO;
    private final ReaderDAO readerDAO;

    @Autowired
    public BookController(BookDAO bookDAO, ReaderDAO readerDAO) {
        this.bookDAO = bookDAO;
        this.readerDAO = readerDAO;
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
    public String addBook(Book book) {
        bookDAO.add(book);
        return "redirect:/books";
    }

    // Страница с информацией о книге, также о пользователе который ее взял
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("bookWithReader", bookDAO.getWithReader(id));
        return "books/show";
    }

}
