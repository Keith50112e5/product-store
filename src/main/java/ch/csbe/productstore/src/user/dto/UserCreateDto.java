package ch.csbe.productstore.src.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO für die Erstellansicht eines Benutzers")
public class UserCreateDto {
    private String email;
    private String pw;
    private Boolean is_admin;
}
