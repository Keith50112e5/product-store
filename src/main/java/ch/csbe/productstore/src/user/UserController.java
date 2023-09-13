package ch.csbe.productstore.src.user;

import ch.csbe.productstore.src.user.dto.UserCreateDto;
import ch.csbe.productstore.src.user.dto.UserDetailDto;
import ch.csbe.productstore.src.user.dto.UserShowDto;
import ch.csbe.productstore.src.user.dto.UserUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name="UserController", description="Controller für die Benutzer.")
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping()
    @Operation(summary = "Findet eine Liste aller Benutzer.", description = "Gibt die zu anzuzeigende Werte der Kategorien als Liste zurück.")
    public List<UserShowDto> getUsers(){
        return userService.get();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Findet einen Benutzer durch die ID.", description = "Gibt die Details mittels ID des Benutzers zurück.")
    public UserDetailDto getUser(
            @Parameter(description = "Die ID des Benutzers.")
            @PathVariable("id") Integer id){
        return userService.getById(id);
    }
    @PostMapping("/signup")
    @Operation(summary = "Registriert einen Benutzer.", description = "Gibt die Details mittels gegebenen Details des Benutzers zurück.")
    public UserDetailDto register(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Benutzer-Erstellwerte.")
            @RequestBody UserCreateDto userCreateDto){
        return userService.create(userCreateDto);
    }
    @PostMapping("/signin")
    @Operation(summary = "Loggt einen Benutzer ein.", description = "Gibt die Details mittels gegebenen Details des Benutzers zurück.")
    public UserDetailDto login(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Details des Benutzers.")
            @RequestBody UserDetailDto userDetailDto){
        return userService.login(userDetailDto);
    }
    @PutMapping("/{id}")
    @Operation(summary = "Bearbeitet einen Benutzer.", description = "Gibt die Details mittels ID und Bearbeitungswerte des Benutzers zurück.")
    public UserDetailDto putUser(
            @Parameter(description = "Die ID des Benutzers.")
            @PathVariable("id") Integer id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Benutzer-Bearbeitungswerte.")
            @RequestBody UserUpdateDto userUpdateDto){
        return userService.update(id,userUpdateDto);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht einen Benutzer.", description = "Gibt ein OK mittels ID zurück.")
    public void deleteUser(
            @Parameter(description = "Die ID des Benutzers.")
            @PathVariable("id") Integer id){
        userService.delete(id);
    }

}