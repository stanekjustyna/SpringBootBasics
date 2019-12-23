package js.tasks.SpringBootBasics.task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Task05Controller {

    private AnimalRepository animalRepository;

    @Autowired
    public Task05Controller(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostMapping("/createAndSaveAnimal")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAndSaveAnimal(@RequestBody Animal animal){
        animalRepository.save(animal);
    }

    @GetMapping(name = "/getAllAnimals", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }
}
