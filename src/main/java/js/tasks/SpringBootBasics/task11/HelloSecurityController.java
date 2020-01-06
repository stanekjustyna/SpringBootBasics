package js.tasks.SpringBootBasics.task11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloSecurityController {

    @GetMapping("/hello1")
    public String getHello(){
        return "task11/hello";
    }

    @GetMapping("/hellosecurity")
    public String greeting(Model model) {
        return "task11/hellosecurity";
    }
}
