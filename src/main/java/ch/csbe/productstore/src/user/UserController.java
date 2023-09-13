package ch.csbe.productstore.src.user;

import ch.csbe.productstore.src.auth.LoginRequestDto;
import ch.csbe.productstore.src.auth.TokenService;
import ch.csbe.productstore.src.auth.TokenWrapper;
import ch.csbe.productstore.src.user.dto.UserCreateDto;
import ch.csbe.productstore.src.user.dto.UserDetailDto;
import ch.csbe.productstore.src.user.dto.UserShowDto;
import ch.csbe.productstore.src.user.dto.UserUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name="UserController", description="Controller für die Benutzer.")
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @GetMapping()
    @Operation(summary = "Findet eine Liste aller Benutzer.", description = "Gibt die zu anzuzeigende Werte der Kategorien als Liste zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public List<UserShowDto> getUsers(){
        return userService.get();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Findet einen Benutzer durch die ID.", description = "Gibt die Details mittels ID des Benutzers zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public UserDetailDto getUser(
            @Parameter(description = "Die ID des Benutzers.")
            @PathVariable("id") Integer id){
        return userService.getById(id);
    }

    @PostMapping("/signup")
    @Operation(summary = "Registriert einen Benutzer.", description = "Gibt die Details mittels gegebenen Details des Benutzers zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public UserDetailDto register(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Benutzer-Erstellwerte.")
            @RequestBody UserCreateDto userCreateDto){
        return userService.create(userCreateDto);
    }
    @PostMapping("/signin")
    @Operation(summary = "Loggt einen Benutzer ein.", description = "Gibt die Details mittels gegebenen Details des Benutzers zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public TokenWrapper login(@RequestBody LoginRequestDto loginRequestDto) {
        User user = this.userService.getUserWithCredentials(loginRequestDto);
        if (user != null) {
            TokenWrapper tokenWrapper = new TokenWrapper();
            String token = this.tokenService.generateToken(user);
            tokenWrapper.setToken(token);
            return tokenWrapper;
        } else {
            // Errorhandling.
            // Either return 401 or 400
            return null;
        }
    }
    @PutMapping("/{id}")
    @Operation(summary = "Bearbeitet einen Benutzer.", description = "Gibt die Details mittels ID und Bearbeitungswerte des Benutzers zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public UserDetailDto putUser(
            @Parameter(description = "Die ID des Benutzers.")
            @PathVariable("id") Integer id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Die Benutzer-Bearbeitungswerte.")
            @RequestBody UserUpdateDto userUpdateDto){
        return userService.update(id,userUpdateDto);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Löscht einen Benutzer.", description = "Gibt ein OK mittels ID zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public void deleteUser(
            @Parameter(description = "Die ID des Benutzers.")
            @PathVariable("id") Integer id){
        userService.delete(id);
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/admin/{id}")
    @Operation(summary = "Funktion zur theoretischen Rollenbearbeitung.", description = "Bearbeitet in der Theorie die Rolle des Benutzers mittels ID zurück.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Es hat erfolgreich funktioniert."),
            @ApiResponse(responseCode = "404", description = "Es hat nicht funktioniert, da der Eintrag mit der Id nicht gefunden wurde."),
            @ApiResponse(responseCode = "403", description = "Es hat nicht funktioniert, da der Benutzer nicht Authentifiziert ist."),
    })
    public String setAdmin(@PathVariable("id")UUID id) {
        return "User mit der Id " + id + " wäre nun theoretisch Admin!";
    }

}