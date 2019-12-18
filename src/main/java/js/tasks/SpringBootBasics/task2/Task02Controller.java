package js.tasks.SpringBootBasics.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;

@RestController
public class Task02Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Task02Controller.class);

    @GetMapping(value="/task02", produces=MimeTypeUtils.APPLICATION_JSON_VALUE)
    public Animal getAnimal(){
        return new Animal(1, "Dog", 3);
    }

    @GetMapping(value="/task02xml", produces= MimeTypeUtils.APPLICATION_XML_VALUE)
    public Animal getAnimal2(){
        return new Animal(2, "Cat", 3);
    }

    @GetMapping("/task02/animalList")
    public List<Animal> getAnimals(){

        return Arrays.asList(new Animal(3, "Horse",4), new Animal(4, "Lion", 6));
    }

    @GetMapping("/task02/log")
    public Animal getAnimal3(@RequestHeader("Accept") String accept, @RequestHeader HttpHeaders headers){
        LOG.info("accept header {}", accept);
        headers.forEach(
                (name, value) -> LOG.info("header name: {}, header value {}", name, value)
        );

        return new Animal(5, "tiger", 7);
    }

}
