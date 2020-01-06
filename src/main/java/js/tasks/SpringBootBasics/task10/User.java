package js.tasks.SpringBootBasics.task10;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message="Name is mandatory.")
    private String name;
    @NotBlank(message="Email is mandatory.")
    private String email;

    public User() {
    }

    public User(@NotBlank(message = "Name is mandatory.") String name, @NotBlank(message = "Email is mandatory.") String email) {
        this.name = name;
        this.email = email;
    }
}
