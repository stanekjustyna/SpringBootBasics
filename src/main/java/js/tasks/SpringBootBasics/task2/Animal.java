package js.tasks.SpringBootBasics.task2;

import lombok.Data;
import org.springframework.context.annotation.Scope;

@Data
@Scope("singleton")
public class Animal {

    private int id;
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
