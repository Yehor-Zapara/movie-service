package yehor.zapara.spring.service;

import java.util.Optional;
import yehor.zapara.spring.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
