package js.tasks.SpringBootBasics.task6;

import js.tasks.SpringBootBasics.task5.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Task06Controller{

    @GetMapping("/exception")
    public List<Animal> throwException() {
        throw new CustomException();
    }
}
