package cl.awakelab.enrollment.persistence.repository;

import cl.awakelab.enrollment.domain.dto.Role;
import cl.awakelab.enrollment.domain.repository.RoleRepository;
import cl.awakelab.enrollment.persistence.crud.RolCrud;
import cl.awakelab.enrollment.persistence.mapper.RoleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolRepository implements RoleRepository {

    private final RolCrud crud;
    private final RoleMapper mapper;

    public RolRepository(RolCrud crud, RoleMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Role>> findAll() {
        return Optional.of(mapper.toRoles(crud.findAll()));
    }

    @Override
    public Optional<Role> findById(int rolId) {
        return crud.findById(rolId)
                .map(mapper::toRole);
    }

    @Override
    public Optional<Role> findByRolName(String rolName) {
        return crud.findByRolName(rolName)
                .map(mapper::toRole);
    }

    @Override
    public Role save(Role rol) {
        return mapper.toRole(crud.save(mapper.toRolEntity(rol)));
    }

    @Override
    public void delete(int rolId) {
        crud.deleteById(rolId);
    }
}
