package js.tasks.SpringBootBasics.task3;

import js.tasks.SpringBootBasics.task2.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Task03Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Task03Controller.class);

    @PostMapping("/task03")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnima(@RequestBody Animal animal){
        LOG.info("Received Animal {}", animal);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello World!");
    }

    @GetMapping("/custom/header")
    public ResponseEntity<String> cumstomHeader(){
        return ResponseEntity.ok()
                .header("Custom-Header", "My-Header")
                .body("Hello World!");
    }

    @PostMapping("/animal")
    public ResponseEntity<String> addAnimal(@RequestBody Animal animal){
        LOG.info("Received animal: {}", animal);

        return ResponseEntity.ok()
                .header("Custom-Header", "My-Header")
                .body("Thank you, animal received!");
    }






}
