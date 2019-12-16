package js.tasks.SpringBootBasics.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class FirstSpringController {

    //@GetMapping("hello")
    @RequestMapping(method = RequestMethod.GET, path="hello")
    public String hello(@RequestParam(value="name", defaultValue = "World" ) String name){

        return "Hello, " + name + "!";
    }

    @GetMapping("favourite/{number}")
    public String getFavouriteNumber(@PathVariable int number){
        return "Hello, your favourite number is: " + number;
    }

    @GetMapping("favourite2/{number}")
    public String getFavouriteNumber2(@PathVariable("number") String number, @RequestParam(value="name", defaultValue="World") String name){

        StringBuilder sb = new StringBuilder("Hello");
        if(!StringUtils.isEmpty(name)){
            sb.append(" ").append(name);
        }
        sb.append(", your favourite number is: ");
        sb.append(Objects.nonNull(number) && number.matches("\\d+") ? number : "NaN");

        return sb.toString();
    }

}
