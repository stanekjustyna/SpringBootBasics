package js.tasks.SpringBootBasics.task10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/userList")
    public String getUsers(Model model){
        if(userRepository.count() == 0){
            model.addAttribute("userList", null);
        }else {
            model.addAttribute("userList", userRepository.findAll());
        }
        return "task10/userList";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        model.addAttribute("user", user);
        return "task10/updateUser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, Model model){
        userRepository.save(user);
        model.addAttribute("userList", userRepository.findAll());
        return "task10/userList";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        userRepository.delete(user);
        if(userRepository.count() == 0){
            model.addAttribute("userList", null);
        }else {
            model.addAttribute("userList", userRepository.findAll());
        }
        return "task10/userList";
    }

    @GetMapping("addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "task10/addUser";
    }

    @PostMapping("saveUser")
    public String saveUser(Model model, @Valid User user){
        userRepository.save(user);
        model.addAttribute("userList", userRepository.findAll());
        return "task10/userList";
    }
}
