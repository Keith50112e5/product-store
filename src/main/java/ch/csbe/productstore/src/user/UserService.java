package ch.csbe.productstore.src.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;
    public List<User> get() {return userRepository.findAll();}
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
    }
    public User login(User user) {
        return user;
    }
    public User create(User user) {
        return userRepository.save(user);
    }
    public User update(Integer id, User userNew) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        user.setUser(userNew);
        return userRepository.save(user);
    }
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("ID: "+id+" not found!"));
        userRepository.delete(user);
    }

}
