package js.tasks.SpringBootBasics.task9;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<Book>();
    }

    @PostConstruct
    public void init(){

        Book bookA = new Book();
        bookA.setId(1);
        bookA.setAuthor("AAuthor");
        bookA.setTitle("ATitle");
        bookList.add(bookA);

        Book bookB = new Book();
        bookB.setId(2);
        bookB.setAuthor("BAuthor");
        bookB.setTitle("BTitle");
        bookList.add(bookB);

        Book bookC = new Book();
        bookC.setId(3);
        bookC.setAuthor("CAuthor");
        bookC.setTitle("CTitle");
        bookList.add(bookC);
    }

    public List<Book> getBooks(){
        return bookList;
    }

    public Book getBook(long id){
        for(Book b: bookList){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }
}
