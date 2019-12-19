package js.tasks.SpringBootBasics.task4;

import js.tasks.SpringBootBasics.task2.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task04Controller {

    private AnimalService animalService;

    @Autowired
    public Task04Controller(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(value = "/task4", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public Animal getAnimal(){
        return animalService.createAndGetAnimal();
    }

}
