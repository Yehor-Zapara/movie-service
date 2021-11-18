package yehor.zapara.spring.service.impl;

import java.util.Set;
import org.springframework.stereotype.Service;
import yehor.zapara.spring.model.Role;
import yehor.zapara.spring.model.User;
import yehor.zapara.spring.service.AuthenticationService;
import yehor.zapara.spring.service.RoleService;
import yehor.zapara.spring.service.ShoppingCartService;
import yehor.zapara.spring.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService
                .getRoleByName(Role.RoleName.USER.name())));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
