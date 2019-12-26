package js.tasks.SpringBootBasics.task9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getBooks")
    public String getBooks(Model model){
        model.addAttribute("bookList", bookService.getBooks());
        return "bookPage";
    }
}
