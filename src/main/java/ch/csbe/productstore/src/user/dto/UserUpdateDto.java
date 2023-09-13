package ch.csbe.productstore.src.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO für die Updateansicht eines Benutzers")
public class UserUpdateDto {
    private String name;
    private Integer active;
    private String email;
}
