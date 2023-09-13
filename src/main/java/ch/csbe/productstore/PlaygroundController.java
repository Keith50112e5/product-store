package ch.csbe.productstore;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("playground")
public class PlaygroundController {
    @GetMapping("hello-world")
    @Operation(summary = "Beispiel-Endpunkt für die Einführung von Java Spring Boot.", description = "Da es nur ein Beispiel ist könnte es gelöscht werden, aus Vollständigkeitsgründen wird dies jedoch beibehalten.")
    public String helloWorld(){
        return "Hello Java Spring Boot";
    }
}
