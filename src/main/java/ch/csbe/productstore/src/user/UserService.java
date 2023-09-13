package ch.csbe.productstore.src.user;

import ch.csbe.productstore.src.user.dto.UserCreateDto;
import ch.csbe.productstore.src.user.dto.UserDetailDto;
import ch.csbe.productstore.src.user.dto.UserShowDto;
import ch.csbe.productstore.src.user.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    public List<UserShowDto> get() {
        List<User> users = userRepository.findAll();
        List<UserShowDto> userShowDtos = new ArrayList<>();
        for (User user : users) {
            UserShowDto userShowDto = userMapper.toShowDto(user);
            userShowDtos.add(userShowDto);
        }
        return userShowDtos;
    }
    public UserDetailDto getById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        return userMapper.toDetailDto(user);
    }
    public UserDetailDto login(UserDetailDto userDetailDto) {
        return userDetailDto;
    }
    public UserDetailDto create(UserCreateDto userCreateDto) {
        User user = userMapper.toEntity(userCreateDto);
        User save = userRepository.save(user);
        return userMapper.toDetailDto(save);
    }
    public UserDetailDto update(Integer id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        userMapper.update(userUpdateDto,user);
        User save = userRepository.save(user);
        return userMapper.toDetailDto(save);
    }
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        userRepository.delete(user);
    }

}
