package ch.csbe.productstore.src.user;

import ch.csbe.productstore.src.user.dto.UserCreateDto;
import ch.csbe.productstore.src.user.dto.UserDetailDto;
import ch.csbe.productstore.src.user.dto.UserShowDto;
import ch.csbe.productstore.src.user.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping()
    public List<UserShowDto> getUsers(){
        return userService.get();
    }
    @GetMapping("/{id}")
    public UserDetailDto getUser(@PathVariable("id") Integer id){
        return userService.getById(id);
    }
    @PostMapping("/signup")
    public UserDetailDto register(@RequestBody UserCreateDto userCreateDto){
        return userService.create(userCreateDto);
    }
    @PostMapping("/signin")
    public UserDetailDto login(@RequestBody UserDetailDto userDetailDto){
        return userService.login(userDetailDto);
    }
    @PutMapping("/{id}")
    public UserDetailDto putUser(@PathVariable("id") Integer id,@RequestBody UserUpdateDto userUpdateDto){
        return userService.update(id,userUpdateDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.delete(id);
    }

}