package js.tasks.SpringBootBasics.task5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByName(String name);

    List<Animal> findByAge(int age);

    List<Animal> findByNameAndAge(String name, int age);

    List<Animal> findFirst3ByOrderByNameAsc();


}
