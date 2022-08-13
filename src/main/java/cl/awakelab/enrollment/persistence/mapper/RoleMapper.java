package cl.awakelab.enrollment.persistence.mapper;

import cl.awakelab.enrollment.domain.dto.Role;
import cl.awakelab.enrollment.persistence.entity.RolEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mappings({
            @Mapping(source = "rolId", target = "roleId"),
            @Mapping(source = "rolName", target = "roleName"),
    })
    Role toRole(RolEntity rol);
    List<Role> toRoles(Iterable<RolEntity> roles);
    @InheritInverseConfiguration
    RolEntity toRolEntity(Role role);
}
