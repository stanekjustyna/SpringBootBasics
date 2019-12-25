package js.tasks.SpringBootBasics.task5;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name cannot be null.")
    @NotBlank(message = "Name cannot be blank." )
    @Size(min = 3, message = "Name should contain at least 3 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Name should contain only alphanumeric signs.")
    private String name;

    @Min(value = 3, message = "Animal should be older than 3.")
    @Max(value = 5, message = "Animal should be younger than 5.")
    private int age;

    public Animal() {
    }

    public Animal(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
