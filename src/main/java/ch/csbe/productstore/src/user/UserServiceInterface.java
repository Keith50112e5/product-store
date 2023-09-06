package ch.csbe.productstore.src.user;

import java.util.List;

public interface UserServiceInterface {
    List<User> get();
    User getById(Integer id);
    User login(User user);
    User create(User user);
    User update(Integer id, User userNew);
    void delete(Integer id);
}
