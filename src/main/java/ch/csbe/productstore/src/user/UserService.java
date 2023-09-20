package ch.csbe.productstore.src.user;

import ch.csbe.productstore.src.auth.LoginRequestDto;
import ch.csbe.productstore.src.user.dto.UserCreateDto;
import ch.csbe.productstore.src.user.dto.UserDetailDto;
import ch.csbe.productstore.src.user.dto.UserShowDto;
import ch.csbe.productstore.src.user.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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

    public String hashPassword(String plainPassword) {
        return encoder.encode(plainPassword);
    }

    public UserDetailDto create(UserCreateDto userCreateDto) {
        User user = userMapper.toEntity(userCreateDto);
        user.setPw(hashPassword(user.getPw()));
        User save = userRepository.save(user);
        return userMapper.toDetailDto(save);
    }
    public UserDetailDto promote(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        user.setIsAdmin(Boolean.TRUE);
        User save = userRepository.save(user);
        return userMapper.toDetailDto(save);
    }
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        userRepository.delete(user);
    }

    public User getUserWithCredentials(LoginRequestDto loginRequestDto) {
        User user = userRepository.findUserByEmail(loginRequestDto.getEmail());
        boolean pwMatch = encoder.matches(loginRequestDto.getPw(), user.getPw());
        if (pwMatch) {
            return user;
        } else {
            return null;
        }
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

}
