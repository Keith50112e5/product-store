package ch.csbe.productstore.resources.user;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUsers();
    User findUserById(Integer id);
}
