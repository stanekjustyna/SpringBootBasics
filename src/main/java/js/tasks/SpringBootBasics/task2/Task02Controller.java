package js.tasks.SpringBootBasics.task2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task02Controller {

    @GetMapping("/task02")
    public Animal getAnimal(){
        return new Animal(1, "Reksio", 3);
    }
}
