package yehor.zapara.spring.service.impl;

import org.springframework.stereotype.Service;
import yehor.zapara.spring.dao.RoleDao;
import yehor.zapara.spring.model.Role;
import yehor.zapara.spring.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).get();
    }
}
