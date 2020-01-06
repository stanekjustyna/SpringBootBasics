package js.tasks.SpringBootBasics.task10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SampleUserInitializator {

    private UserRepository userRepository;

    @Autowired
    public SampleUserInitializator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init(){
        userRepository.save(new User("Jan", "jan.kowalski@gmail.com"));
        userRepository.save(new User("Stefan", "stefan.nowak@gmail.com"));
        userRepository.save(new User("Jadwiga", "jadwiga.kowalczyk@gmail.com"));
    }
}
