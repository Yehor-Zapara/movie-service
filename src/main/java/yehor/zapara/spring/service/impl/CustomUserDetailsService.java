package yehor.zapara.spring.service.impl;

import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yehor.zapara.spring.model.User;
import yehor.zapara.spring.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByEmail(username);
        UserBuilder userBuilder;
        if (optionalUser.isPresent()) {
            userBuilder =
                    org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(optionalUser.get().getPassword());
            userBuilder.roles(optionalUser.get().getRoles().stream()
                    .map(r -> r.getRoleName().name())
                    .toArray(String[]::new));
            return userBuilder.build();
        }
        throw new UsernameNotFoundException("User not found" + username);
    }
}
