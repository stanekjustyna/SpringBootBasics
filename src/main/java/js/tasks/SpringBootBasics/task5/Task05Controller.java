package js.tasks.SpringBootBasics.task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Task05Controller {

    private AnimalRepository animalRepository;
    private static Logger LOG = LoggerFactory.getLogger(Task05Controller.class);

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

    @DeleteMapping("/deleteAnimal/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if(animalRepository.findById(id).isPresent()){
            animalRepository.deleteById(id);
            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAnimalById/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable long id){
        LOG.info("Searching for Animal id= {}", id);

        Optional<Animal> animal = animalRepository.findById(id);

        if(animal.isPresent()){
            LOG.info("Found animal: {}", animal.get());
            return ResponseEntity.ok(animal.get());
        }else{
            LOG.info("No animal found");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveAnimals")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAnimals(@RequestBody List<Animal> animals){
        animalRepository.saveAll(animals);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Animal>> findByName(@PathVariable String name){
        LOG.info("Searching for animal: name= {}", name);

        if(animalRepository.findByName(name).isEmpty()){
            LOG.warn("No animal found.");
            return ResponseEntity.notFound().build();
        }else{
            List<Animal> animals = animalRepository.findByName(name);
            return ResponseEntity.ok(animals);
        }
    }

    @GetMapping("/findByAge")
    public List<Animal> findByAge(@RequestParam int age){
        return animalRepository.findByAge(age);
    }

    @GetMapping("/findByNameAndAge")
    public List<Animal> findByNameAndAge(@RequestParam String name, @RequestParam int age){
        return animalRepository.findByNameAndAge(name, age);
    }

    @GetMapping("/findFirst3ByOrderByNameAsc")
    public List<Animal> findFirst3ByOrderByNameAsc(){
        return animalRepository.findFirst3ByOrderByNameAsc();
    }





}
