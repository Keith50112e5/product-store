package ch.csbe.productstore.src.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailDto {
    private Integer id;
    private String name;
    private Integer active;
    private String email;
}
