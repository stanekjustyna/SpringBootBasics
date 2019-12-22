package js.tasks.SpringBootBasics.task5;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
