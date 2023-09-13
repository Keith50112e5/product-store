package ch.csbe.productstore.src.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    private String name;
    private Integer active;
    private String email;
}
