package yehor.zapara.spring.dao;

import java.util.Optional;
import yehor.zapara.spring.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
