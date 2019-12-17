package js.tasks.SpringBootBasics.task2;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task02Controller {

    @GetMapping(value="/task02")
    public Animal getAnimal(){
        return new Animal(1, "Reksio", 3);
    }

    @GetMapping(value="/task02xml", produces= MimeTypeUtils.APPLICATION_XML_VALUE)
    public Animal getAnimal2(){
        return new Animal(2, "Burek", 3);
    }


}
