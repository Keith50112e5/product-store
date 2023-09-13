package ch.csbe.productstore.src.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO für die Anzeigeansicht eines Benutzers")
public class UserShowDto {
    private String email;
    private String pw;
}
