package js.tasks.SpringBootBasics.task8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String main(Model model) {
        return "main";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("date", DateFormat.getDateInstance().format(new Date()));
        return "greeting";
    }
}
