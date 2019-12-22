package js.tasks.SpringBootBasics.task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SampleDataInitializer {

    private AnimalRepository animalRepository;
    private static Logger LOG = LoggerFactory.getLogger(SampleDataInitializer.class);

    @Autowired
    public SampleDataInitializer(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostConstruct
    public void init(){

        LOG.warn("init");
        Animal a1 = new Animal(1L, "Reksio", 3);
        Animal a2 = new Animal(2l, "Burek", 4);
        Animal a3 = new Animal(3L, "Kulka", 5);
        animalRepository.save(a1);
        animalRepository.save(a2);
        animalRepository.save(a3);
    }
}
