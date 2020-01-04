package js.tasks.SpringBootBasics.task9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBooksNull")
    public String getBooksNull(Model model){
        final Model books = model.addAttribute("bookList", null);
        return "bookPage";
    }

    @GetMapping("/getBooks")
    public String getBooks(Model model){
        final Model books = model.addAttribute("bookList", bookService.getBooks());
        return "bookPage";
    }

    @GetMapping("/showdetails/{id}")
    public String showDetails(@PathVariable("id") long id, Model model){
        Book b = bookService.getBook(id);
        model.addAttribute("book", b);
        return "bookDetails";
    }

    @GetMapping("/addBook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/addBookToList")
    public String addBookToList(Book book, Model model){
        bookService.addBook(book);
        final Model books =  model.addAttribute("bookList", bookService.getBooks() );
        return "bookPage";
    }
}
