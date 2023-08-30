package ch.csbe.productstore.resources.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/")
    public String getUsers(){
        return "getUsers";
    }
    @GetMapping("/{id}")
    public String getUser( @PathVariable("id") int id ){
        return "getUser "+id;
    }
    @PostMapping("/signup")
    public String register(){
        return "register";
    }
    @PostMapping("/signin")
    public String login(){
        return "login";
    }
    @PutMapping("/{id}")
    public String putUser( @PathVariable("id") int id ){
        return "promotion "+id;
    }
    @DeleteMapping("/{id}")
    public String deleteUser( @PathVariable("id") int id ){
        return "deleteUser "+id;
    }

}