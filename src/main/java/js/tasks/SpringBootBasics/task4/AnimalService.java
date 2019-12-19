package js.tasks.SpringBootBasics.task4;

import js.tasks.SpringBootBasics.task2.Animal;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    public Animal createAndGetAnimal(){
        return new Animal(1, "Elephant", 10);
    }
}
