package js.tasks.SpringBootBasics.task7;

import js.tasks.SpringBootBasics.task5.Animal;
import js.tasks.SpringBootBasics.task5.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Task07Controller {

    private AnimalRepository animalRepository;

    @Autowired
    public Task07Controller(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostMapping("/validateAnimal")
    public void validateAnimals(@Valid @RequestBody Animal animal){
        animalRepository.save(animal);
    }
}
