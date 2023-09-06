package ch.csbe.productstore.src.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public List<User> getUsers(){
        return userService.get();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getById(id);
    }
    @PostMapping("/signup")
    public User register(@RequestBody User user){
        return userService.create(user);
    }
    @PostMapping("/signin")
    public User login(@RequestBody User user){
        return userService.login(user);
    }
    @PutMapping("/{id}")
    public User putUser(@PathVariable("id") Integer id,@RequestBody User user){
        return userService.update(id,user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.delete(id);
    }

}