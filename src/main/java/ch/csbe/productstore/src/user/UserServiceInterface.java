package ch.csbe.productstore.src.user;

import ch.csbe.productstore.src.user.dto.UserCreateDto;
import ch.csbe.productstore.src.user.dto.UserDetailDto;
import ch.csbe.productstore.src.user.dto.UserShowDto;
import ch.csbe.productstore.src.user.dto.UserUpdateDto;

import java.util.List;

public interface UserServiceInterface {
    List<UserShowDto> get();
    UserDetailDto getById(Integer id);
    UserDetailDto create(UserCreateDto userCreateDto);
    UserDetailDto update(Integer id, UserUpdateDto userUpdateDto);
    void delete(Integer id);
}
