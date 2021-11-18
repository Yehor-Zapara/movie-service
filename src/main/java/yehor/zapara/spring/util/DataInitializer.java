package yehor.zapara.spring.util;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import yehor.zapara.spring.model.Role;
import yehor.zapara.spring.model.User;
import yehor.zapara.spring.service.AuthenticationService;
import yehor.zapara.spring.service.RoleService;
import yehor.zapara.spring.service.UserService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public DataInitializer(RoleService roleService,
                           AuthenticationService authenticationService,
                           UserService userService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostConstruct
    public void injectData() {
        Role adminRole = roleService.add(new Role(Role.RoleName.ADMIN));
        User userAlice = new User();
        userAlice.setEmail("alice12@mail.com");
        userAlice.setPassword("12345");
        userAlice.setRoles(Set.of(adminRole));
        userService.add(userAlice);
        roleService.add(new Role(Role.RoleName.USER));
        authenticationService
                .register("bobby@mail.ua", "qwerty");
    }
}
