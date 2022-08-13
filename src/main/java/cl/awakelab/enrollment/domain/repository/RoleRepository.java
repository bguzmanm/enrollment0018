package cl.awakelab.enrollment.domain.repository;

import cl.awakelab.enrollment.domain.dto.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Optional<List<Role>> findAll();
    Optional<Role> findById(int roleId);
    Optional<Role> findByRolName(String roleName);
    Role save(Role role);
    void delete(int roleId);
}
