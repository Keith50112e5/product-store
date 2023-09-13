package ch.csbe.productstore;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("playground")
public class PlaygroundController {
    @GetMapping("hello-world")
    public String helloWorld(){
        return "Hello Java Spring Boot";
    }
}
