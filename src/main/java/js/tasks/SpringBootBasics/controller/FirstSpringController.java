package js.tasks.SpringBootBasics.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstSpringController {

    //@GetMapping("hello")
    @RequestMapping(method = RequestMethod.GET, path="hello")
    public String hello(@RequestParam(value="name", defaultValue = "World" ) String name){

        return "Hello, " + name + "!";
    }
}
