package yehor.zapara.spring.service;

import yehor.zapara.spring.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(String roleName);
}
