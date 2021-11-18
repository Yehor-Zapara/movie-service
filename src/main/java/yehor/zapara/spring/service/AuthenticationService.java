package yehor.zapara.spring.service;

import yehor.zapara.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
