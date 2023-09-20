package ch.csbe.productstore.src.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO für den Token eines Benutzers")
public class TokenWrapper {
    private String token;
}
