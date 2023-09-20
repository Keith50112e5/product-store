package ch.csbe.productstore.src.user;

import ch.csbe.productstore.src.user.dto.UserCreateDto;
import ch.csbe.productstore.src.user.dto.UserDetailDto;
import ch.csbe.productstore.src.user.dto.UserShowDto;
import ch.csbe.productstore.src.user.dto.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring"
)
public abstract class UserMapper {
    public abstract User toEntity(UserCreateDto productCreateDto);
    public abstract UserShowDto toShowDto(User user);
    public abstract UserDetailDto toDetailDto(User user);
    public abstract void update(UserUpdateDto userUpdateDto, @MappingTarget User user);
}
